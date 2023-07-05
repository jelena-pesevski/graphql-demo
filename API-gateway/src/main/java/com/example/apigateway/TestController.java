package com.example.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping
  public String test() {
    log.info("Inside controller");
    return "Radi";
  }

  @PostMapping
  public String testPost(@RequestBody String request){
    log.info("Postttttt");
    return "Radi post";
  }
}
