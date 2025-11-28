package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.entity.Department;

import java.util.List;

public class DepartmentDAO {

  public List<Department> findAll(EntityManager em) {
    TypedQuery<Department> q = em.createQuery("SELECT d FROM Department d", Department.class);
    return q.getResultList();
  }
}
