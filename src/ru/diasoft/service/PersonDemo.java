package ru.diasoft.service;

import ru.diasoft.domain.Person;

public class PersonDemo {

  private final Person person;

  public PersonDemo(Person person) {
    this.person = person;
  }

  public void demo() {
    PersonPrinter.printFI(person);

    PersonPrinter.printInfo(person);

    System.out.println();
    System.out.println("time passed");

    person.setAge(person.getAge() + 1);
    person.setPhone("+7(777)322-13-37");

    PersonPrinter.printInfo(person);
  }
}
