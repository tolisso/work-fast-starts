package ru.diasoft.micro.service;

import java.util.List;
import ru.diasoft.micro.domain.Client;
import ru.diasoft.micro.dto.ClientDto;

public interface ClientService {
  List<Client> getAll();

  void save(ClientDto clientDto);

}
