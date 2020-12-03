package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    private EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Setter injection
//    @Autowired
//    void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public Employee createEmployee(Employee employee) {

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return employeeRepository.save(employee);
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
        return employeeRepository.findByEmployeeName(name);
    }


    public Employee getAuthenticatedEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedEmployeeName = authentication.getName();
        return getEmployeeByName(authenticatedEmployeeName);
    }


}
