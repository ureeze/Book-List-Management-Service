package com.example.demo4.controller;

import com.example.demo4.model.Book;
import com.example.demo4.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookApiController {

    @Autowired
    private BookRepository bookRepository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/books")
    List<Book> all(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String content) {
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return bookRepository.findAll();
        } else {
            return bookRepository.findByTitleOrAuthor(title, content);
        }
    }
    // end::get-aggregate-root[]

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    // Single item

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id) {

        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        return bookRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBook.getTitle());
                    board.setAuthor(newBook.getAuthor());
                    return bookRepository.save(board);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}