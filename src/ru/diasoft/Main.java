package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.service.PersonDemo;

public class Main {
  public static void main(String[] args) {
    new PersonDemo(
        new Person(
            "Vova",
            "Kupchin",
            25,
            "+7(123)456-78-90")).demo();
  }
}
