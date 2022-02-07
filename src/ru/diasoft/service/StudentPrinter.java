package ru.diasoft.service;

import ru.diasoft.domain.Student;

public class StudentPrinter extends PersonPrinter {

  public void printInfo(Student p) {
    super.printInfo(p);
    System.out.println(
        "\tgroup: " + p.getGroup() + SEP +
        "\tscore: " + p.getScore());
  }
}
