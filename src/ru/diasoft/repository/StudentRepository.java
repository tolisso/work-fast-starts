package ru.diasoft.repository;

import ru.diasoft.domain.Course;
import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

public class StudentRepository {

  public Faculty getFaculty() {
    Faculty f = new Faculty();

    Student stu = new Student(
        "Vova",
        "Kupchin",
        25,
        "+7(123)456-78-90",
        "M33381",
        85);
    stu.addCourse(new Course("Java", 40));
    stu.addCourse(new Course("Alpha", 40));
    stu.addCourse(new Course("Betta", 40));
    stu.addCourse(new Course("C++", 40));
    stu.addCourse(new Course("Fast starts", 90));
    f.addStudent(stu);

    f.addStudent(new Student(
        "Aba",
        "Guga",
        22,
        "+7(322)322-13-37",
        "M3101",
        100));
    f.addStudent(new Student(
        "Alex",
        "Produ",
        24,
        "+7(163)918-73-98",
        "M3401",
        75));
    f.addStudent(new Student(
        "Andrey",
        "Siziy",
        30,
        "+7(957)017-37-30",
        "P3271",
        50));
    f.addStudent(new Student(
        "Samson",
        "Blessed",
        47,
        "+7(777)333-22-22",
        "B3228",
        100));
    return f;
  }
}