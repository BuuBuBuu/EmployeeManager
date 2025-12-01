package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import model.key.SalaryId;

import java.time.LocalDate;

/**
 * Entity class representing the salaries of employees.
 */
@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
  /**
   * Employee number associated with the salary.
   */
  @JsonIgnore
  @Id
  @Column(name = "emp_no")
  private int empNo;

  /**
   * Salary amount
   */
  @Column(name = "salary")
  private int salary;

  /**
   * Date when the salary became effective
   */
  @Id
  @Column(name = "from_date")
  private LocalDate fromDate;

  /**
   * Date when the salary is not effective anymore
   */
  @Column(name = "to_date")
  private LocalDate toDate;

  // "@JsonIgnore" to stop the infinite mirror issue
  // https://www.baeldung.com/java-jsonignore-vs-transient
  // "to specify a method or field that should be ignored during serialization and deserialization processes"
  // essentially what is happening is that Jackson goes inside Employee, does getSalaries()
  // -> Salary, does getEmployee()
  // -> Employee, does getSalaries())
  // -> etc. etc.
  // tells Jackson: "When you are scanning a Salary, pretend getEmployee() doesn't exist."
  /**
   * Reference to the associated Employee entity
   */
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  /**
   * Default constructor
   */
  public Salary() {}

  /**
   * Parameterized constructor to initialize a Salary instance
   * @param empNo    Employee number
   * @param salary   Salary amount
   * @param fromDate Date when the salary became effective
   * @param toDate   Date when the salary ceased to be effective
   */
  public Salary(int empNo, int salary, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.salary = salary;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  /**
   * Get empNo
   * @return empNo
   */
  public int getEmpNo() {
    return empNo;
  }

  /**
   * Set empNo
   * @param empNo Employee number
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get salary
   * @return salary
   */
  public int getSalary() {
    return salary;
  }

  /**
   * Set salary
   * @param salary Salary amount
   */
  public void setSalary(int salary) {
    this.salary = salary;
  }

  /**
   * Get fromDate
   * @return fromDate
   */
  public LocalDate getFromDate() {
    return fromDate;
  }

  /**
   * Set fromDate
   * @param fromDate Date when the salary became effective
   */
  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * Get toDate
   * @return toDate
   */
  public LocalDate getToDate() {
    return toDate;
  }

  /**
   * Set toDate
   * @param toDate Date when the salary ceased to be effective
   */
  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  /**
   * Get associated Employee entity
   * @return Employee entity
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * Set associated Employee entity
   * @param employee Employee entity
   */
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
