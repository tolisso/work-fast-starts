package ru.diasoft.micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.micro.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
