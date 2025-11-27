package model.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import model.key.TitleId;

import java.time.LocalDate;

@Entity
@Table(name = "titles")
public class Title {
  @EmbeddedId
  private TitleId id;

  private LocalDate toDate;

  public Title() {}

  public Title(TitleId id, LocalDate toDate) {
    this.id = id;
    this.toDate = toDate;
  }
}
