package ru.diasoft.domain;

import java.util.Comparator;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Student extends Person {

  private String group;
  private int score;
  private final TreeSet<Course> courses
      = new TreeSet<>(Comparator.comparing(Course::getTitle).reversed());

  public Student(String firstName, String secondName, int age, String phone, String group,
      int score) {
    super(firstName, secondName, age, phone);
    this.group = group;
    this.score = score;
  }

  public void addCourse(Course c) {
    courses.add(c);
  }
}
