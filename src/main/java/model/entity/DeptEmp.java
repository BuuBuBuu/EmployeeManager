package model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import model.key.DeptEmpId;

import java.time.LocalDate;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {
  @EmbeddedId
  private DeptEmpId id;

  private LocalDate fromDate;
  private LocalDate toDate;

  public DeptEmp() {}

  public DeptEmp(DeptEmpId id, LocalDate fromDate, LocalDate toDate) {
    this.id = id;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }
}
