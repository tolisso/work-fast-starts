package ru.diasoft.micro.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
  private final Logger logger =
      LogManager.getLogger(this.getClass());

  public List<Client> getAll() {
    List<Client> clients =  clientRepository.findAll();

    String postInfo = String.format("getAll returned %d clients", clients.size());
    logger.info(postInfo);
    return clients;
  }

  @Override
  public void save(ClientDto clientDto) {
    String preInfo = String.format("saving client \"%s\" with inn \"%s\"",
        clientDto.getName(), clientDto.getInn());
    logger.info(preInfo);

    Client client = new Client();
    client.setName(clientDto.getName());
    client.setInn(clientDto.getInn());
    clientRepository.save(client);

    String postInfo = String.format("client \"%s\" saved",
        clientDto.getName());
    logger.info(postInfo);
  }
}
