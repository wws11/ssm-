package com.soecode.lyf.bookuserservice.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图书实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
@ApiModelProperty("图书ID")
	private long bookId;
	@ApiModelProperty("图书名称")
	private String name;
	@ApiModelProperty("馆藏数量")
	private int number;


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + "]";
	}


}
