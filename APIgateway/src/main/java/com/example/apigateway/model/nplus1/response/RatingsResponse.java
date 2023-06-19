package com.example.apigateway.model.nplus1.response;

import com.example.apigateway.model.nplus1.Rating;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class RatingsResponse implements Serializable {

    private Map<Integer, List<Rating>> ratingsByBookIds;
}
