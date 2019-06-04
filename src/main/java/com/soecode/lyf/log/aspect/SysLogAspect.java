package com.soecode.lyf.log.aspect;

import com.mchange.v1.util.ArrayUtils;
import com.soecode.lyf.datasource.DataSourceAspect;
import com.soecode.lyf.log.annatation.LogRequire;
import com.soecode.lyf.log.annatation.LogUser;
import com.soecode.lyf.log.pojo.LogInfo;
import com.soecode.lyf.log.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;


/**
 * @Description 日志切面
 * @Author DJZ-WWS
 * @Date 2019/6/3 14:04
 */

@Aspect
@Component
public class SysLogAspect {
    static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.soecode.lyf.log.annatation.LogRequire)")
    public void log() {
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint) throws UnknownHostException {
        System.out.println("=====SysLogAspect后置通知开始=====，开始记录日志信息");
        LogInfo logInfo = new LogInfo();
        //记录基本信息
        Class<?> target = joinPoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        //记录用户信息  获取参数里面加LogUser注解的值，表示用户信息
        //获取参数上所有的注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        //判断注解LogUser是否存在

        for (Annotation[] paraeterAnnotation : parameterAnnotations) {
            //获取注解的索引
            int paramIndex = ArrayUtils.indexOf(parameterAnnotations, paraeterAnnotation);
            //获取注解标记的值

            for (Annotation annotation : paraeterAnnotation) {
                if (annotation instanceof LogUser) {
                    Object[] args = joinPoint.getArgs();
                    Object value = args[paramIndex];
                    logInfo.setAccountInfo(value.toString());
                }
            }
        }
        //获取注解上的值
        LogRequire logRequire = null;
        logRequire = this.getLogRequire(target, method);
        //从接口初始化
        if (logRequire == null) {
            for (Class<?> clazz : target.getInterfaces()) {
                logRequire = getLogRequire(clazz, method);
                if (logRequire != null) {
                    break;//从某个接口中一旦发现注解，不再循环
                }
            }
        }

        if (logRequire != null && (!StringUtils.isEmpty(logRequire.operationExplain())) && (!StringUtils.isEmpty(logRequire.operationFunction())) && (!StringUtils.isEmpty(logRequire.operationModel()))) {
            ////调用日志处理类去处理我们的日志
            logInfo.setOperationModel(logRequire.operationModel());
            logInfo.setOperationFunction(logRequire.operationFunction());
            logInfo.setOperationExplain(logRequire.operationExplain());
            logInfo.setIp(this.getIp());
            logInfo.setOperationTime(new Date());
            logService.saveLog(logInfo);
        }


    }

    /**
     * 获取方法或类的注解对象DataSource
     *
     * @param target
     * @param method
     * @return
     */
    private LogRequire getLogRequire(Class<?> target, Method method) {
        try {
            //1.优先方法注解
            Class<?>[] types = method.getParameterTypes();
            Method m = target.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(LogRequire.class)) {
                return m.getAnnotation(LogRequire.class);
            }
            //2.其次类注解
            if (target.isAnnotationPresent(LogRequire.class)) {
                return target.getAnnotation(LogRequire.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(MessageFormat.format("通过注解切换数据源时发生异常[class={0},method={1}]："
                    , target.getName(), method.getName()), e);
        }
        return null;
    }


    private String getIp() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr.getHostAddress();
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress.getHostAddress();
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress.getHostAddress();
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException(
                    "Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }

}
