package com.example.apigateway.security.service;

import com.example.apigateway.security.model.CustomUserDetails;
import com.example.apigateway.security.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new CustomUserDetails(1, "test", "$2a$10$5fSkteFqvPfBV0dsHjYZcu.LmXGTrO7Tsi26IcxuN8eAwoI9te34C", Role.USER);
  }
}
