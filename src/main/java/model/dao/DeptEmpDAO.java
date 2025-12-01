package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.DeptEmp;

import java.time.LocalDate;

/**
 * Data Access Object for DeptEmp entity
 */
public class DeptEmpDAO {
  /**
   * Create a new DeptEmp record
   * @param em entitymanager
   * @param empNo employee number
   * @param deptNo department number
   * @param fromDate fromDate
   * @param toDate toDate
   */
  public void create(EntityManager em, int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
    em.persist(new DeptEmp(empNo, deptNo, fromDate, toDate));
  }
}
