package ezen.mvcframework.web.ajax.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;

//books
public class BookListActionController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "ajax/books-action";
//		List<Book> list = ???;
		return viewName;
	}

}
