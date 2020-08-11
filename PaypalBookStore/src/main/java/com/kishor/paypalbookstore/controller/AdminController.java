package com.kishor.paypalbookstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kishor.paypalbookstore.entity.Book;
import com.kishor.paypalbookstore.entity.Category;
import com.kishor.paypalbookstore.entity.Users;
import com.kishor.paypalbookstore.service.BookService;
import com.kishor.paypalbookstore.service.CategoryService;
import com.kishor.paypalbookstore.service.UsersService;


@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;
	
    
	@GetMapping(value= {"/index"})
	public String index(){
		
		return "admin/index";
		
	}
	
	@RequestMapping("/users")
	public String users(Model theModel) {
	   
		return listByPage(theModel,1);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model theModel, @PathVariable ("pageNumber") int currentPage)
	{
		
		Page<Users> page=usersService.users(currentPage);
		List<Users> users=page.getContent();
		long items_number=page.getTotalElements();
		int total_pages=page.getTotalPages();
		
		theModel.addAttribute("currentPage",currentPage);
		theModel.addAttribute("totalItems",items_number);
		theModel.addAttribute("totalPages",total_pages);
		theModel.addAttribute("users",users);
		
		return "admin/users-list";
		
	}
	
//	//bookController//
//	
//	@RequestMapping("/bookList")
//	public String bookList(Model theModel) {
//		List<Book> books=bookService.getAllBooks();
//		theModel.addAttribute("books",books);
//		
//		return "admin/book/books-list";
//		
//	}
//	
//	@RequestMapping("/bookform")
//	public String bookform(Model theModel)
//	{   
//		List<Category> categories=categoryService.getAllCategories();
//		theModel.addAttribute("categories", categories);
//		Book book=new Book();
//		theModel.addAttribute("book", book);
//		theModel.addAttribute("value",0);
//        return "admin/book/bookForm";
//		
//	}
//	
//	@PostMapping("/registerTheBook")
//	public String bookregister(@ModelAttribute Book theBook
//			,Model theModel,
//			RedirectAttributes ra,
//			@RequestParam("image") MultipartFile multipartFile) throws IOException
//	{   
//
//		String filename=StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		theBook.setBook_logo(filename);
//		Book savedbook=bookService.save(theBook);
//		
//		String uploadDir="./uploads/" +savedbook.getBookId();
//		Path uploadPath=Paths.get(uploadDir);
//		
//		if(!Files.exists(uploadPath))
//		{
//			Files.createDirectories(uploadPath);
//		}
//		
//		try(InputStream inputStream=multipartFile.getInputStream()){
//		Path filePath=uploadPath.resolve(filename);
//		Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//		}
//		catch(IOException e) {
//			throw new IOException("Could not upload saved file"+filename);
//		}
//		
//		
//		
//		
//		ra.addFlashAttribute("message","The book with id"+theBook.getBookId()+" has been saved automatically");
//		
//		return "redirect:/Admin/bookList";
//	
//	}
}
