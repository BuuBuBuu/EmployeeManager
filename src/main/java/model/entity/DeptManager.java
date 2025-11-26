package model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import model.key.DeptManagerKey;

import java.time.LocalDate;

@Entity
@Table(name = "dept_manager")
public class DeptManager {
  @EmbeddedId
  private DeptManagerKey id;

  private LocalDate fromDate;
  private LocalDate toDate;

  public DeptManager() {}

  public DeptManager(DeptManagerKey id, LocalDate fromDate, LocalDate toDate) {
    this.id = id;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }
}
