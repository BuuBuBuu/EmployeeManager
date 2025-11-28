package controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.entity.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeController {

  EmployeeService employeeService = new EmployeeService();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employee> getEmployeesByDept(
      @PathParam("deptNo") String deptNo,
      @QueryParam("page") @DefaultValue("1") int page
  ) {
    return employeeService.getEmployeesByDepartment(deptNo, page);
  }
}
