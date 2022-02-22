package ru.diasoft.micro.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

  private final ClientService clientService;

  @GetMapping("/get-clients")
  public ResponseEntity<List<Client>> getClients() {
    return ResponseEntity.ok(clientService.getAll());
  }

  @PostMapping("/add-client")
  public ResponseEntity<String> addClient(@RequestBody ClientDto clientDto) {
    clientService.save(clientDto);
    return ResponseEntity.ok("ok");
  }
}
