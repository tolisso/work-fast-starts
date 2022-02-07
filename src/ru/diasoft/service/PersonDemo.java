package ru.diasoft.service;

import ru.diasoft.domain.Student;

public class PersonDemo {

  private final Student student;

  public PersonDemo(Student student) {
    this.student = student;
  }

  public void demo() {
    Printer pprint = new PersonPrinter();
    StudentPrinter sprint = new StudentPrinter();
    pprint.printInfo(student);
    System.out.println();
    sprint.printInfo(student);
  }
}
