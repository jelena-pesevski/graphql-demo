package com.example.apigateway.model.nplus1;

public record RatingResponse(Integer id, Integer bookId, Integer rating, String comment,
                             String user) {

}
