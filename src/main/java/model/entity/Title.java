package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import model.key.TitleId;

import java.time.LocalDate;

/**
 * Entity class representing the titles held by employees
 */
@Entity
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {
  /**
   * Employee number associated with the title
   */
  @JsonIgnore
  @Id
  @Column(name = "emp_no")
  private int empNo;

  /**
   * Title held by the employee
   */
  @Id
  @Column(name = "title")
  private String title;

  /**
   * Date when the title was assigned
   */
  @Id
  @Column(name = "from_date")
  private LocalDate fromDate;

  /**
   * Date when the title was relinquished
   */
  @Column(name = "to_date")
  private LocalDate toDate;

  /**
   * Reference to the associated Employee entity
   */
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
  private Employee employee;

  /**
   * Default constructor
   */
  public Title() {}

  /**
   * Parameterized constructor to initialize a Title instance
   * @param empNo    Employee number
   * @param title    Title held by the employee
   * @param fromDate Date when the title was assigned
   * @param toDate   Date when the title was relinquished
   */
  public Title(int empNo, String title, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.title = title;
    this.fromDate = fromDate;
    this.toDate = toDate;
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
   * @param empNo empNo to set
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get title
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set title
   * @param title title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get fromDate
   * @return fromDate
   */
  public LocalDate getFromDate() {
    return fromDate;
  }

  /**
   * Set fromDate
   * @param fromDate fromDate to set
   */
  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * Get toDate
   * @return toDate
   */
  public LocalDate getToDate() {
    return toDate;
  }

  /**
   * Set toDate
   * @param toDate toDate to set
   */
  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  /**
   * Get associated Employee entity
   * @return Employee
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * Set associated Employee entity
   * @param employee Employee to set
   */
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
