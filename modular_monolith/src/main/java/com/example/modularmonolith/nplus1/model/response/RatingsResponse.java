package com.example.modularmonolith.nplus1.model.response;

import com.example.modularmonolith.nplus1.model.Rating;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class RatingsResponse {

    private Map<Integer, List<Rating>> ratingsByBookIds;
}
