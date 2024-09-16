package com.practice.controller;

import com.practice.entities.Book;
import com.practice.repository.BookRepository;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/books")
@RestController()
public class BookController {
    //Atributos
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public List<Book> fillAdd() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book fillById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("api/books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book resp = bookRepository.save(book);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
