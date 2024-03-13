package com.bookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.entity.Books;

public interface BookRepo extends JpaRepository<Books, Integer>{

}
