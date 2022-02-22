package ru.diasoft.micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.micro.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
