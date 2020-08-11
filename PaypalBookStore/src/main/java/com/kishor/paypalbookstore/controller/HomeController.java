package com.kishor.paypalbookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kishor.paypalbookstore.entity.Book;
import com.kishor.paypalbookstore.service.BookService;



@Controller

public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value= {"/index","/"})
	public String home(Model theModel)
	{   
		List<Book> booksList=bookService.findTopN();
   	    theModel.addAttribute("booksList", booksList);
		
		
		return "customer/index";
	}
	
	//user controller

}
