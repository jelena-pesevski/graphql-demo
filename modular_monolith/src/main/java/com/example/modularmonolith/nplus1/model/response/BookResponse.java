package com.example.modularmonolith.nplus1.model.response;

public record BookResponse(Integer id, String name, String author, String publisher, Double price) {
}