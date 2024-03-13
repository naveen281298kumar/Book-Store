package com.bookStore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksDto {

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", price=" + price
				+ "]";
	}
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private float price;
	
}
