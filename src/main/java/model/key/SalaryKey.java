package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class SalaryKey implements Serializable {
  @Column(precision = 11)
  private int empNo;

  private LocalDate fromDate;

  public SalaryKey() {}

  public SalaryKey(int empNo, LocalDate fromDate) {
    this.empNo = empNo;
    this.fromDate = fromDate;
  }
}
