package com.soecode.lyf.log.service;

import com.soecode.lyf.log.pojo.LogInfo;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 14:08
 */
public interface LogService {

    /**
     * 保存日志到数据库
     * @author   weiwensi
     * @date 14:10 2019/6/3
     *@param
     * @return
     * @throws Exception
     * @version 2.1
     **/

       void saveLog(LogInfo logInfo);
}