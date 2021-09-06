package com.example.demo4.service;

import com.example.demo4.model.Book;
import com.example.demo4.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll(String title, String content) {
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return bookRepository.findAll();
        } else {
            return bookRepository.findByTitleOrAuthor(title, content);
        }
    }

    public Book saveOne(Book book) {
        book.setCreate_at(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public Book updateById(Long id, Book newBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    public boolean deleteOne(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAll() {
        bookRepository.deleteAll();
        return true;
    }
}