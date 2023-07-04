package com.example.modularmonolith.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor whose purpose is just to show how header is present in the requests sent by
 * FeignClient.
 */
@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("Received token {}", token);

        return true;
    }

}
