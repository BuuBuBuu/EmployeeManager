package model.key;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SalaryId implements Serializable {
  // Just add this line in serialVersionUID since seems like best practice
  // Its a version identifier used by java serialization and if omitted, jvm compute one anyway from class details
  // which can change across builds and cause InvalidClassException when deserialize
  private static final long serialVersionUID = 1L;

  private int empNo;

  private LocalDate fromDate;

  public SalaryId() {}

  public SalaryId(int empNo, LocalDate fromDate) {
    this.empNo = empNo;
    this.fromDate = fromDate;
  }


  // Apparently have to override the equals and hashCode methods
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SalaryId that = (SalaryId) o;
    return empNo == that.empNo && Objects.equals(fromDate, that.fromDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empNo, fromDate);
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }
}
