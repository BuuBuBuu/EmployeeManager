package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DeptEmpKey implements Serializable {
  @Column(precision = 11)
  private int empNo;

  @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
  private String deptNo;

  public DeptEmpKey() {}

  public DeptEmpKey(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }
}
