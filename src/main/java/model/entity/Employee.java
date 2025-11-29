package model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @Column(name = "emp_no", precision = 11)
  private int empNo;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "first_name", length = 14)
  private String firstName;

  @Column(name = "last_name", length = 16)
  private String lastName;

  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "hire_date")
  private LocalDate hireDate;

  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<DeptEmp> deptEmployed = new ArrayList<>();

  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<DeptManager> isDeptManager = new ArrayList<>();

  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<Salary> salaries = new ArrayList<>();

  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<Title> titles = new ArrayList<>();

  public Employee() {}

  public Employee(int empNo, LocalDate birthDate, String firstName, String lastName, Gender gender, LocalDate hireDate) {
    this.empNo = empNo;
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  public List<DeptEmp> getdeptEmployed() {
    return deptEmployed;
  }

  public void setdeptEmployed(List<DeptEmp> deptEmployed) {
    this.deptEmployed = deptEmployed;
  }

  public List<DeptManager> getIsDeptManager() {
    return isDeptManager;
  }

  public void setIsDeptManager(List<DeptManager> isDeptManager) {
    this.isDeptManager = isDeptManager;
  }

  public List<Salary> getSalaries() {
    return salaries;
  }

  public void setSalaries(List<Salary> salaries) {
    this.salaries = salaries;
  }

  public List<Title> getTitles() {
    return titles;
  }

  public void setTitles(List<Title> titles) {
    this.titles = titles;
  }
}