package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/*
- Remember 1 thing to not when using IdClass
- Field names must match exactly between the IdClass and the Entity
- Field types must also match exactly
- Access types must also match
 */

public class DeptEmpId implements Serializable {
  private int empNo;

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
