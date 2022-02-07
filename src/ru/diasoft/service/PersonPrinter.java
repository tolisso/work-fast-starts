package ru.diasoft.service;

import ru.diasoft.domain.Person;

public class PersonPrinter implements Printer {

  protected static final String SEP = System.lineSeparator();
  public void printInfo(Person p) {
    System.out.println("Person full info: " + SEP
        + "\tname: " + p.getFirstName() + SEP
        + "\tsecond name: " + p.getSecondName() + SEP
        + "\tage: " + p.getAge() + SEP
        + "\tphone: " + p.getPhone());
  }
}
