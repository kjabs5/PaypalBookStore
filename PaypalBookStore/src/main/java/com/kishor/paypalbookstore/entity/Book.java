package com.kishor.paypalbookstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="book")
public class Book {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="book_id")
		private Integer bookId;
	    
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="category_id")
	   	private Category category;
	    
	    @Column(name="book_title")
		private String title;
	    
	    @Column(name="book_author")
		private String author;
	    
	    @Column(name="description")
		private String description;
	    
	    @Column(name="isbn")
		private String isbn;
	    
	  
	    
	    @Column(name="price")
		private float price;
	    

	    
	    @Temporal(TemporalType.DATE)
	    @Column(name="publish_date")
		private Date publishDate;
	    
	   
	    
	    @Column(name="book_logo")
		private String book_logo;



		
	    
//	    @OneToMany(fetch=FetchType.LAZY, 
//	    		cascade=CascadeType.ALL,
//	    		mappedBy="book")
//	    private List<Review> reviews;
	    
//	    @OneToMany(fetch=FetchType.LAZY, 
//	    		cascade=CascadeType.ALL,
//	    		mappedBy="book")
//	    private Set<OrderDetail> orderDetail= new HashSet<OrderDetail>(0);
	    
	    public Book() {
			super();
		}





public Book(Integer bookId, Category category, String title, String author, String description, String isbn,
		float price, Date publishDate, String book_logo) {
	super();
	this.bookId = bookId;
	this.category = category;
	this.title = title;
	this.author = author;
	this.description = description;
	this.isbn = isbn;
	this.price = price;
	this.publishDate = publishDate;
	this.book_logo = book_logo;
}





public Integer getBookId() {
	return bookId;
}





public void setBookId(Integer bookId) {
	this.bookId = bookId;
}





public Category getCategory() {
	return category;
}





public void setCategory(Category category) {
	this.category = category;
}





public String getTitle() {
	return title;
}





public void setTitle(String title) {
	this.title = title;
}





public String getAuthor() {
	return author;
}





public void setAuthor(String author) {
	this.author = author;
}





public String getDescription() {
	return description;
}





public void setDescription(String description) {
	this.description = description;
}





public String getIsbn() {
	return isbn;
}





public void setIsbn(String isbn) {
	this.isbn = isbn;
}





public float getPrice() {
	return price;
}





public void setPrice(float price) {
	this.price = price;
}





public Date getPublishDate() {
	return publishDate;
}





public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
}





public String getBook_logo() {
	return book_logo;
}





public void setBook_logo(String book_logo) {
	this.book_logo = book_logo;
}
	    
@Transient
public String getImagePath() {
	if(bookId==null||book_logo==null) return null;
	
	return "/uploads/" +bookId+"/"+book_logo;
	
}

}
