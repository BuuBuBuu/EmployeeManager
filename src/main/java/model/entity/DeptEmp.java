package model.entity;

import jakarta.persistence.*;
import model.key.DeptEmpId;

import java.time.LocalDate;

@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpId.class)
public class DeptEmp {
  @Id
  @Column(name = "emp_no")
  private int empNo;

  @Id
  @Column(name = "dept_no")
  private String deptNo;

  @Column(name = "from_date")
  private LocalDate fromDate;

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
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
  private Department department;

  public DeptEmp() {}

  public DeptEmp(int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.deptNo = deptNo;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }
}
