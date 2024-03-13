package com.bookStore.exception;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException(int bookId) {
		super(String.format("Book not found with id %s", bookId));
	}

}
