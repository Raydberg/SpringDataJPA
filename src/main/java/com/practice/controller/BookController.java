package com.practice.controller;

import com.practice.entities.Book;
import com.practice.repository.BookRepository;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class BookController {
    //Atributos
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/books")
    public List<Book> fillAdd() {
        return bookRepository.findAll();
    }
    @GetMapping("/api/books/{id}")
    public Book fillById(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    @PostMapping("api/books")
    public Book create( @RequestBody Book book){
        return bookRepository.save(book);
    }
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
      bookRepository.deleteById(id);
       return ResponseEntity.noContent().build();
    }


}
