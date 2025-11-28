package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Department;
import service.DepartmentService;

import java.util.List;

@Path("/departments")
public class DepartmentController {

  private final DepartmentService service = new DepartmentService();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Department> getAllDepartments() {
    return service.getAllDepartments();
  }
}
