package model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
  @Id
  private int emp_no;

  private LocalDate birthDate;

  @Column(name = "first_name", length = 14)
  private String firstName;

  @Column(name = "last_name", length = 16)
  private String lastName;

  @Column(name = "gender", columnDefinition = "enum('M', 'F')", nullable = false)
  private String gender;

  private LocalDate hireDate;

  public Employee() {}

  public Employee(int emp_no, LocalDate birthDate, String firstName, String lastName, String gender, LocalDate hireDate) {
    this.emp_no = emp_no;
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;
  }

  public int getEmp_no() {
    return emp_no;
  }

  public void setEmp_no(int emp_no) {
    this.emp_no = emp_no;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    gender = gender.toLowerCase();
    if (gender == "m" || gender == "f") {

    }
    this.gender = gender;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }
}