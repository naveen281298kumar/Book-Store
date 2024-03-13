package com.bookStore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookStore.dto.BooksDto;
import com.bookStore.service.BookService;

@Controller
public class BookControllerApi {

	@Autowired
	private BookService service;


	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") BooksDto dto) {

		service.addBook(dto);
		return "redirect:/getAllBooks";
	}
	
	
	@GetMapping("/registerBook")
	public String addBook(Model model) {
		
		BooksDto bookDto = new BooksDto();
		model.addAttribute("book", bookDto);

		return "registerBook";
	}

	@GetMapping("/getBook")
	public ResponseEntity<BooksDto> getBook(@RequestParam int id) {

		return new ResponseEntity<BooksDto>(service.getBook(id), HttpStatus.OK);
	}

	@GetMapping("/getAllBooks")
	public String getAllBooks(Model model) {
		
		model.addAttribute("bookList", service.getAllBooks());
		return "bookList";
	}
	
	@GetMapping("/updateBook/{bookId}")
	public String updateBook(@PathVariable int bookId, Model model) {
		
		BooksDto bookDto = service.getBook(bookId);
		model.addAttribute("updateBook", bookDto);

		return "updateBook";
	}
	
	@PostMapping("/updateBookDetails")
	public String updateBookDetail(@ModelAttribute BooksDto dto, @RequestParam int bookId) {
		
		service.updateBookDetails(dto, bookId);
		return "redirect:/getAllBooks";
	}

	@GetMapping("/deleteBook/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		service.deleteBook(bookId);
		return "redirect:/getAllBooks";
	}

}
