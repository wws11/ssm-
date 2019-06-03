package com.soecode.lyf.log.service.impl;

import com.soecode.lyf.log.pojo.LogInfo;
import com.soecode.lyf.log.service.LogService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 14:09
 */

@Service
public class LogServiceImpl  implements LogService {
    @Override
    public void saveLog(LogInfo logInfo) {
        System.out.println("执行保存操作,保存的日志信息为"+logInfo.toString());
    }
}
