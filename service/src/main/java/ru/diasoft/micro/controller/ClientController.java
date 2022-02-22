package ru.diasoft.micro.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.micro.domain.Client;
import ru.diasoft.micro.dto.ClientDto;
import ru.diasoft.micro.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {

  private final Logger logger = LogManager.getLogger(this.getClass());
  private final ClientService clientService;

  @GetMapping("/get-clients")
  public List<Client> getClients() {
    return clientService.getAll();
  }

  @PostMapping("/add-client")
  public void addClient(@RequestBody ClientDto clientDto) {
    clientService.save(clientDto);
  }
}
