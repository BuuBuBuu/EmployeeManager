package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Employee;

import model.dto.EmployeeDTO;
import java.util.List;

public class EmployeeDAO {

  public Employee findById(EntityManager em, int empNo) {
    return em.find(Employee.class, empNo);
  }

  public List<Employee> findAll(EntityManager em) {
    return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  }

  public List<EmployeeDTO> findEmployeesByDepartment(EntityManager em, String deptNo, int page) {

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