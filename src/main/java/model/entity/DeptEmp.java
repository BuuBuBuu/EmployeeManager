package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import model.key.DeptEmpId;

import java.time.LocalDate;

/**
 * Entity class representing the association between employees and departments.
 */
@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpId.class)
public class DeptEmp {
  /**
   * Employee number associated with the department.
   */
  @JsonIgnore
  @Id
  @Column(name = "emp_no")
  private int empNo;

  /**
   * Department number associated with the employee.
   */
  @Id
  @Column(name = "dept_no")
  private String deptNo;

  /**
   * Date when the employee started in the department.
   */
  @Column(name = "from_date")
  private LocalDate fromDate;

  /**
   * Date when the employee left the department.
   */
  @Column(name = "to_date")
  private LocalDate toDate;

  // Intuition here is like this: I link DeptEmp to Employee table through name (FK in DeptEmp) and referencedColumnName (PK in Employee)
  // Just for understanding, this creates a lazy loading thingy
  // Upon creating, employee is a Java memory reference
  // HOWEVER, before Hibernate loads anything, that reference points o a Hibernate proxy, not a real Employee object
  // The proxy knows the FK value (emp_no), The target table (employees) , the target PK column (emp_no), how to fetch the real Employee object from the DB
  // Only when we call something like this deptEmp.getEmployee().getFirstName();
  // Then Hibernate goes to use the FK VALUE! to fetch the ACTUAL Employee object.
  // And then FINALLY the employee proxy we instantiated.
  // Just to remember... @ManyToOne tells Hibernate WHAT KIND of relationship this is.
  // (One DeptEmp belongs to one Employee)
  // (employee is an entity reference)
  // TLDR for @ManyToOne, This tells Hibernate to: Load this as an object reference, not as a primitive value.
  // @JoinColumn tells Hibernate HOW the reference is stored in the database.
  // (The FK column is emp_no), (That FK points to Employee's PK [referencedColumnName]
  // TLDR for @JoinColumn = This tells Hibernate: which column to use as the pointer
  /**
   * Reference to the associated Employee entity.
   */
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  /**
   * Reference to the associated Department entity.
   */
  @ManyToOne
  @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
  private Department department;

  /**
   * Default constructor.
   */
  public DeptEmp() {}

  /**
   * Parameterized constructor to initialize a DeptEmp instance.
   * @param empNo
   * @param deptNo
   * @param fromDate
   * @param toDate
   */
  public DeptEmp(int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
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
   * @param empNo Employee number
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
   * @param deptNo Department number
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
   * @param fromDate Date when the employee started in the department
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
   * @param toDate Date when the employee left the department
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
