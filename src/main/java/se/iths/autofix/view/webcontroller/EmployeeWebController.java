package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Client;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.exception.EmployeeNotFoundException;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.service.ClientService;
import se.iths.autofix.service.EmployeeService;

@Controller
public class EmployeeWebController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/Employee")
    public String users(Model model) throws ClientNotFoundException {
        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "Employee.html";
    }
    @GetMapping("/saveAdmin")
    public String saveAdmin(Employee employee) throws BadInputFormatException {
        employeeService.createEmployee(employee);
        return "redirect:/createAdmin";
    }
    @GetMapping("/createAdmin")
    public String readAdmin(Model model){
        model.addAttribute("adminObj",new Employee());
        return "createAdmin.html";
    }
//    @GetMapping("/Employee")
//    public String employees(Model model) throws EmployeeNotFoundException {
//
//        return "Employee.html";
//    }
}
