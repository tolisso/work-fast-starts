package ru.diasoft.micro.service;

import org.springframework.http.ResponseEntity;

public interface HelloService {
  ResponseEntity<String> hello(String name);
}
