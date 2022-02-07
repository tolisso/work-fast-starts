package ru.diasoft.domain;

import lombok.Data;

public class Student extends Person {
  private String group;
  private int score;

  public Student(String firstName, String secondName, int age) {
    super(firstName, secondName, age);
  }

  public Student(String firstName, String secondName, int age, String phone, String group,
      int score) {
    super(firstName, secondName, age, phone);
    this.group = group;
    this.score = score;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
