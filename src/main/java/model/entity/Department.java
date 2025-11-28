package model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
  @Id
  @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
  private String deptNo;

  @Column(name = "dept_name", length = 40)
  private String deptName;

  @OneToMany(mappedBy = "department")
  private List<DeptEmp> deptEmps = new ArrayList<>();

  @OneToMany(mappedBy = "department")
  private List<DeptManager> deptManagers = new ArrayList<>();

  public Department() {}

  public Department(String deptNo, String deptName) {
    this.deptNo = deptNo;
    this.deptName = deptName;
  }

  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}
