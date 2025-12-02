package model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Employee;

import model.dto.EmployeeDTO;
import model.util.JPAUtil;

import java.util.List;

/**
 * Data Access Object for Employee entity
 */
public class EmployeeDAO {

  /**
   * Find an Employee by their employee number
   * @param empNo Employee number
   * @return Employee object or null if not found
   */
  public Employee findById(int empNo) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
      return em.find(Employee.class, empNo);
    }
  }


  /**
   * Find an Employee by their employee number OVERLOADDDEDDD
   * @param em EntityManager
   * @param empNo Employee number
   * @return Employee object or null if not found
   */
  public Employee findById(EntityManager em, int empNo) {
    return em.find(Employee.class, empNo);
  }

  /**
   * Retrieve all Employee records
   * @param em Entitymanager
   * @return List of Employee objects
   */
  public List<Employee> findAll(EntityManager em) {
    return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  }

  /**
   * Find Employees by Department with pagination
   * @param deptNo Department Number
   * @param page Page number (1-based)
   * @return List of EmployeeDTO objects
   */
  public List<EmployeeDTO> findEmployeesByDepartment(String deptNo, int page) {

    try (EntityManager em = JPAUtil.getEntityManager()) {
      // calculate the offset using page param
      int offset = (page - 1) * 20;

      // create JPQL query selecting employees using DeptEmp
      // REMEMBER not sure if this one need to return DISTINCT or no need.
      // I didnt really check the whole DB but its possible an employee join and then rejoin the dept
      // so if we take the EMP from the DeptEmp entity, its possible to get multiple of the same emp
      // addon the order by so that fix result when pagi
      TypedQuery<EmployeeDTO> query = em.createQuery(
          "SELECT DISTINCT NEW model.dto.EmployeeDTO(de.employee.empNo, de.employee.firstName, de.employee.lastName, de.employee.hireDate) " +
              "FROM DeptEmp de WHERE de.deptNo = :deptNo ORDER BY de.employee.empNo",
          EmployeeDTO.class
      );

      // bind the named para
      query.setParameter("deptNo", deptNo);

      // apply pagination
      query.setFirstResult(offset);
      query.setMaxResults(20);

      return query.getResultList();
    }
  }

}