package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class SalaryId implements Serializable {
  @Column(precision = 11)
  private int empNo;

  private LocalDate fromDate;

  public SalaryId() {}

  public SalaryId(int empNo, LocalDate fromDate) {
    this.empNo = empNo;
    this.fromDate = fromDate;
  }
}
