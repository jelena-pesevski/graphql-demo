package com.example.apigateway.config;

import graphql.ExecutionInput;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RequestHeaderInterceptor implements WebGraphQlInterceptor {

  @Override
  public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
    log.info("izvrsava seee");

    String value = request.getHeaders().getFirst("Authorization");
    request.configureExecutionInput((executionInput, builder) ->
        builder.graphQLContext(Collections.singletonMap("token", value)).build());

    return chain.next(request);
  }
}
