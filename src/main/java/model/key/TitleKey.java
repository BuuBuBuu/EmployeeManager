package model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class TitleKey implements Serializable {
  @Column(precision = 11)
  private int empNo;

  @Column(name = "title", length = 50)
  private String title;
  private LocalDate fromDate;
}
