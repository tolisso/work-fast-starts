package ru.diasoft.micro.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dao.ClientRepository;
import ru.diasoft.micro.domain.Client;
import ru.diasoft.micro.dto.ClientDto;

@AllArgsConstructor
@Service
@Primary
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  public List<Client> getAll() {
    return clientRepository.findAll();
  }

  @Override
  public void save(ClientDto clientDto) {
    Client client = new Client();
    client.setName(clientDto.getName());
    client.setInn(clientDto.getInn());
    clientRepository.save(client);
  }
}
