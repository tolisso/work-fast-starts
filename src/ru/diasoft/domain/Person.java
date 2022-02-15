package ru.diasoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private String firstName;
  private String secondName;
  private int age;
  private String phone;

}
