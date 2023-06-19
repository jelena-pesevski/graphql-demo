package com.example.apigateway.model.nplus1;

public record Rating(Integer id, Integer bookId, Integer rating, String comment, String user) {
}
