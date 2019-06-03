package com.soecode.lyf.bookuserservice.service.impl;

import com.soecode.lyf.bookuserservice.dao.BookDao;
import com.soecode.lyf.bookuserservice.pojo.Book;
import com.soecode.lyf.bookuserservice.service.BookService;
import com.soecode.lyf.datasource.DataSource;
import com.soecode.lyf.log.annatation.LogRequire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private BookDao bookDao;



	@Override
	@DataSource("dataSource1")
	@LogRequire(operationModel = "book",operationFunction = "根据书的id查询book",operationExplain = "查询操作")
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	@DataSource("dataSource1")
	@LogRequire(operationModel = "books",operationFunction = "查询所有的书",operationExplain = "查询所有的书")
	public List<Book> getList() {
		return bookDao.queryAll(0, 1000);
	}




}
