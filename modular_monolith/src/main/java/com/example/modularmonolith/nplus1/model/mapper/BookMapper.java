package com.example.modularmonolith.nplus1.model.mapper;

import com.example.modularmonolith.nplus1.model.Book;
import com.example.modularmonolith.nplus1.model.response.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse toResponse(Book book);
}
