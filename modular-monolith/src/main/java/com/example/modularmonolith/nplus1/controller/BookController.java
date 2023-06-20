package com.example.modularmonolith.nplus1.controller;

import com.example.modularmonolith.nplus1.model.response.BookResponse;
import com.example.modularmonolith.nplus1.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping
  public List<BookResponse> getAll() {
    return bookService.getAll();
  }

  @GetMapping("/{id}")
  public BookResponse getById(@PathVariable int id) {
    return bookService.getById(id);
  }

}
