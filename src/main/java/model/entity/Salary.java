package model.entity;

import jakarta.persistence.*;
import model.key.SalaryKey;

import java.time.LocalDate;

@Entity
@Table(name = "salaries")
public class Salary {
  @EmbeddedId
  private SalaryKey id;

  @Column(precision = 10, scale = 2)
  private int salary;
  private LocalDate toDate;

  public Salary() {}

  public Salary(SalaryKey id, int salary, LocalDate toDate) {
    this.id = id;
    this.salary = salary;
    this.toDate = toDate;
  }
}
