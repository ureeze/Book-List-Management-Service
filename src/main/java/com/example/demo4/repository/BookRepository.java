package com.example.demo4.repository;

import com.example.demo4.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByTitleOrAuthor(String title, String author);

    Page<Book> findByTitleContainingOrAuthorContaining(String title, String author, Pageable pageable);
}
