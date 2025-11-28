package model.key;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TitleId implements Serializable {
  // Just add this line in serialVersionUID since seems like best practice
  // Its a version identifier used by java serialization and if omitted, jvm compute one anyway from class details
  // which can change across builds and cause InvalidClassException when deserialize
  private static final long serialVersionUID = 1L;

  private int empNo;

  private String title;
  private LocalDate fromDate;

  public TitleId() {}

  public TitleId(int empNo, String title, LocalDate fromDate) {
    this.empNo = empNo;
    this.title = title;
    this.fromDate = fromDate;
  }

  // Apparently have to override the equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TitleId that = (TitleId) o;
    return empNo == that.empNo && Objects.equals(title, that.title) && Objects.equals(fromDate, that.fromDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empNo, title, fromDate);
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }
}
