package service;

import jakarta.persistence.EntityManager;
import model.dao.DepartmentDAO;
import model.entity.Department;
import model.util.JPAUtil;

import java.util.List;

/**
 * Service class for Department-related endpoints
 */
public class DepartmentService {
  /**
   * Department Data Access Object
   */
  private DepartmentDAO dao = new DepartmentDAO();

  /**
   * Retrieve all departments
   * @return List of Department objects
   */
  public List<Department> getAllDepartments() {
//    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
      return dao.findAll();
  }

}
