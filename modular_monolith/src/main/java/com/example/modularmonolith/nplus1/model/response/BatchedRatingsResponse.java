package com.example.modularmonolith.nplus1.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class BatchedRatingsResponse {

    private Map<Integer, List<RatingResponse>> ratingsByBookIds;
}
