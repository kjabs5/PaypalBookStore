package com.kishor.paypalbookstore.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kishor.paypalbookstore.entity.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    
	@Query(value="SELECT * FROM book ORDER BY publish_date DESC limit 4",nativeQuery=true)
	List<Book> findTopN();
	

}
