package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
//           logger.trace("Vi loggar på TRACE-nivå");
//           logger.debug("Vi loggar på DEBUG-nivå");
        logger.info("createEmployee() was called with name: " + employee.getUsername());
//           logger.warn("Vi loggar på WARN-nivå");
//           logger.error("Vi loggar på ERROR-nivå");
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/findall")
    public Iterable<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

//    @GetMapping("/getauthenticatedemployee")
//    public Employee getAuthenticatedEmployee() {
//        return employeeService.getAuthenticatedEmployee();
//    }
}
