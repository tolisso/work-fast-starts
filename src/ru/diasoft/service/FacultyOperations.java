package ru.diasoft.service;

import java.util.List;
import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

public interface FacultyOperations {
  List<Student> byName(Faculty faculty, String name);
  List<Student> getBestStudents(Faculty faculty);
  List<Student> sortBySecondNameAlphabetic(Faculty faculty);
}
