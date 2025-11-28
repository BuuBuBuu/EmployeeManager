package controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.dto.EmployeeDTO;
import model.entity.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeController {

  EmployeeService employeeService = new EmployeeService();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<EmployeeDTO> getEmployeesByDept(
      @PathParam("deptNo") String deptNo,
      @QueryParam("page") @DefaultValue("1") int page
  ) {
    return employeeService.getEmployeesByDepartment(deptNo, page);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Employee getEmployeeById(
      @PathParam("empNo") int empNo
  ) {
    return employeeService.findEmployeeById(empNo);
  }
}
