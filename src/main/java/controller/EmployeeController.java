package controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.dto.EmployeeDTO;
import model.dto.PromotionDTO;
import model.entity.Employee;
import service.EmployeeService;

import java.util.List;

@Path("/employees")
public class EmployeeController {

  EmployeeService employeeService = new EmployeeService();

  ////////////////////// FOR TESTING OF TOMCAT SERVER ONLY //////////////////////
  // " http://localhost:8080/EmployeeManager/service/employees/ping"
  @GET
  @Path("/ping")
  public Response ping() {
    return Response.ok().entity("EmployeeManager service online :)))))").build();
  }
  ///////////////////////////////// END TESTING /////////////////////////////////


  // endpoint 2
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/10001
  @GET
  @Path("/{empNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public Employee getEmployeeById(
          @PathParam("empNo") int empNo
  ) {
    return employeeService.findEmployeeById(empNo);
  }

  // endpoint 3
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/department/d005
  // EXAMPLE: http://localhost:8080/EmployeeManager/service/employees/department/d005?page=2
  @GET
  @Path("/department/{deptNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<EmployeeDTO> getEmployeesByDept(
      @PathParam("deptNo") String deptNo,
      @QueryParam("page") @DefaultValue("1") int page
  ) {
    return employeeService.getEmployeesByDepartment(deptNo, page);
  }

  // endpoint 4
  /* SAMPLE JSON (all fields needs to be filled in, even if there are no change):
   * {
   *  "empNo": 10001,
   *  "salary": 91000,
   *  "title": "Star Intern"
   *  "deptNo": "d005"
   * }
   *  note that from date is defaulted to current date
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
