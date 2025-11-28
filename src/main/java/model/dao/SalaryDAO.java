package model.dao;

import jakarta.persistence.EntityManager;
import model.entity.Salary;

import java.time.LocalDate;

public class SalaryDAO {
    public void create(EntityManager em, int empNo, int salary, LocalDate fromDate, LocalDate toDate) {
        em.getTransaction().begin();
        em.persist(new Salary(empNo, salary, fromDate, toDate));
        em.getTransaction().commit();
    }

}
