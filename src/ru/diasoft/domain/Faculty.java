package ru.diasoft.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Faculty {
  private List<Student> students = new ArrayList<>();

  public void addStudent(Student s) {
    students.add(s);
  }

  public List<Student> students() {
    return Collections.unmodifiableList(students);
  }
}
