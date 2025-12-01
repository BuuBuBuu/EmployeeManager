package model.key;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Composite Key class for Salary entity
 */
public class SalaryId implements Serializable {
  // Just add this line in serialVersionUID since seems like best practice
  // Its a version identifier used by java serialization and if omitted, jvm compute one anyway from class details
  // which can change across builds and cause InvalidClassException when deserialize
  /**
   * Serialization version UID
   */
  private static final long serialVersionUID = 1L;

  /**
   * Employee number
   */
  private int empNo;

  /**
   * From date
   */
  private LocalDate fromDate;

  /**
   * Default constructor
   */
  public SalaryId() {}

  /**
   * Parameterized constructor
   * @param empNo Employee number
   * @param fromDate From date
   */
  public SalaryId(int empNo, LocalDate fromDate) {
    this.empNo = empNo;
    this.fromDate = fromDate;
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
    SalaryId that = (SalaryId) o;
    return empNo == that.empNo && Objects.equals(fromDate, that.fromDate);
  }

  /**
   * Hashcode mtd - have to override
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(empNo, fromDate);
  }

  /**
   * Get empNo
   * @return
   */
  public int getEmpNo() {
    return empNo;
  }

  /**
   * Set empNo
   * @param empNo
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
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
   * @param fromDate
   */
  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }
}
