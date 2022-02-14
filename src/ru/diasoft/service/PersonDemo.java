package ru.diasoft.service;

import ru.diasoft.repository.StudentRepository;

public class PersonDemo {

  public void demo() {
    new StudentRepository().getFaculty().students()
        .forEach(s -> {
          new StudentPrinter().printInfo(s);
          System.out.println();
        });
  }
}
