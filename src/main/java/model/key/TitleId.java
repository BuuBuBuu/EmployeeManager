package model.key;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Composite Key class for Title entity
 */
public class TitleId implements Serializable {
  // Just add this line in serialVersionUID since seems like best practice
  // Its a version identifier used by java serialization and if omitted, jvm compute one anyway from class details
  // which can change across builds and cause InvalidClassException when deserialize
  /**
   * Serialization version UID
   */
  private static final long serialVersionUID = 1L;

  /**
   * Employee umber
   */
  private int empNo;

  /**
   * Title name
   */
  private String title;

  /**
   * From date
   */
  private LocalDate fromDate;

  /**
   * Default constructor
   */
  public TitleId() {}

  /**
   * Parameterized constructor
   * @param empNo
   * @param title
   * @param fromDate
   */
  public TitleId(int empNo, String title, LocalDate fromDate) {
    this.empNo = empNo;
    this.title = title;
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
    TitleId that = (TitleId) o;
    return empNo == that.empNo && Objects.equals(title, that.title) && Objects.equals(fromDate, that.fromDate);
  }

  /**
   * Hashcode mtd - have to override
   * @return
   */
  @Override
  public int hashCode() {
    return Objects.hash(empNo, title, fromDate);
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
   * @param empNo
   */
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  /**
   * Get title
   * @return
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set title
   * @param title
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
   * @param fromDate
   */
  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }
}
