package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DeptEmpId implements Serializable {
  @Column(precision = 11)
  private int empNo;

  @Column(name = "dept_no", nullable = false)
  private String deptNo;

  public DeptEmpId() {}

  public DeptEmpId(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
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

  // Apparently have to override the equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeptEmpId that = (DeptEmpId) o;
    return empNo == that.empNo && Objects.equals(deptNo, that.deptNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empNo, deptNo);
  }
}
