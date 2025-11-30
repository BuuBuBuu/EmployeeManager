package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Department;

import java.util.List;

public class DepartmentDAO {

  // for validation if a department no. exists before executing promote employee action
  public Department findById(EntityManager em, String id) {
    return em.find(Department.class, id);
  }

  public List<Department> findAll(EntityManager em) {
    TypedQuery<Department> q = em.createQuery("SELECT d FROM Department d", Department.class);
    return q.getResultList();
  }
}
