package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.DeptEmp;

import java.time.LocalDate;

public class DeptEmpDAO {
    public void create(EntityManager em, int empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
        em.persist(new DeptEmp(empNo, deptNo, fromDate, toDate));
    }
}
