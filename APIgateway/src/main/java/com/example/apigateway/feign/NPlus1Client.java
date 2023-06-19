package com.example.apigateway.feign;

import com.example.apigateway.model.nplus1.Book;
import com.example.apigateway.model.nplus1.Rating;
import com.example.apigateway.model.nplus1.response.RatingsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "nplus1-client", url = "${config.main-app.url}")
public interface NPlus1Client {

    @GetMapping("/books")
    List<Book> getAllBooks();

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable int id);

    @GetMapping("/ratings/book/{bookId}")
    List<Rating> getRatingsByBookId(@PathVariable int bookId);

    @PostMapping(value = "/ratings/books")
    RatingsResponse getAllRatingsByBookIds(@RequestBody List<Integer> bookIds);

}
