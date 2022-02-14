package ru.diasoft.domain;

public class Course {

  private final String title;
  private final int score;

  public Course(String title, int score) {
    this.title = title;
    this.score = score;
  }

  public String getTitle() {
    return title;
  }

  public int getScore() {
    return score;
  }
}
