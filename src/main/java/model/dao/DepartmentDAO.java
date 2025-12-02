package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Department;
import model.util.JPAUtil;

import java.util.List;

/**
 * Data Access Object for Department entity
 */
public class DepartmentDAO {

  // for validation if a department no. exists before executing promote employee action
  /**
   * Find a Department by its ID
   * @param em EntityManager
   * @param id Department ID
   * @return Department object or null if not found
   */
  public Department findById(EntityManager em, String id) {
    return em.find(Department.class, id);
  }

  /**
   * Retrieve all Department records
   * @return List of Department objects
   */
  public List<Department> findAll() {

    try (EntityManager em = JPAUtil.getEntityManager()) {
      TypedQuery<Department> q = em.createQuery("SELECT d FROM Department d ORDER BY d.deptNo", Department.class);
      return q.getResultList();
    }
  }
}
