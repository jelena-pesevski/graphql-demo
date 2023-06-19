package com.example.modularmonolith.nplus1.controller;

import com.example.modularmonolith.nplus1.model.Book;
import com.example.modularmonolith.nplus1.model.Rating;
import com.example.modularmonolith.nplus1.model.response.RatingsResponse;
import com.example.modularmonolith.nplus1.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/book/{bookId}")
    public List<Rating> getByBookId(@PathVariable int bookId) {
        return ratingService.getByBookId(bookId);
    }

    @PostMapping(value = "/books")
    public RatingsResponse getAllByBookIds(@RequestBody List<Integer> bookIds) {
        return ratingService.getByBookIds(bookIds);
    }

}
