package service;

import jakarta.persistence.EntityManager;
import jakarta.ws.rs.BadRequestException;
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

    private Employee findEmployeeById(int empNo, EntityManager em) {
      return dao.findById(em, empNo);
    }

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
    Employee employee = findEmployeeById(promotionDTO.getEmpNo(), em);

    LocalDate currentDate = LocalDate.now();
    LocalDate datePointer = LocalDate.of(9999, 1, 1);

    try {
      em.getTransaction().begin();

      // find employee
      if (employee == null) {
        throw new BadRequestException("Invalid employee id.");
      }

      // salary - DONE
      // don't need to do process salary it is not provided
      if (promotionDTO.getSalary() != -1) { // if not default value, means salary is provided

        // if negative salary
        if (promotionDTO.getSalary() < 0)
           throw new BadRequestException("Invalid salary, unable to update.");

        List<Salary> salaries = employee.getSalaries();
        for (Salary salary : salaries) {
          if (salary.getToDate().equals(datePointer)) {
            // don't update if same salary is provided
            if (salary.getSalary() != promotionDTO.getSalary()) {
              salary.setToDate(currentDate);
              salaryDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getSalary(), currentDate, datePointer);
            }
            break; // close the loop once you have found the salary object
          }
        }
      }

      if (!Objects.equals(promotionDTO.getTitle(), "")) { // if not empty string, means new title is provided
// titles
//      List<Title> titles = employee.getTitles();
//      for (Title title : titles) {
//        if (title.getEmpNo() == employee.getEmpNo()) {
//          if (!Objects.equals(title.getTitle(), promotionDTO.getTitle())) {
//            title.setToDate(currentDate);
//            titleDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getTitle(), currentDate, datePointer);
//          }
//        }
//      }
      }

      if (!Objects.equals(promotionDTO.getDeptNo(), "")) { // if not empty string, means new dept is provided
        // ok this one v mafan
      }

      // deptManager still need?

      // need to change dept_emp
      // need to change dept_manager SHOULD BE isDeptManager (???)

      em.getTransaction().commit(); // if we get here,save
      return Response.ok().build();

    } catch (Exception e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      e.printStackTrace(); // can be better, todo later
      return Response.status(Response.Status.BAD_REQUEST).build();

    } finally {
      em.close();
    }
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
