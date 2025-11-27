package model.entity;

import jakarta.persistence.*;
import model.key.SalaryId;

import java.time.LocalDate;

@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
  @Id
  private int emp_no;

  @Id
  private LocalDate fromDate;

  @Column(precision = 10, scale = 2)
  private int salary;
  private LocalDate toDate;

  public Salary() {}

  public Salary(int emp_no, LocalDate fromDate, int salary, LocalDate toDate) {
    this.emp_no = emp_no;
    this.fromDate = fromDate;
    this.salary = salary;
    this.toDate = toDate;
  }

  public int getEmp_no() {
    return emp_no;
  }

  public void setEmp_no(int emp_no) {
    this.emp_no = emp_no;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }
}
