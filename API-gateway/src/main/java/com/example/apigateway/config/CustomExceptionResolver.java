package com.example.apigateway.config;

import com.example.apigateway.feign.RestException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {
  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof RestException restException) {
      return GraphqlErrorBuilder.newError()
          .errorType(ErrorType.NOT_FOUND)
          .message(restException.getMessage())
          .path(env.getExecutionStepInfo().getPath())
          .location(env.getField().getSourceLocation())
          .build();
    } else {
      return null;
    }
  }

}
