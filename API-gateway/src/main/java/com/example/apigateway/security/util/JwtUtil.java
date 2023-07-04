package com.example.apigateway.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.apigateway.security.config.JwtConfig;
import com.example.apigateway.security.model.User;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

  private final JwtConfig jwtConfig;

  public String generateJwt(User user) {
    Algorithm algorithm = Algorithm.HMAC512(jwtConfig.getTokenSecret());
    return JWT.create().withSubject(user.getUsername()).withClaim("id", user.getId())
        .withExpiresAt(LocalDateTime.now().plusMinutes(jwtConfig.getTokenExpirationTime()).atZone(
            ZoneId.systemDefault()).toInstant()).sign(algorithm);
  }


  public DecodedJWT parseJwt(String token) {
    Algorithm algorithm = Algorithm.HMAC512(jwtConfig.getTokenSecret());

    JWTVerifier verifier = JWT.require(algorithm).build();

    return verifier.verify(token);
  }

}
