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

  //////////////// FOR TESTING OF TOMCAT SERVER ONLY
  // "/EmployeeManager/service/employees/ping"
  // rmb to put "/EmployeeManager/service/employee/"[blahblah] in front
  @GET
  @Path("/ping")
  public Response ping() {
    return Response.ok().entity("EmployeeManager service online :)))))").build();
  }
  //////////////// END TESTING

  EmployeeService employeeService = new EmployeeService();

  // endpoint 3
  // EXAMPLE: GET /department/d005
  // EXAMPLE: GET /department/d005?page=2
  // okay i understand why need serializer now hahaha
  @GET
  @Path("/department/{deptNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<EmployeeDTO> getEmployeesByDept(
      @PathParam("deptNo") String deptNo,
      @QueryParam("page") @DefaultValue("1") int page
  ) {
    return employeeService.getEmployeesByDepartment(deptNo, page);
  }

  // endpoint 2
  // EXAMPLE: GET /10001
  @GET
  @Path("/{empNo}")
  @Produces(MediaType.APPLICATION_JSON)
  public Employee getEmployeeById(
      @PathParam("empNo") int empNo
  ) {
    return employeeService.findEmployeeById(empNo);
  }

  // endpoint 4
  // EXAMPLE: POST /employees/promote
  @POST
  @Path("promote") // path is wrong for now
  @Consumes(MediaType.APPLICATION_JSON)
  public Response promoteEmployee(
          PromotionDTO promotionDTO
  ) {
    return employeeService.promoteEmployeeById(promotionDTO);


  }
}
