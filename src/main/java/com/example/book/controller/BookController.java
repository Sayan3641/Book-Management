package com.example.book.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.dto.BookDto;
import com.example.book.entity.BookEntity;
import com.example.book.service.BookService;

@RestController
@RequestMapping("book/v1")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addbook")
	public ResponseEntity<?> addBook(@RequestBody BookDto book){
		BookEntity bookSaved = bookService.addBook(book);
		return ResponseEntity.ok(bookSaved);
	}
	
	@GetMapping("/fetchbook/{id}")
	public ResponseEntity<?> fetchBookById(@PathVariable Integer id){
		Optional<BookEntity> fetchedBook = bookService.fetchBookById(id);
		return ResponseEntity.ok(fetchedBook);
	}
	
	@PutMapping("updateBook")	
	public ResponseEntity<?> updateBook(@RequestBody BookEntity book){
		BookEntity updatedBook = bookService.updateBook(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id){
		bookService.deleteBook(id);
		return ResponseEntity.ok("Deleted");
		
	}

}
