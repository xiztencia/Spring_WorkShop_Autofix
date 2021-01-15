package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.jms.sender.Sender;
import se.iths.autofix.service.EmployeeService;

@RestController
@PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
@RequestMapping(path={"/api/employee"})
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;
    private Sender sender;

    public EmployeeController(EmployeeService employeeService,Sender sender) {
        this.employeeService = employeeService;
        this.sender=sender;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("createEmployee() was called with name: " + employee.getUsername());
        if(employee.getUsername()!=null) {
            return employeeService.createEmployee(employee);
        }else{
            throw new BadInputFormatException("Fill in User name.");
        }
        }

    @GetMapping("/findall")
    public Iterable<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")

    public ResponseEntity<?> findEmployeeById(@PathVariable Long id) {
        if(id<=0){
            throw new BadInputFormatException("Incorrect input");
        }
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getauthenticatedemployee")
    public Employee getAuthenticatedEmployee() {
        return employeeService.getAuthenticatedEmployee();
    }
}
