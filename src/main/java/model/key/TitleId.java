package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TitleId implements Serializable {
  @Column(precision = 11)
  private int empNo;

  @Column(name = "title", length = 50)
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

}
