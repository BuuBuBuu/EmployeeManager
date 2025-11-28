package service;

import jakarta.persistence.EntityManager;
import model.dao.EmployeeDAO;
import model.dto.EmployeeDTO;
import model.entity.Employee;
import model.util.JPAUtil;

import java.util.List;

public class EmployeeService {

  private EmployeeDAO dao = new EmployeeDAO();


  public Employee findEmployeeById(int empNo) {
    {
      EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

      try {
        return dao.findById(em, empNo);
      } catch (Exception e) {
        throw e;
      } finally {
        em.close();
      }
    }
  }

  public List<EmployeeDTO> getEmployeesByDepartment(String deptNo, int page) {
    if (page < 1) {
      page = 1;
    }

    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    try {
      return dao.findEmployeesByDepartment(em, deptNo, page);
    } catch (Exception e) {
      throw e;
    } finally {
      em.close();
    }
  }
}
