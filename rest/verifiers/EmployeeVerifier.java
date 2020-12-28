package se.iths.autofix.rest.verifiers;

import se.iths.autofix.entity.Employee;
import se.iths.autofix.rest.exceptions.BadFormatInputException;
import se.iths.autofix.rest.exceptions.EmployeeNotFoundException;
import se.iths.autofix.service.EmployeeService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class EmployeeVerifier {
    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with employee's information must include fields:\n {\n \"username\":\"value\" \n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n}\n");
    }

    public void verifyEmployee(Employee employee) {
        if (employee.getUsername() == null || employee.getEmail() == null || employee.getFirstname() == null || employee.getLastname() == null)
            badformatInput();
    }

    public List<Employee> list_employeesCheck(List<Employee> employeelist, String message) {
        List<Employee> employeeList = employeelist;
        if (employeeList.size() > 0)
            return employeeList;
        else
            throw new EmployeeNotFoundException(message);
    }

    public Response EmployeeExist(Employee foundemployee, EmployeeService employeeService) {
        if (!(foundemployee == null)) {
            long removed = foundemployee.getId();
            employeeService.deleteEmployee(foundemployee.getId());
            return Response.ok().entity("Employee with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new EmployeeNotFoundException("Employee attempting to delete is not registered");
        }

    }

    public Employee EmployeeExist(Employee foundemployee, Long id) {
        if (foundemployee != null) {
            return foundemployee;
        } else {
            throw new EmployeeNotFoundException("Not employee found with id " + id);
        }
    }
}
