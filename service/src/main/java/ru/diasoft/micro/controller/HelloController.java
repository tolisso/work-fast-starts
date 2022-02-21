package ru.diasoft.micro.controller;

import javax.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.diasoft.micro.service.HelloService;

@Controller
@RequiredArgsConstructor
public class HelloController {
  private final HelloService helloService;

  @PostMapping("/hello")
  public ResponseEntity<String> hello(@RequestBody String name) {
    return helloService.hello(name);
  }
}
