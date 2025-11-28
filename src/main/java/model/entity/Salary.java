package model.entity;

import jakarta.persistence.*;
import model.key.SalaryId;

import java.time.LocalDate;

@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
  @Id
  @Column(name = "emp_no")
  private int empNo;

  @Id
  @Column(name = "from_date")
  private LocalDate fromDate;

  @Column(name = "salary")
  private int salary;

  @Column(name = "to_date")
  private LocalDate toDate;

  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  public Salary() {}

  public Salary(int empNo, int salary, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.salary = salary;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
