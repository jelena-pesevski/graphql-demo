package com.example.apigateway.model.nplus1;

import lombok.Data;

public record Book(Integer id, String name, String author, String publisher, Double price) {
}