package com.example.modularmonolith.nplus1.model.response;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BatchedRatingsResponse {

  private Map<Integer, List<RatingResponse>> ratingsByBookIds;
}
