package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.jms.sender.Sender;
import se.iths.autofix.repository.MaintenanceRepository;
import se.iths.autofix.service.ClientService;
import se.iths.autofix.service.EmployeeService;
import se.iths.autofix.service.MaintenanceService;
import se.iths.autofix.service.SparePartService;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class EmployeeWebController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

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
    @GetMapping("/Maintenance")
    public String allMaintenance(Model model){
        model.addAttribute("allMaintenances", maintenanceService.findAllMaintenances());
        return "Maintenance.html";
    }
    @GetMapping("/editMaintenance/{id}")
    public String readMaintenance(@PathVariable("id") Long id, Model model){
        Maintenance maintenance = maintenanceService.findMaintenanceById(id).get();
        model.addAttribute("maintenance", maintenance);
        return "/editMaintenance";
    }
    @PostMapping("/saveMaintanence/{id}")
    public String editMaintenance(
//                                  @RequestParam(value = "price", required = false)double price,
//                                  @RequestParam(value = "checkInDate", required = false)Date checkInDate,
//                                  @RequestParam(value = "checkOutDate", required = false)Date checkOutDate,
//                                  @RequestParam(value = "jobHistory")String jobHistory,
        @PathVariable("id") Long id, @Valid Maintenance maintenance, BindingResult result, Model model) throws Exception {
  //      Maintenance newMaintence = (Maintenance) model.getAttribute("maintenance");
       // model.addAttribute("maintenance", maintenanceService.findMaintenanceById(id));
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
                // model.addAttribute("id", id);
//                 maintenanceService.findMaintenanceById(id).get().setPrice(price);
//                 maintenanceServicem.findMaintenanceById(id).get().setCheckInDate(checkInDate);
//                 maintenanceService.findMaintenanceById(id).get().setCheckOutDate(checkOutDate);
//                 maintenanceService.addJobHistoryEvent(employeeService.getEmployeeByName(currentPrincipalName),jobHistory,id);
             //   Maintenance maintenance = maintenanceService.findMaintenanceById(id).get();
       if(result.hasErrors()){
           maintenance.setId(id);
           return "editMaintenance";}
       // maintenanceService.updateMaintenance(maintenance,maintenance.getId());
        maintenanceRepository.save(maintenance);
      // model.addAttribute("updatedMaintenances", maintenanceService.findAllMaintenances());
      //  maintenanceService.updateMaintenance(maintenance, maintenance.getId());
        return "redirect:/Maintenance";
        }
//    @PostMapping("/updateMaintenance")
//    public String updateMaintenance(Maintenance maintenance){
//        maintenanceRepository.save(maintenance);
//        return "Maintenance";
//    }


    }

//    @GetMapping("/Employee")
//    public String employees(Model model) throws EmployeeNotFoundException {
//
//        return "Employee.html";
//    }

