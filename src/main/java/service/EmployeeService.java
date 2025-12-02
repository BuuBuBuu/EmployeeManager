package service;

import jakarta.persistence.EntityManager;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.dao.*;
import model.dto.EmployeeDTO;
import model.dto.PromotionDTO;
import model.entity.*;
import model.util.JPAUtil;

import java.time.LocalDate;
import java.util.*;

/**
 * Service class for Employee-related operations
 */
public class EmployeeService {

  /**
   * Employee Data Access Object
   */
  private EmployeeDAO dao = new EmployeeDAO();
  /**
   * Salary Data Access Object
   */
  private SalaryDAO salaryDAO = new SalaryDAO();

  /**
   * Title Data Access Object
   */
  private TitleDAO titleDAO = new TitleDAO();

  /**
   * Department Data Access Object
   */
  private DepartmentDAO departmentDAO = new DepartmentDAO();

  /**
   * DeptEmp Data Access Object
   */
  private DeptEmpDAO deptEmpDAO = new DeptEmpDAO();

  /**
   * DeptManager Data Access Object
   */
  private DeptManagerDAO deptManagerDAO = new DeptManagerDAO();

  /**
   * Helper method to find Employee by ID
   * @param empNo Employee Number
   * @param em EntityManager
   * @return Employee object if found, else null
   */
  private Employee findEmployeeById(int empNo, EntityManager em) {
    return dao.findById(em, empNo);
  }

  /**
   * Public method to find Employee by ID
   * @param empNo Employee Number
   * @return Employee object if found, else null
   */
  public Employee findEmployeeById(int empNo) {
//      EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return dao.findById(empNo);
  }

  /**
   * Promote an employee based on the provided PromotionDTO
   * @param promotionDTO Data Transfer Object containing promotion details
   * @return Response indicating success or failure of the operation (If failed return BadRequest with error messages)
   */
  public Response promoteEmployeeById(PromotionDTO promotionDTO) {
    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    LocalDate fromDate = LocalDate.now();
    LocalDate datePointer = LocalDate.of(9999, 1, 1);

    List<String> errors = new ArrayList<>();

    try {
      Employee employee = findEmployeeById(promotionDTO.getEmpNo(), em);
      em.getTransaction().begin();

      // Validations start here
      if (employee == null) {
        errors.add("Invalid empNo: Employee not found");
      }

      if (promotionDTO.getDeptNo().length() != 4) {
        errors.add("Invalid deptNo: Only 4 char length accepted");
      }

      if (departmentDAO.findById(em, promotionDTO.getDeptNo()) == null) {
        errors.add("Invalid deptNo: Department not found");
      }

      if (promotionDTO.getTitle() == null || promotionDTO.getTitle().trim().isEmpty()) {
        errors.add("Please enter the employee's title.");
      }

      if (promotionDTO.getSalary() <= 0) {
        errors.add("Invalid salary: Salary must be greater than 0");
      }

      if (!errors.isEmpty()) { // if there are errors, throw exception
        throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST)
            .entity(Collections.singletonMap("error", errors))
            .type(MediaType.APPLICATION_JSON)
            .build());
      }

      // If reached here, inputs are valid

      // ============== manager logic ==============
      List<DeptManager> deptManagers = employee.getIsDeptManager();
      // Loop through each manager entry
      // Set a boolean to track whether the manager has any records
      boolean isNotAlreadyManager = true;
      for (DeptManager deptManager : deptManagers) {
        // Check the deptManager's to date to get the employee's current deptManager record
        // Check whether the emp has any open managerial records

        // Emp is already a manager
        if (deptManager.getToDate().equals(datePointer)) {

          // Check if new title is "Manager"
          if (!promotionDTO.getTitle().equalsIgnoreCase("manager")) {
            // Here, new title is NOT "Manager"
            deptManager.setToDate(fromDate); // end the current managerial record
          } else if (!deptManager.getDeptNo().equalsIgnoreCase(promotionDTO.getDeptNo())) {
            // Here, new title IS "Manager"
            // AND given input deptNo is NEW
            // So we need to create new managerial record for the employee
            deptManager.setToDate(fromDate); // close out the existing record
            deptManagerDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getDeptNo(), fromDate, datePointer); // Create new record
          }

          // if the above if block doesn't run, it means:
          // Emp already has ACTIVE managerial record, Emp's Dept did NOT change
          // Thus we got to just keep the current record active with no change

          // In all cases, set this false to prevent the block below from creating a new record
          isNotAlreadyManager = false;
        }
      }

      // if it reach here and isNotManager is true then means that in the loop above
      // the employee does NOT have any open deptManager records
      // In this case we got to make the employee a manager by creating a fresh record
      if (isNotAlreadyManager) {
        // Create new manager record
        if (promotionDTO.getTitle().equalsIgnoreCase("manager")) {
          deptManagerDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getDeptNo(), fromDate, datePointer);
        }
      }

      // ============== salary ==============
      List<Salary> salaries = employee.getSalaries();

      for (Salary salary : salaries) {
        if (salary.getToDate().equals(datePointer)) {
          if (salary.getSalary() != promotionDTO.getSalary()) {
            if (salary.getFromDate().isEqual(fromDate)) { //  if current salary's fromDate equals to today's date
              salary.setSalary(promotionDTO.getSalary());
            } else { // else, can create normally
              salary.setToDate(fromDate);
              salaryDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getSalary(), fromDate, datePointer);
            }
          }
          break; // close the loop once you have found the current salary object
        }
      }

      // ============== title ==============
      // Make the title to title case with our helper func below
      String normalizedTitle = promotionDTO.getTitle() == null ? null : toTitleCase(promotionDTO.getTitle());
      List<Title> titles = employee.getTitles();

      boolean createRecord = false;
      // Close all records first
      for (Title title : titles) {
        // check the open record
        if (title.getToDate().equals(datePointer)) {
          // if the open record title not equals to promotion title
          if (!title.getTitle().equalsIgnoreCase(promotionDTO.getTitle())) {
            // close the open record
            title.setToDate(fromDate);
            // set a boolean to signify that we have closed and need to create
            createRecord = true;
          } else {
            // We reach here if the open record title is same as promotion title
            // Check if same title record from date is today's date
            if (title.getFromDate().equals(fromDate)) {
              // check if same title record to date is today's date
              if (title.getToDate().equals(fromDate)) {
                // Reopen record
                title.setToDate(datePointer);
              }
            }
          }
        }
      }

      if (createRecord) {
        titleDAO.create(em, promotionDTO.getEmpNo(), normalizedTitle, fromDate, datePointer);
      }

//      // Loop through each title
//      for (Title title : titles) {
//        boolean changedOldTitleToActive = false;
//        // Check if any of the existing titles match the new title being promoted to
//        if (title.getTitle().equalsIgnoreCase(normalizedTitle)) {
//          if (title.getFromDate().isEqual(fromDate)) {
//            // If the title being promoted to is the same as the current title
//            // and the fromDate is today, check toDate and make it datePointer if needed
//            if (!title.getToDate().equals(datePointer)) {
//              title.setToDate(datePointer);
//              changedOldTitleToActive = true;
//            }
//          }
//        }
//        // Check the title's to date to get the currently active title record
//        if (title.getToDate().equals(datePointer) && changedOldTitleToActive) {
//          // Check whether title in currently active title record is the same as the title in promotionDTO
//          // Do lower case?
//          if (!title.getTitle().equalsIgnoreCase(promotionDTO.getTitle())) {
//            // If different then we will set the fromDate to today's date - 1 (Not sure if it matters just ignore first)
//            title.setToDate(fromDate);
//            titleDAO.create(em, promotionDTO.getEmpNo(), normalizedTitle, fromDate, datePointer);
//          }
//          break; // close the loop once you have found the current title object
//        }
//      }

      // ============== department ==============
      List<DeptEmp> deptEmps = employee.getdeptEmployed();
      for (DeptEmp deptEmp : deptEmps) {
        if (deptEmp.getToDate().equals(datePointer)) {
          if (!deptEmp.getDeptNo().equalsIgnoreCase(promotionDTO.getDeptNo())) {
            // If different then we will set the fromDate to today's date - 1 (Not sure if it matters just ignore first)
            deptEmp.setToDate(fromDate);
            deptEmpDAO.create(em, promotionDTO.getEmpNo(), promotionDTO.getDeptNo(), fromDate, datePointer);
          }
          break; // close the loop once you have found the current deptEmp object
        }
      }

      em.getTransaction().commit();
      return Response.ok().build();
    } catch (Exception e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      e.printStackTrace();
      // for specific HTTP error, e.g. BadRequest
      if (e instanceof WebApplicationException) {
        throw e; // to send correct 400 code
      }
//      return Response.serverError().build();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(Collections.singletonMap("error", "An unexpected error occurred: " + e.getMessage()))
          .type(MediaType.APPLICATION_JSON)
          .build();
    } finally {
      em.close();
    }
  }

  /**
   * Get a paginated list of employees by department number
   * @param deptNo Department Number
   * @param page Page number for pagination (starting from 1)
   * @return List of EmployeeDTO objects
   */
  public List<EmployeeDTO> getEmployeesByDepartment(String deptNo, int page) {
    if (page < 1) {
      page = 1;
    }

//    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
      return dao.findEmployeesByDepartment(deptNo, page);
  }

  /**
   * Helper method to convert a string to title case
   * @param input Input string
   * @return Title-cased string
   */
  private String toTitleCase(String input) {
    if (input == null || input.isBlank()) {
      return input;
    }

    String[] words = input.trim().split("\\s+");
    StringBuilder cleanString = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
      String w = words[i].toLowerCase();
      if (!w.isEmpty()) {
        cleanString.append(Character.toUpperCase(w.charAt(0)));
        if (w.length() > 1) {
          cleanString.append(w.substring(1));
        }
      }
      if (i < words.length - 1) {
        cleanString.append(' ');
      }
    }
    return cleanString.toString();
  }

}
