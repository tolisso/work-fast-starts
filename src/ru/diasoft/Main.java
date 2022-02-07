package ru.diasoft;

import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;

public class Main {

  public static void main(String[] args) {
    new PersonDemo(
        new Student(
            "Vova",
            "Kupchin",
            25,
            "+7(123)456-78-90",
            "M33381",
            85)).demo();
  }
}
