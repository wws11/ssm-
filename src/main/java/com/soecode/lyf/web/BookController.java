package com.soecode.lyf.web;

import java.util.List;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.enums.AppointStateEnum;
import com.soecode.lyf.exception.NoNumberException;
import com.soecode.lyf.exception.RepeatAppointException;
import com.soecode.lyf.service.BookService;
@RestController
@CrossOrigin
@Api(value = "swagger测试测试")
@RequestMapping("/book")
public class BookController {


	@Autowired
	private BookService bookService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiOperation(notes = "获取所有的书",value = "获取所有的书",produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Book> list() {
		List<Book> list = bookService.getList();
		return list;
	}

	@GetMapping(value = "/detail/{bookId}")
	@ApiOperation(value = "根据书的id获取书的详情", notes = "根据书的id获取书的详情", produces = MediaType.APPLICATION_JSON_VALUE)
	private Book detail(@PathVariable("bookId") Long bookId) {

		Book book = bookService.getById(bookId);

		return book;
	}

	@PostMapping(value = "/{bookId}/appoint")
	@ApiOperation(notes = "卖书",value = "卖书",produces = MediaType.APPLICATION_JSON_VALUE)
	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
		if (studentId == null || studentId.equals("")) {
			return new Result<>(false, "学号不能为空");
		}
		AppointExecution execution ;
		try {
			execution = bookService.appoint(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<>(true, execution);
	}

}
