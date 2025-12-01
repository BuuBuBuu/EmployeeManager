package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.Salary;

import java.time.LocalDate;

/**
 * Data Access Object for Salary entity
 */
public class SalaryDAO {
  /**
   * Create a new Salary record
   * @param em EntityManager
   * @param empNo Employee number
   * @param salary Salary amount
   * @param fromDate Start date of the salary
   * @param toDate End date of the salary
   */
  public void create(EntityManager em, int empNo, int salary, LocalDate fromDate, LocalDate toDate) {
    em.persist(new Salary(empNo, salary, fromDate, toDate));
  }

}
