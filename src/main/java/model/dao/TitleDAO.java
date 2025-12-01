package model.dao;
import jakarta.persistence.EntityManager;
import model.entity.Title;

import java.time.LocalDate;

/**
 * Data Access Object for Title entity
 */
public class TitleDAO {
  /**
   * Create a new Title record
   * @param em EntityManager
   * @param empNo Employee Number
   * @param title Title name
   * @param fromDate Start date of the title
   * @param toDate End date of the title
   */
  public void create(EntityManager em, int empNo, String title, LocalDate fromDate, LocalDate toDate) {
    em.persist(new Title(empNo, title, fromDate, toDate));
  }
}
