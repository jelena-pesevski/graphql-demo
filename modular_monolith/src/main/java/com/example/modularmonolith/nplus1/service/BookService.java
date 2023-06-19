package com.example.modularmonolith.nplus1.service;

import com.example.modularmonolith.nplus1.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookService {

    private final Map<Integer, Book> bookRepository = new HashMap<>();

    public BookService() {
        bookRepository.put(1, new Book(1, "Zero to One", "Peter Thiel", "Crown Business", 16.14));
        bookRepository.put(2, new Book(2, "The Lean Startup", "Eric Ries", "VIKIN", 15.80));
        bookRepository.put(3, new Book(3, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Random House Uk", 18.75));
        bookRepository.put(4, new Book(4, "Atomic Habits", "James Clear", "Avery", 11.98));
        bookRepository.put(5, new Book(5, "The Subtle Art of Not Giving a F*ck", "Mark Manson", "Harper", 12.99));
    }

    public List<Book> getAll() {
        log.info("Get all books...");
        return bookRepository.values().stream().toList();
    }

    public Book getById(Integer id) {
        log.info("Get book by id {}", id);
        return bookRepository.get(id);
    }
}
