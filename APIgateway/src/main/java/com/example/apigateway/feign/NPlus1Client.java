package com.example.apigateway.feign;

import com.example.apigateway.model.nplus1.BookResponse;
import com.example.apigateway.model.nplus1.RatingResponse;
import com.example.apigateway.model.nplus1.response.BatchedRatingsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * FeignClient for presentation of n+1 problem and its solving with DataLoader.
 */

@FeignClient(name = "nplus1-client", url = "${config.main-app.url}")
public interface NPlus1Client {

    @GetMapping("/books")
    List<BookResponse> getAllBooks();

    @GetMapping("/books/{id}")
    BookResponse getBookById(@PathVariable int id);

    @GetMapping("/ratings/book/{bookId}")
    List<RatingResponse> getRatingsByBookId(@PathVariable int bookId);

    @PostMapping(value = "/ratings/books")
    BatchedRatingsResponse getAllRatingsByBookIds(@RequestBody List<Integer> bookIds);

}
