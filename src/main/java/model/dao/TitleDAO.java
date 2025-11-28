package model.dao;
import jakarta.persistence.EntityManager;
import model.entity.Title;

import java.time.LocalDate;

public class TitleDAO {
    public void create(EntityManager em, int empNo, String title, LocalDate fromDate, LocalDate toDate) {
        em.getTransaction().begin();
        em.persist(new Title(empNo, title, fromDate, toDate));
        em.getTransaction().commit();
    }
}
