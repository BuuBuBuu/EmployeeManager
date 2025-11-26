package model.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DeptEmpKey implements Serializable {
  private int empNo;
  private String deptNo;

  public DeptEmpKey() {}

  public DeptEmpKey(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }
}
