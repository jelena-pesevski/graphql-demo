package com.example.apigateway.controller.nplus1;

import com.example.apigateway.feign.NPlus1Client;
import com.example.apigateway.model.nplus1.Book;
import com.example.apigateway.model.nplus1.Rating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NPlus1Controller {

    private final NPlus1Client client;

    @QueryMapping
    public List<Book> books() {
        log.info("Delegating request for getting all books...");
        return client.getAllBooks();
    }

//    @SchemaMapping
//    public List<Rating> ratings(Book book) {
//        log.info("Fetching rating for book, id {}", book.id());
//        return client.getRatingsByBookId(book.id());
//    }

    @BatchMapping
    public Map<Book, List<Rating>> ratings(List<Book> books) {
        log.info("Fetching ratings for all books");

        var response = client.getAllRatingsByBookIds(books.stream().map(Book::id).toList());

        return mapBookIdsToBooks(response.getRatingsByBookIds(), books);
    }

    private Map<Book, List<Rating>> mapBookIdsToBooks(Map<Integer, List<Rating>> ratingsForBooks, List<Book> books) {
        Map<Book, List<Rating>> map = new HashMap<>();

        for (Integer bookId : ratingsForBooks.keySet()) {
            map.put(getById(books, bookId), ratingsForBooks.get(bookId));
        }

        return map;
    }

    private Book getById(List<Book> books, int id) {
        return books.stream().filter(book -> book.id() == id).findFirst().orElse(null);
    }

}
