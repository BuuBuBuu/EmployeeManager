package service;

import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;
import model.dao.EmployeeDAO;
import model.dao.SalaryDAO;
import model.dao.TitleDAO;
import model.dto.EmployeeDTO;
import model.dto.PromotionDTO;
import model.entity.Employee;
import model.entity.Salary;
import model.entity.Title;
import model.util.JPAUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EmployeeService {

  private EmployeeDAO dao = new EmployeeDAO();
  private SalaryDAO salaryDAO = new SalaryDAO();
  private TitleDAO titleDAO = new TitleDAO();

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

  public Response promoteEmployeeById(PromotionDTO promotionDTO) {
    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    LocalDate fromDate = LocalDate.now();
    LocalDate datePointer = LocalDate.of(9999, 1, 1);

    Employee employee = findEmployeeById(promotionDTO.getEmpNo());
    List<Salary> salaries = employee.getSalaries();
    for (Salary salary : salaries) {
      if (salary.getToDate().equals(datePointer)) {
        if (salary.getSalary() != promotionDTO.getSalary()) {
          salary.setToDate(fromDate);
          salaryDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getSalary(), fromDate, datePointer);
        }
      }
    }

    List<Title> titles = employee.getTitles();
    for (Title title : titles) {
      if (title.getEmpNo() == employee.getEmpNo()) {
        if (!Objects.equals(title.getTitle(), promotionDTO.getTitle())) {
          title.setToDate(fromDate);
          titleDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getTitle(), fromDate, datePointer);
        }
      }
    }

    // need to change dept_emp
    // need to change dept_manager

    return Response.ok().build();
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
