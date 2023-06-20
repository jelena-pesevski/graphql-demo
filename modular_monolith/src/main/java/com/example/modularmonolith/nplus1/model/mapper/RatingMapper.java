package com.example.modularmonolith.nplus1.model.mapper;

import com.example.modularmonolith.nplus1.model.Rating;
import com.example.modularmonolith.nplus1.model.response.RatingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingResponse toResponse(Rating rating);
}
