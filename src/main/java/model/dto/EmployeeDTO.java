package model.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for Employee entity
 */
public class EmployeeDTO {
  /**
   * Employee number
   */
  private int empNo;
  /**
   * First name of the employee
   */
  private String firstName;
  /**
   * Last name of the employee
   */
  private String lastName;
  /**
   * Hire date of the employee
   */
  private LocalDate hireDate;

  /**
   * Constructor for EmployeeDTO
   * @param empNo Employee number
   * @param firstName First name of the employee
   * @param lastName Last name of the employee
   * @param hireDate Hire date of the employee
   */
  public EmployeeDTO(int empNo, String firstName, String lastName, LocalDate hireDate) {
    this.empNo = empNo;
    this.firstName = firstName;
    this.lastName = lastName;
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
}
