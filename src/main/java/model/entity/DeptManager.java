package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import model.key.DeptManagerId;

import java.time.LocalDate;

@Entity
@Table(name = "dept_manager")
@IdClass(DeptManagerId.class)
public class DeptManager {
  @JsonIgnore
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

  @JsonIgnore // same for this! JsonIgnore is optional actually but put here first
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
  private Department department;

  public DeptManager() {}

  public DeptManager(int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
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
