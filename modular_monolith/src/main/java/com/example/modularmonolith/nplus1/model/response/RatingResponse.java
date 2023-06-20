package com.example.modularmonolith.nplus1.model.response;

public record RatingResponse(Integer id, Integer bookId, Integer rating, String comment, String user) {
}
