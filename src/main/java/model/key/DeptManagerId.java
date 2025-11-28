package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class DeptManagerId implements Serializable {
  private int empNo;

  private String deptNo;

  public DeptManagerId() {}

  public DeptManagerId(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }

  // Apparently have to override the equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeptManagerId that  = (DeptManagerId) o;
    return empNo == that.empNo && Objects.equals(deptNo, that.deptNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empNo, deptNo);
  }
}
