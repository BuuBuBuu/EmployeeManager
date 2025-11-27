package model.entity;


import jakarta.persistence.*;
import model.key.TitleId;

import java.time.LocalDate;

@Entity
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {
  private TitleId id;

  @Id
  private int empNo;

  @Id
  private String title;

  @Id
  private LocalDate fromDate;

  private LocalDate toDate;

  public Title() {}

  public Title(int empNo, String title, LocalDate fromDate, LocalDate toDate) {
    this.empNo = empNo;
    this.title = title;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public TitleId getId() {
    return id;
  }

  public void setId(TitleId id) {
    this.id = id;
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

  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }
}
