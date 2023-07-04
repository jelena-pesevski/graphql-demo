package com.example.apigateway.controller;

import com.example.apigateway.security.model.CustomUserDetails;
import com.example.apigateway.security.model.LoginRequest;
import com.example.apigateway.security.model.User;
import com.example.apigateway.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;


  private final JwtUtil jwtUtil;

  @PostMapping
  public String login(@RequestBody LoginRequest loginRequest) {
    CustomUserDetails principal = getCustomUserDetailsObject(loginRequest);

    return jwtUtil.generateJwt(
        User.builder().id(principal.getId()).username(principal.getUsername())
            .password(principal.getPassword()).build());
  }

  private CustomUserDetails getCustomUserDetailsObject(LoginRequest loginRequest) {
    final var authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
    return (CustomUserDetails) authentication.getPrincipal();
  }

}
