package com.soecode.lyf.bookuserservice.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/22 18:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPararm {
    @ApiModelProperty("测试特殊字符串")
    private   String   str;
}
