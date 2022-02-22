package ru.diasoft.micro.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.diasoft.micro.service.HelloService;

@Controller
@RequiredArgsConstructor
public class HelloController {
  private final HelloService helloService;
  private final Logger logger = LogManager.getLogger(this.getClass());

  @PostMapping("/hello")
  public ResponseEntity<String> hello(@RequestBody String name) {
    long before = System.nanoTime();
    ResponseEntity<String> response = helloService.hello(name);
    long after = System.nanoTime();
    logger.atInfo().log("hello() elapsed time: " + (after - before) + "ms");
    return response;
  }
}
