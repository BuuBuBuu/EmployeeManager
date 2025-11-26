package model.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DeptManagerKey implements Serializable {
  private int empNo;
  private String deptNo;

  public DeptManagerKey() {}

  public DeptManagerKey(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }
}
