package com.example.modularmonolith.nplus1.controller;

import com.example.modularmonolith.nplus1.model.response.BatchedRatingsResponse;
import com.example.modularmonolith.nplus1.model.response.RatingResponse;
import com.example.modularmonolith.nplus1.service.RatingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

  private final RatingService ratingService;

  @GetMapping("/book/{bookId}")
  public List<RatingResponse> getByBookId(@PathVariable int bookId) {

    return ratingService.getByBookId(bookId);
  }

  @PostMapping(value = "/books")
  public BatchedRatingsResponse getAllByBookIds(@RequestBody List<Integer> bookIds) {

    return ratingService.getByBookIds(bookIds);
  }

}
