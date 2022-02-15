package ru.diasoft.service;

import java.util.List;
import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

public interface FacultyOperations {
  List<Student> byName(String name);
  List<Student> getBestStudents();
  List<Student> sortBySecondNameAlphabetic();
}
