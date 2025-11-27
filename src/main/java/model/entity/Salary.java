package model.entity;

import jakarta.persistence.*;
import model.key.SalaryId;

import java.time.LocalDate;

@Entity
@Table(name = "salaries")
public class Salary {
  @EmbeddedId
  private SalaryId id;

  @Column(precision = 10, scale = 2)
  private int salary;
  private LocalDate toDate;

  public Salary() {}

  public Salary(SalaryId id, int salary, LocalDate toDate) {
    this.id = id;
    this.salary = salary;
    this.toDate = toDate;
  }
}
