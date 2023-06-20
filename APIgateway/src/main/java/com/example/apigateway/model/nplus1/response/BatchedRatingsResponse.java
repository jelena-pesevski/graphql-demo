package com.example.apigateway.model.nplus1.response;

import com.example.apigateway.model.nplus1.RatingResponse;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * DTO which is used with DataLoader, represents batched response.
 */

@Data
public class BatchedRatingsResponse {

  private Map<Integer, List<RatingResponse>> ratingsByBookIds;
}
