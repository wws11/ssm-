package com.soecode.lyf.log.appendlog;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/26 10:00
 */
public class DBAppender   extends AppenderSkeleton {
    Log log = new Log();
    @Override
    protected void append(LoggingEvent loggingEvent) {
        ThrowableInformation throwableInformation = loggingEvent.getThrowableInformation();
        if (throwableInformation != null) {
            loggingEvent.getMessage();
            LocationInfo locationInfo = loggingEvent.getLocationInformation();
            Throwable throwable = throwableInformation.getThrowable();
            System.out.println(loggingEvent.toString());
            //记录日志的基本信息

            try {
                log.setClassName(loggingEvent.getLocationInformation().getClassName());
                log.setFileName(loggingEvent.getLocationInformation().getFileName());
                log.setLineNumber(loggingEvent.getLocationInformation().getLineNumber());
                log.setMethodName(loggingEvent.getLocationInformation().getMethodName());
                log.setServerIp(getIp());
                log.setLogName(loggingEvent.getLoggerName());
                log.setLogLevel(loggingEvent.getLogger().getLevel().toString());
                log.setLogThread(loggingEvent.getThreadName());
                log.setLogMills(new Date(loggingEvent.getTimeStamp()));
                log.setLogMessage(loggingEvent.getMessage().toString());
                log.setThrowMessage(throwable.getMessage());
                log.setThrowDetailMessage(throwable.toString());
                log.setThrowStackTrace(throwable.getStackTrace().toString());
            } catch (Exception e) {
                errorHandler.error("日志信息封装异常");
            }
            System.out.println(log.toString());
            //logService.saveLog(log);
            saveLog(log);
            System.out.println("日志保存已经交给了线程池处理，主线程继续执行后面的业务，做到异步的效果");
        }


    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
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
    private   void  saveLog(final Log log){

        //使用线程保存日志 使用异步的方式实现日志的存储
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    //增加一个延时，看到异步的效果
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //日志的存储
               saveLogToLogStash(log);
            }
        },5, TimeUnit.MILLISECONDS);
    }

    private   void  saveLogToLogStash(Log log){
        System.out.println("日志处理层接受到日志");
        System.out.println(log);
    }

    public static void main(String[] args) {

        Double a=2.111;
        Double b=2.0;
        BigDecimal cc =BigDecimal.ZERO;
        BigDecimal ba = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        BigDecimal subtract = ba.subtract(bb);
        System.out.println(subtract);
        System.out.println(subtract.doubleValue());
        BigDecimal add=new BigDecimal(0);
        for (int i = 0; i <5 ; i++) {
            Double  c=1.0;
            cc = cc.add(new BigDecimal(Double.toString(c)));

        }
        System.out.println(cc);
    }
}
