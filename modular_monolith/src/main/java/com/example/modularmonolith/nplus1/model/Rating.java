package com.example.modularmonolith.nplus1.model;

public record Rating(Integer id, Integer bookId, Integer rating, String comment, String user) {
}
