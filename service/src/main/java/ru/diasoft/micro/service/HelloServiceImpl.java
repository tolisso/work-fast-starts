package ru.diasoft.micro.service;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloServiceImpl implements HelloService {

  @Override
  public ResponseEntity<String> hello(String name) {
    return ResponseEntity.ok("Hello " + name);
  }
}
