package com.example.apigateway.controller.nplus1;

import com.example.apigateway.feign.NPlus1Client;
import com.example.apigateway.model.nplus1.Book;
import com.example.apigateway.model.nplus1.Rating;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Controller
public class NPlus1Controller {

    private final NPlus1Client client;

    public NPlus1Controller(NPlus1Client client, BatchLoaderRegistry batchLoaderRegistry) {
        this.client = client;

        batchLoaderRegistry.forTypePair(Integer.class, List.class)
                .registerMappedBatchLoader((booksIds, env) -> {
                    Map map = executeCall(booksIds);
                    return Mono.just(map);
                });
    }

    @QueryMapping
    public List<Book> books() {
        log.info("Delegating request for getting all books...");
        return client.getAllBooks();
    }

    //@SchemaMapping which solves n+1 problem using DataLoader
    @SchemaMapping
    public CompletableFuture<List<Rating>> ratings(Book book, DataLoader<Integer, List<Rating>> loader) {
        return loader.load(book.id());
    }

    private Map<Integer, List<Rating>> executeCall(Set<Integer> booksIds) {
        log.info("Fetching ratings for books with ids: {}", booksIds);

        var response = client.getAllRatingsByBookIds(List.copyOf(booksIds));

        return response.getRatingsByBookIds();
    }

    //@SchemaMapping which causes n+1 problem
//    @SchemaMapping
//    public List<Rating> ratings(Book book) {
//        log.info("Fetching rating for book, id {}", book.id());
//        return client.getRatingsByBookId(book.id());
//    }

    //@BatchMapping solves n+1 problem
//    @BatchMapping
//    public Map<Book, List<Rating>> ratings(List<Book> books) {
//        List<Integer> booksIds = books.stream().map(Book::id).toList();
//
//        log.info("Fetching ratings for books with ids: {}", booksIds);
//
//        var response = client.getAllRatingsByBookIds(booksIds);
//
//        return mapBookIdsToBooks(response.getRatingsByBookIds(), books);
//    }

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
