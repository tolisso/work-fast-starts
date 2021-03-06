package ru.diasoft.service;

import java.util.stream.Collectors;
import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;
import ru.diasoft.repository.StudentRepository;

public class PersonDemo {

  public void demo() {
    Faculty f = new StudentRepository().getFaculty();
    FacultyOperations operations = new FacultyOperationsImpl(f);

    System.out.println(operations
        .byName("Vova")
        .stream()
        .map(s -> s.getFirstName() + " " + s.getSecondName())
        .collect(Collectors.toList()));
    System.out.println(operations.getBestStudents()
        .stream()
        .map(s -> s.getFirstName() + " " + s.getSecondName())
        .collect(Collectors.toList()));
    System.out.println(operations.sortBySecondNameAlphabetic().stream()
        .map(s -> s.getFirstName() + " " + s.getSecondName())
        .collect(Collectors.toList()));
  }
}
