package com.example.demo4.controller;

import com.example.demo4.model.Book;
import com.example.demo4.repository.BookRepository;
import com.example.demo4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText) {
        //Page<Book> boards = boardRepository.findAll(pageable);
        Page<Book> books = bookRepository.findByTitleContainingOrAuthorContaining(searchText, searchText, pageable);
        int startPage = 1;
        int endPage = books.getTotalPages();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("book", new Book());
        } else {
            Book book = bookRepository.findById(id).orElse(null);
            model.addAttribute("book", book);
        }
        return "book/form";
    }

    @PostMapping("/form")
    public String submit(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/form";
        }
        bookService.saveOne(book);
        return "redirect:/book/list";
    }
}
