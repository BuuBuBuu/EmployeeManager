package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SalaryId implements Serializable {
  @Column(precision = 11)
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
}
