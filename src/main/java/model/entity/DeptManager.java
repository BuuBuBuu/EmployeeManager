package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import model.key.DeptManagerId;

import java.time.LocalDate;

/**
 * Entity class representing department managers
 */
@Entity
@Table(name = "dept_manager")
@IdClass(DeptManagerId.class)
public class DeptManager {
  /**
   * Employee number of the department manager
   */
  @JsonIgnore
  @Id
  @Column(name = "emp_no")
  private int empNo;

  /**
   * Department number managed by the employee
   */
  @Id
  @Column(name = "dept_no")
  private String deptNo;

  /**
   * Date when the employee started managing the department
   */
  @Column(name = "from_date")
  private LocalDate fromDate;

  /**
   * Date when the employee stopped managing the department
   */
  @Column(name = "to_date")
  private LocalDate toDate;

  /**
   * Reference to the associated Employee entity
   */
  @JsonIgnore // same for this! JsonIgnore is optional actually but put here first
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  /**
   * Reference to the associated Department entity
   */
  @ManyToOne
  @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
  private Department department;

  /**
   * Default constructor
   */
  public DeptManager() {}

  /**
   * Parameterized constructor to initialize a DeptManager instance
   * @param empNo    Employee number of the department manager
   * @param deptNo   Department number managed by the employee
   * @param fromDate Date when the employee started managing the department
   * @param toDate   Date when the employee stopped managing the department
   */
  public DeptManager(int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.deptNo = deptNo;
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
   * @param empNo Employee number of the department manager
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get deptNo
   * @return deptNo
   */
  public String getDeptNo() {
    return deptNo;
  }

  /**
   * Set deptNo
   * @param deptNo Department number managed by the employee
   */
  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
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
   * @param fromDate Date when the employee started managing the department
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
   * @param toDate Date when the employee stopped managing the department
   */
  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  /**
   * Get associated Employee entity
   * @return Employee
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

  /**
   * Get associated Department entity
   * @return Department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * Set associated Department entity
   * @param department Department entity
   */
  public void setDepartment(Department department) {
    this.department = department;
  }
}
