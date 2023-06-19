package com.example.apigateway.model.nplus1;

import lombok.Data;

public record Rating(Integer id, Integer bookId, Integer rating, String comment, String user) {
}
