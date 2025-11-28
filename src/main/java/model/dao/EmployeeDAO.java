package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Employee;

import java.util.List;

public class EmployeeDAO {

  public Employee findById(EntityManager em, int empNo) {
    return em.find(Employee.class, empNo);
  }

  public List<Employee> findAll(EntityManager em) {
    return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  }

  public List<Employee> findEmployeesByDepartment(EntityManager em, String deptNo, int page) {

    // calculate the offset using page param
    int offset = (page - 1) * 20;

    // create JPQL query selecting employees using DeptEmp
    // REMEMBER not sure if this one need to return DISTINCT or no need.
    // I didnt really check the whole DB but its possible an employee join and then rejoin the dept
    // so if we take the EMP from the DeptEmp entity, its possible to get multiple of the same emp
    // addon the order by so that fix result when pagi
    TypedQuery<Employee> q = em.createQuery(
        "SELECT DISTINCT de.employee FROM DeptEmp de WHERE de.deptNo = :deptNo ORDER BY de.employee.empNo",
        Employee.class
    );

    // bind the named param
    q.setParameter("deptNo", deptNo);

    // apply pagination
    q.setFirstResult(offset);
    q.setMaxResults(20);

    return q.getResultList();
  }

}