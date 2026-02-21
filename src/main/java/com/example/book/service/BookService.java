package com.example.book.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.book.dto.BookDto;
import com.example.book.entity.BookEntity;
import com.example.book.repository.BookRepo;

@Service
public class BookService {
	
	private final BookRepo bookRepo;
	
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public BookEntity addBook(BookDto book) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(book.getName());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setQuantity(book.getQuantity());
		return bookRepo.save(bookEntity);
		
	}

	public Optional<BookEntity> fetchBookById(Integer id) {
		return bookRepo.findById(id);
	}

	public BookEntity updateBook(BookEntity book) {
		return bookRepo.save(book);
		
	}

	public void deleteBook(Integer id) {
		bookRepo.deleteById(id);
	}

}
