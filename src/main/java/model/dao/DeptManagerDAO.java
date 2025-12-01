package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.DeptManager;

import java.time.LocalDate;

/**
 * Data Access Object for DeptManager entity
 */
public class DeptManagerDAO {
  /**
   * Create a new DeptManager record
   * @param em EntityManager
   * @param empNo Employee number
   * @param deptNo Department number
   * @param fromDate Start date of the department manager role
   * @param toDate End date of the department manager role
   */
  public void create(EntityManager em, int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
    em.persist(new DeptManager(empNo, deptNo, fromDate, toDate));
  }
}
