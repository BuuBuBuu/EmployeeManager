package model.key;

import java.io.Serializable;
import java.util.Objects;

/*
- Remember 1 thing to not when using IdClass
- Field names must match exactly between the IdClass and the Entity
- Field types must also match exactly
- Access types must also match
 */

/**
 * Composite key class for DeptEmp
 */
public class DeptEmpId implements Serializable {

  /**
   * Serialization version UID
   */
  private int empNo;

  /**
   * Department number
   */
  private String deptNo;

  /**
   * Default constructor
   */
  public DeptEmpId() {}

  /**
   * Parameterized constructor
   * @param empNo Employee number
   * @param deptNo Department number
   */
  public DeptEmpId(int empNo, String deptNo) {
    this.empNo = empNo;
    this.deptNo = deptNo;
  }

  // Apparently have to override the equals and hashCode methods
  /**
   * Equal mtd - have to override
   * @param o Object to compare
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeptEmpId that = (DeptEmpId) o;
    return empNo == that.empNo && Objects.equals(deptNo, that.deptNo);
  }

  /**
   * Hashcode mtd - have to override
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(empNo, deptNo);
  }

  /**
   * Get empNo
   * @return empNo
   */
  public int getEmpNo() {
    return empNo;
  }

  /**
   * Set empNo
   * @param empNo empNo
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get deptNo
   * @return deptNo
   */
  public String getDeptNo() {
    return deptNo;
  }

  /**
   * Set deptNo
   * @param deptNo deptNo
   */
  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }
}
