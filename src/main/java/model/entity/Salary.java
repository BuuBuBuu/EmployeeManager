package model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import model.key.SalaryKey;

import java.time.LocalDate;

@Entity
@Table(name = "salaries")
public class Salary {
  @EmbeddedId
  private SalaryKey id;

  private int salary;
  private LocalDate toDate;

  public Salary() {}

  public Salary(SalaryKey id, int salary, LocalDate toDate) {
    this.id = id;
    this.salary = salary;
    this.toDate = toDate;
  }
}
