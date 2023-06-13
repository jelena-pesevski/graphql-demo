package com.example.modularmonolith.nplus1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {

    private Integer id;
    private String name;

}
