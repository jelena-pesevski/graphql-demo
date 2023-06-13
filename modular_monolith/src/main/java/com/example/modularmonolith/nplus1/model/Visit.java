package com.example.modularmonolith.nplus1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Visit {
    private Integer id;
    private Integer treatingVetId;
    private Integer petId;
}
