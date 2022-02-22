package ru.diasoft.micro.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.diasoft.micro.dao.ClientRepository;
import ru.diasoft.micro.domain.Client;
import ru.diasoft.micro.dto.ClientDto;

public class ClientServiceTest {

  ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
  ClientService clientService = new ClientServiceImpl(clientRepository);

  @Test
  public void test() {
    List<Client> clientArray = new ArrayList<>();
    Mockito
        .when(clientRepository.findAll())
        .thenReturn(clientArray);

    Mockito
        .when(clientRepository.save(Mockito.any()))
        .then(invocationOnMock -> {
          clientArray.add(invocationOnMock.getArgument(0));
          return null;
        });

    clientService.save(new ClientDto("Alex", "AA"));
    clientService.save(new ClientDto("Bob", "BB"));
    clientService.save(new ClientDto("Celesta", "CC"));

    Assert.assertArrayEquals(
        new String[] {"Alex", "Bob", "Celesta"},
        clientService
            .getAll()
            .stream()
            .map(Client::getName)
            .toArray());

    Assert.assertArrayEquals(
        new String[] {"AA", "BB", "CC"},
        clientService
            .getAll()
            .stream()
            .map(Client::getInn)
            .toArray());
  }

}
