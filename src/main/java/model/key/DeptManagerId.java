package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DeptManagerId implements Serializable {
  @Column(precision = 11)
  private int empNo;

  @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
  private String deptNo;

  public DeptManagerId() {}

  public DeptManagerId(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return false;
    if (o == null || getClass() != o.getClass()) return false;
    DeptManagerId that  = (DeptManagerId) o;
    return

  }
}
