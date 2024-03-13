package com.bookStore.service;


import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.dto.BooksDto;
import com.bookStore.entity.Books;
import com.bookStore.exception.BookNotFoundException;
import com.bookStore.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public BooksDto addBook(BooksDto dto) {
		
		Books bookEntity = mapper.map(dto, Books.class);
		return mapper.map(bookRepo.saveAndFlush(bookEntity), BooksDto.class);
	}
	
	public BooksDto getBook(int bookId) {
		
		Books bookPresent = bookRepo.findById(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
		return mapper.map(bookPresent, BooksDto.class);
	}
	
	public List<BooksDto> getAllBooks(){
		
			return bookRepo.findAll()
					.stream()
					.map(book -> mapper.map(book, BooksDto.class))
					.collect(Collectors.toList());
		
	}
	
	public BooksDto updateBookDetails(BooksDto dto, int bookId) {
		
		Books bookPresent = bookRepo.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
		
		if(!dto.getBookAuthor().isEmpty()) {
			bookPresent.setBookAuthor(dto.getBookAuthor());
		}
		if(!dto.getBookName().isEmpty()) {
			bookPresent.setBookName(dto.getBookName());
		}
		if(dto.getPrice() != 0.0) {
			bookPresent.setPrice(dto.getPrice());
		}
		
		return mapper.map(bookRepo.saveAndFlush(bookPresent), BooksDto.class);
	}
	
	public String deleteBook(int bookId) {
		
		Books bookPresent = bookRepo.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
		bookRepo.delete(bookPresent);
		return String.format("Book with id %s deleted successfuly", bookId);
	}
}
