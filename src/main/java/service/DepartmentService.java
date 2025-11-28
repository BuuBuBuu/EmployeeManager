package service;

import jakarta.persistence.EntityManager;
import model.dao.DepartmentDAO;
import model.entity.Department;
import model.util.JPAUtil;

import java.util.List;

public class DepartmentService {

  private DepartmentDAO dao = new DepartmentDAO();

  public List<Department> getAllDepartments() {
    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    try {
      return dao.findAll(em);
    } catch (Exception e) {
      throw e;
    } finally {
      em.close();
    }
  }

}
