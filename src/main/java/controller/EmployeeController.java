package controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.dto.EmployeeDTO;
import model.dto.PromotionDTO;
import model.entity.Employee;
import service.EmployeeService;

import java.util.List;

/**
 * Controller for Employee-related endpoints
 * Base URI starts with "/employee"/..
 */
@Path("/employees")
public class EmployeeController {

  /**
   * Employee Service for handling business logic
   */
  EmployeeService employeeService = new EmployeeService();

  ////////////////////// FOR TESTING OF TOMCAT SERVER ONLY //////////////////////
  // " http://localhost:8080/EmployeeManager/service/employees/ping"
  /**
   * Ping endpoint for testing server availability
   * @return Response indicating service is online
   */
  @GET
  @Path("/ping")
  public Response ping() {
    return Response.ok().entity("EmployeeManager service online :)))))").build();
  }
  ///////////////////////////////// END TESTING /////////////////////////////////


  // endpoint 2
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/10001
  /**
   * Get employee by employee number
   * @param empNo   Employee number
   * @return Employee object
   */
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Employee getEmployeeById(
          @QueryParam("empNo") int empNo
  ) {
    return employeeService.findEmployeeById(empNo);
  }

  // endpoint 3
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/department/d005
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/department/d005?page=2
  /**
   * Get employees by department number with pagination
   * @param deptNo Department number
   * @param page   Page number (default is 1)
   * @return List of EmployeeDTO objects
   */
  @GET
  @Path("/department")
  @Produces(MediaType.APPLICATION_JSON)
  public List<EmployeeDTO> getEmployeesByDept(
      @QueryParam("deptNo") String deptNo,
      @QueryParam("page") @DefaultValue("1") int page
  ) {
    return employeeService.getEmployeesByDepartment(deptNo, page);
  }

  // endpoint 4
  /**
   * Promote an employee based on the provided PromotionDTO
   * Takes in format of:
   * {
   *  "empNo": 10001,
   *  "salary": 91000,
   *  "title": "Star Intern"
   *  "deptNo": "d005"
   * }
   * @param promotionDTO promotion details
   * @return Response indicating success or failure of the operation
   */
  @POST
  @Path("/promote")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response promoteEmployee(
          PromotionDTO promotionDTO
  ) {
    return employeeService.promoteEmployeeById(promotionDTO);
  }
}
