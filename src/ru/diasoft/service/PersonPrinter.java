package ru.diasoft.service;

import ru.diasoft.domain.Person;

public class PersonPrinter {

  public static void printFI(Person p) {
    System.out.println("Person full name: " + p.getFirstName() + " " + p.getSecondName());
  }

  private static final String SEP = System.lineSeparator();
  public static void printInfo(Person p) {
    System.out.println("Person full info: " + SEP
        + "\tname: " + p.getFirstName() + SEP
        + "\tsecond name: " + p.getSecondName() + SEP
        + "\tage: " + p.getAge() + SEP
        + "\tphone: " + p.getPhone());
  }
}
