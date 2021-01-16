package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Client;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.exception.EmployeeNotFoundException;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    AuthGroupRepository authGroupRepository;
    @Autowired
    AuthService authService;

    private EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Setter injection
//    @Autowired
//    void setClientRepository(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }


    public Employee createEmployee(Employee employee) {
        if(authService.doesUsernameExist(employee.getUsername())) {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            authGroupRepository.save(new AuthGroup(employee.getUsername(), "ADMIN"));
            return employeeRepository.save(employee);
        }else {
            throw new BadInputFormatException("Username is already taken!!");
        }
    }

    public Employee updateEmployee(Employee newEmployee, Long id){
        newEmployee.setPassword(passwordEncoder.encode(newEmployee.getPassword()));
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstname(newEmployee.getFirstname());
                    employee.setLastname(newEmployee.getLastname());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPassword(newEmployee.getPassword());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(()-> new EmployeeNotFoundException("Employee has not been found.")
                );
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        employeeRepository.deleteById(foundEmployee.get().getId());
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByUsername(name);
    }


    public Employee getAuthenticatedEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedEmployeeName = authentication.getName();
        return getEmployeeByName(authenticatedEmployeeName);
    }


}
