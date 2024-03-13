package com.bookStore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double price;
	
}
