package ru.diasoft.service;

import java.util.stream.Collectors;
import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class StudentPrinter extends PersonPrinter {

  public void printInfo(Person p) {
    super.printInfo(p);
    if (p instanceof Student) {
      Student s = (Student) p;
      System.out.print(
          "\tgroup: " + s.getGroup() + SEP
              + "\tscore: " + s.getScore() + SEP
              + "\tcourses: " + SEP
              + s.getCourses()
              .stream()
              .map(c -> "\t\t" + c.getTitle() + ": " + c.getScore() + SEP)
              .collect(Collectors.joining()));
    }
  }
}
