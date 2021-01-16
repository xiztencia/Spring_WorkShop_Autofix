package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import se.iths.autofix.jms.sender.Sender;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.service.ClientService;
import se.iths.autofix.service.EmployeeService;
import se.iths.autofix.service.SparePartService;
import se.iths.autofix.entity.SparePart;

@Controller
public class EmployeeWebController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SparePartService sparePartService;

    @Autowired
    private Sender jmsSender;


    @GetMapping("/Employee")
    public String users(Model model) throws ClientNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        jmsSender.sendMessage(currentPrincipalName+" Logged in",currentPrincipalName+" Logged in");

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
        return "CreateAdmin.html";
    }
    @GetMapping("/createSparePart")
    public String readSparePart(Model model){
        model.addAttribute("sparePartObj", new SparePart());
        model.addAttribute("spareParts",sparePartService.findAllSpareParts());
        return "CreateSparePart.html";
    }
    @GetMapping("/saveSparePart")
    public String saveSparePart(SparePart sparePart) throws BadInputFormatException{
        sparePartService.createSparePart(sparePart);
        return "redirect:/createSparePart";
    }

//    @GetMapping("/Employee")
//    public String employees(Model model) throws EmployeeNotFoundException {
//
//        return "Employee.html";
//    }
}
