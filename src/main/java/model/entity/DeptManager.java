package model.entity;

import jakarta.persistence.*;
import model.key.DeptManagerId;

import java.time.LocalDate;

@Entity
@Table(name = "dept_manager")
@IdClass(DeptManagerId.class)
public class DeptManager {
  @Id
  private int empNo;

  @Id
  private String deptNo;

  private LocalDate fromDate;
  private LocalDate toDate;

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
