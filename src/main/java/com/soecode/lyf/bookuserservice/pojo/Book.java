package com.soecode.lyf.bookuserservice.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/18 13:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book implements Serializable {

    private Integer id;
    @ApiModelProperty("图书名称")
    private String name;
    @ApiModelProperty("馆藏数量")
    private int number;




    @Override
    public String toString() {
        return "Book [bookId=" + id + ", name=" + name + ", number=" + number + "]";
    }


}
