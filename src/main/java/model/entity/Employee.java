package model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee entity mapped to "employees" table
 */
@Entity
@Table(name = "employees")
public class Employee {
  /**
   * Employee number (Primary Key)
   */
  @Id
  @Column(name = "emp_no", precision = 11)
  private int empNo;

  /**
   * Birth date of the employee
   */
  @Column(name = "birth_date")
  private LocalDate birthDate;

  /**
   * First name of the employee
   */
  @Column(name = "first_name", length = 14)
  private String firstName;

  /**
   * Last name of the employee
   */
  @Column(name = "last_name", length = 16)
  private String lastName;

  /**
   * Gender of the employee
   */
  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  /**
   * Hire date of the employee
   */
  @Column(name = "hire_date")
  private LocalDate hireDate;

  /**
   * Departments the employee is employed in
   */
  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<DeptEmp> deptEmployed = new ArrayList<>();

  /**
   * Departments where the employee is a manager
   */
  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<DeptManager> isDeptManager = new ArrayList<>();

  /**
   * Salaries of the employee
   */
  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  private List<Salary> salaries = new ArrayList<>();

  /**
   * Titles held by the employee
   */
  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
  @OrderBy("fromDate ASC")
  private List<Title> titles = new ArrayList<>();

  /**
   * Default constructor
   */
  public Employee() {}

  /**
   * Parameterized constructor
   * @param empNo
   * @param birthDate
   * @param firstName
   * @param lastName
   * @param gender
   * @param hireDate
   */
  public Employee(int empNo, LocalDate birthDate, String firstName, String lastName, Gender gender, LocalDate hireDate) {
    this.empNo = empNo;
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;
  }

  /**
   * Get employee number
   * @return empNo
   */
  public int getEmpNo() {
    return empNo;
  }

  /**
   * Set employee number
   * @param empNo Employee number
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get birth date
   * @return birthDate
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Set birth date
   * @param birthDate Birth date
   */
  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * Get first name
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set first name
   * @param firstName First name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get last name
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set last name
   * @param lastName Last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get gender
   * @return gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * Set gender
   * @param gender Gender
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * Get hire date
   * @return hireDate
   */
  public LocalDate getHireDate() {
    return hireDate;
  }

  /**
   * Set hire date
   * @param hireDate Hire date
   */
  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  /**
   * Get departments the employee is employed in
   * @return deptEmployed
   */
  public List<DeptEmp> getdeptEmployed() {
    return deptEmployed;
  }

  /**
   * Set departments the employee is employed in
   * @param deptEmployed List of DeptEmp
   */
  public void setdeptEmployed(List<DeptEmp> deptEmployed) {
    this.deptEmployed = deptEmployed;
  }

  /**
   * Get departments where the employee is a manager
   * @return isDeptManager
   */
  public List<DeptManager> getIsDeptManager() {
    return isDeptManager;
  }

  /**
   * Set departments where the employee is a manager
   * @param isDeptManager List of DeptManager
   */
  public void setIsDeptManager(List<DeptManager> isDeptManager) {
    this.isDeptManager = isDeptManager;
  }

  /**
   * Get salaries of the employee
   * @return salaries
   */
  public List<Salary> getSalaries() {
    return salaries;
  }

  /**
   * Set salaries of the employee
   * @param salaries List of Salary
   */
  public void setSalaries(List<Salary> salaries) {
    this.salaries = salaries;
  }

  /**
   * Get titles held by the employee
   * @return titles
   */
  public List<Title> getTitles() {
    return titles;
  }

  /**
   * Set titles held by the employee
   * @param titles List of Title
   */
  public void setTitles(List<Title> titles) {
    this.titles = titles;
  }
}