package com.example.apigateway.controller.nplus1;

import com.example.apigateway.feign.NPlus1Client;
import com.example.apigateway.model.nplus1.BookResponse;
import com.example.apigateway.model.nplus1.RatingResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

/**
 * Controller which resolves GraphQL queries related to n+1 problem.
 */


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
  public List<BookResponse> books() {
    log.info("Delegating request for getting all books...");
    return client.getAllBooks();
  }

  @QueryMapping
  public List<RatingResponse> ratingsByBookId(@Argument int bookId) {
    log.info("Delegating request for getting all ratings for book with id: {}", bookId);
    return client.getRatingsByBookId(bookId);
  }

  @QueryMapping
  public BookResponse bookById(@Argument int id) {
    log.info("Delegating request for getting all ratings for book with id: {}", id);
    return client.getBookById(id);
  }

  //@SchemaMapping which solves n+1 problem using DataLoader
  @SchemaMapping
  public CompletableFuture<List<RatingResponse>> ratings(BookResponse book,
      DataLoader<Integer, List<RatingResponse>> loader) {
    return loader.load(book.id());
  }

  private Map<Integer, List<RatingResponse>> executeCall(Set<Integer> booksIds) {
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

  private Map<BookResponse, List<RatingResponse>> mapBookIdsToBooks(
      Map<Integer, List<RatingResponse>> ratingsForBooks, List<BookResponse> books) {
    Map<BookResponse, List<RatingResponse>> map = new HashMap<>();

    for (Integer bookId : ratingsForBooks.keySet()) {
      map.put(getById(books, bookId), ratingsForBooks.get(bookId));
    }

    return map;
  }

  private BookResponse getById(List<BookResponse> books, int id) {
    return books.stream().filter(book -> book.id() == id).findFirst().orElse(null);
  }

}
