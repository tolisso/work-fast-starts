package ru.diasoft.micro.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OPERATION")
public class Operation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "client_id")
  private long clientId;

  @Column(name = "amount")
  private int amount;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "date")
  private LocalDate date;

  @PrePersist
  void date() {
    this.date = LocalDate.now();
  }
}
