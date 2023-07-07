package com.example.apigateway.config;

import com.example.apigateway.feign.ApiErrorResponse;
import com.example.apigateway.feign.RestException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import java.util.Collections;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof RestException restException) {
      ApiErrorResponse apiErrorResponse = (ApiErrorResponse) restException.getData();
      return GraphqlErrorBuilder.newError()
          .message(apiErrorResponse.getMessageKey())
          .path(env.getExecutionStepInfo().getPath())
          .location(env.getField().getSourceLocation())
          .extensions(Collections.singletonMap("statusCode", restException.getStatus().value()))
          .build();
    } else {
      return null;
    }
  }

}
