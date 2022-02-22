package ru.diasoft.micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.micro.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
  Client getByName(String name);
}
