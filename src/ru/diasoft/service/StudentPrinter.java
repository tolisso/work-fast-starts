package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class StudentPrinter extends PersonPrinter {

  public void printInfo(Person p) {
    super.printInfo(p);
    if (p instanceof Student) {
      Student s = (Student) p;
      System.out.println(
          "\tgroup: " + s.getGroup() + SEP
          + "\tscore: " + s.getScore());
    }
  }
}
