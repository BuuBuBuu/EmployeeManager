package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.DeptManager;

import java.time.LocalDate;

public class DeptManagerDAO {
    public void create(EntityManager em, int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
        em.persist(new DeptManager(empNo, deptNo, fromDate, toDate));
    }
}
