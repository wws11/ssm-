package com.soecode.lyf.bookuserservice.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/18 13:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

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
