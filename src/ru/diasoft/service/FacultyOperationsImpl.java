package ru.diasoft.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class FacultyOperationsImpl implements FacultyOperations {

  @Override
  public List<Student> byName(Faculty faculty, String name) {
    return faculty
        .students()
        .stream()
        .filter(s -> s.getFirstName().equals(name))
        .collect(Collectors.toList());
  }

  @Override
  public List<Student> getBestStudents(Faculty faculty) {
    return faculty
        .students()
        .stream()
        .filter(s -> s.getScore() > 90)
        .collect(Collectors.toList());
  }

  @Override
  public List<Student> sortBySecondNameAlphabetic(Faculty faculty) {
    return faculty
        .students()
        .stream()
        .sorted(Comparator.comparing(Person::getSecondName))
        .collect(Collectors.toList());
  }
}
