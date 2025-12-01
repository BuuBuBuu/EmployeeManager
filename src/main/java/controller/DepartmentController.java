package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Department;
import service.DepartmentService;

import java.util.List;

/**
 * Controller for Department-related endpoints
 */
@Path("/departments")
public class DepartmentController {

  /**
   * Department Service for handling business logic
   */
  private final DepartmentService service = new DepartmentService();

  // endpoint 1 - GET /departments
  // http://localhost:8080/EmployeeManager/service/departments
  /**
   * Get all departments
   * @return List of Department objects
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Department> getAllDepartments() {
    return service.getAllDepartments();
  }
}
