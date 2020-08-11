package com.kishor.paypalbookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.kishor.paypalbookstore.entity.Book;
import com.kishor.paypalbookstore.entity.Users;

public interface BookService {
	
	//public List<Book> getAllBooks();
	public Page<Book> getAllBooks(int pageNumber);
	
	public Book save(Book theBook);

	public Book getBookById(int bookId);

	public void delete(int bookId);

	public List<Book> findTopN();

}
