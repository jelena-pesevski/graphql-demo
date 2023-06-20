package com.example.modularmonolith.nplus1.service;

import com.example.modularmonolith.nplus1.model.Book;
import com.example.modularmonolith.nplus1.model.mapper.BookMapper;
import com.example.modularmonolith.nplus1.model.response.BookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookService {

    private final Map<Integer, Book> bookRepository = new HashMap<>();
    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;

        initializeRepository();
    }

    public List<BookResponse> getAll() {
        log.info("Get all books...");
        return bookRepository.values().stream().map(bookMapper::toResponse).toList();
    }

    public BookResponse getById(Integer id) {
        log.info("Get book by id {}", id);
        return bookMapper.toResponse(bookRepository.get(id));
    }

    private void initializeRepository() {
        bookRepository.put(1, new Book(1, "Zero to One", "Peter Thiel", "Crown Business", 16.14));
        bookRepository.put(2, new Book(2, "The Lean Startup", "Eric Ries", "VIKIN", 15.80));
        bookRepository.put(3, new Book(3, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Random House Uk", 18.75));
        bookRepository.put(4, new Book(4, "Atomic Habits", "James Clear", "Avery", 11.98));
        bookRepository.put(5, new Book(5, "The Subtle Art of Not Giving a F*ck", "Mark Manson", "Harper", 12.99));
    }
}
