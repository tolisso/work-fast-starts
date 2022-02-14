package ru.diasoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import ru.diasoft.domain.Course;
import ru.diasoft.domain.Student;
import ru.diasoft.repository.StudentRepository;
import ru.diasoft.service.PersonDemo;
import ru.diasoft.service.StudentPrinter;

public class Main {

  public static void main(String[] args) {

    new StudentRepository().getFaculty().students()
        .forEach(s -> {
          new StudentPrinter().printInfo(s);
          System.out.println();
        });
  }
}
