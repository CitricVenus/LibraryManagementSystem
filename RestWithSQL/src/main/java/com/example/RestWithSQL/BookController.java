package com.example.RestWithSQL;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id){
        return bookService.updateBook(book,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable long id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }



}
