package com.soecode.lyf.log.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {


    /**
     * 操作模块
     */
    private String operationModel;
    /**
     * 操作功能
     */
    private String operationFunction;

    /**
     * 操作说明
     */
    private String operationExplain;
    /**
     * 账号信息
     */

    private String accountInfo;
    /**
     * ip归属地
     */
    private String ip;

    /**
     * 操作时间
     */

    private Date operationTime;

}
