package se.iths.autofix.rest;

import se.iths.autofix.entity.Employee;
import se.iths.autofix.rest.verifiers.EmployeeVerifier;
import se.iths.autofix.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {

    @Inject
    EmployeeService employeeService;
    @Inject
    EmployeeVerifier verifier;

    @Path("new")
    @POST
    public Response createEmployee(Employee employee) {
        verifier.verifyEmployee(employee);
        return Response.ok(employeeService.createEmployee(employee)).build();
    }

//    @Path("update")
//    @PUT
//    public Response updateEmployee(Employee employee) {
//        verifier.verifyEmployee(employee);
//        return Response.ok(employeeService.update(employee)).build();
//    }

//    @Path("searchById/{id}")
//    @GET
//    public Employee getEmployee(@PathParam("id") Long id) {
//        return verifier.EmployeeExist(employeeService.findEmployeeById(id), id);
//    }

//    @Path("searchByUserName/{username}")
//    @GET
//    public List<Employee> getEmployeeByUserName(@PathParam("username") String username) {
//        return verifier.list_employeesCheck(employeeService.getEmployeeByUsername(username), "No employee registered with username " + username);
//    }

//    @Path("getall")
//    @GET
//    public List<Employee> getAllEmployees() {
//        return verifier.list_employeesCheck(employeeService.findAllEmployees(), "No employees registered");
//    }

//    @Path("deleteById/{id}")
//    @DELETE
//    public Response deleteEmployee(@PathParam("id") Long id) {
//        return verifier.EmployeeExist(employeeService.findEmployeeById(id), employeeService);
//    }


}
