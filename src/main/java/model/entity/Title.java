package model.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import model.key.TitleKey;

import java.time.LocalDate;

@Entity
@Table(name = "titles")
public class Title {

  @EmbeddedId
  private TitleKey id;

  private LocalDate toDate;

  public Title() {}

  public Title(TitleKey id, LocalDate toDate) {
    this.id = id;
    this.toDate = toDate;
  }
}
