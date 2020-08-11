package com.kishor.paypalbookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="category")
public class Category {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="category_id")
	private Integer category_id;
	 @Column(name="category_name") 
	private String categoryName;
	 
	 @OneToMany(fetch=FetchType.LAZY, 
	    		cascade=CascadeType.ALL,
	    		mappedBy="category")
	    private List<Book> books;
	
	public Category() {
		super();
	}
	


	



	







	public Category(Integer category_id, String categoryName, List<Book> books) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.books = books;
	}















	public Integer getCategory_id() {
		return category_id;
	}



	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}



	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}















	public List<Book> getBooks() {
		return books;
	}















	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	

}
