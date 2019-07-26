package com.soecode.lyf.log.appendlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/26 10:03
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Log {

    private String className;

    private  String  fileName;

    private  String lineNumber;

    private   String  methodName;
    private   String serverIp;
    private  String  logName;
    private   String  logLevel;
    private   String  logThread;
    /**
     * 日志时间
     */
    private Date logMills;

    private String  logMessage;
    private  String  throwMessage;
    private  String   throwDetailMessage;
    private  String  throwStackTrace;

}
