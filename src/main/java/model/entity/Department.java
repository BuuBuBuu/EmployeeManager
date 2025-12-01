package model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Department entity mapped to "departments" table
 */
@Entity
@Table(name = "departments")
public class Department {
  /**
   * Department number (Primary Key)
   */
  @Id
  @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
  private String deptNo;

  /**
   * Department name
   */
  @Column(name = "dept_name", length = 40)
  private String deptName;

  /**
   * Employees in the department
   */
  @OneToMany(mappedBy = "department")
  private List<DeptEmp> deptEmps = new ArrayList<>();

  /**
   * Managers of the department
   */
  @OneToMany(mappedBy = "department")
  private List<DeptManager> deptManagers = new ArrayList<>();

  /**
   * Default constructor
   */
  public Department() {}

  /**
   * Parameterized constructor
   * @param deptNo Department number
   * @param deptName Department name
   */
  public Department(String deptNo, String deptName) {
    this.deptNo = deptNo;
    this.deptName = deptName;
  }

  /**
   * Get department number
   * @return department number
   */
  public String getDeptNo() {
    return deptNo;
  }

  /**
   * Set department number
   * @param deptNo department number
   */
  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  /**
   * Get department name
   * @return department name
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * Set department name
   * @param deptName department name
   */
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}
