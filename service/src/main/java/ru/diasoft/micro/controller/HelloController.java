package ru.diasoft.micro.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.diasoft.micro.dao.ClientRepository;
import ru.diasoft.micro.domain.Client;
import ru.diasoft.micro.service.HelloService;

@Controller
@RequiredArgsConstructor
public class HelloController {

  private final Logger logger = LogManager.getLogger(this.getClass());
  private final HelloService helloService;
  private final ClientRepository clientRepository;

  @PostMapping("/hello")
  public ResponseEntity<String> hello(@RequestBody String name) {
    Client client = new Client();
    client.setInn("abacaba112");
    client.setName("Alexander Ivanov");

    clientRepository.save(client);
    clientRepository.getByName("Alexander Ivanov");
    long before = System.nanoTime();
    ResponseEntity<String> response = helloService.hello(name);
    long after = System.nanoTime();
    logger.atInfo().log("hello() elapsed time: " + (after - before) + "ms");
    return response;
  }
}
