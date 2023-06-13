package com.example.modularmonolith.nplus1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vet {
    private Integer id;
    private String firstName;
    private String lastName;

}
