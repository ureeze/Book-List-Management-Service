package com.example.demo4.controller;

import com.example.demo4.model.Book;
import com.example.demo4.service.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<CollectionModel<EntityModel<Book>>> all(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String content) {
        List<Book> list = bookService.findAll(title, content);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<EntityModel<Book>> books = list.
                    stream()
                    .map((book) ->
                            EntityModel.of(book)
                                    .add(linkTo(methodOn(BookRestController.class).one(book.getId())).withSelfRel())  // /hateoas/test1 - self
                    ).collect(Collectors.toList());

            return ResponseEntity.ok().body(CollectionModel.of(books)
                    .add(linkTo(methodOn(BookRestController.class).all("", "")).withRel("all")));
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> newBook(@RequestBody Book book) {
        Book newBook = bookService.saveOne(book);
        newBook.add(linkTo(methodOn(BookRestController.class).one(newBook.getId())).withSelfRel());
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> one(@ApiParam(value = "게시글 번호", required = true, example = "1") @PathVariable Long id) {
        Book book = bookService.findOne(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            book.add(linkTo(methodOn(BookRestController.class).one(book.getId())).withSelfRel());
            book.add(linkTo(methodOn(BookRestController.class).all("", "")).withRel("all"));
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> replaceBook(@PathVariable Long id, @RequestBody Book newBook) {
        Book book = bookService.updateById(id, newBook);
        book.add(linkTo(methodOn(BookRestController.class).one(book.getId())).withSelfRel());
        book.add(linkTo(methodOn(BookRestController.class).all("", "")).withRel("all"));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        if (bookService.deleteOne(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<Book> deleteAll() {
        bookService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
