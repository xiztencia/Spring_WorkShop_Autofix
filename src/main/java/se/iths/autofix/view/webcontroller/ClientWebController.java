package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.jms.sender.Sender;
import se.iths.autofix.service.ClientService;
import se.iths.autofix.service.MaintenanceService;
import se.iths.autofix.service.SparePartService;

import java.util.Date;

@Controller
public class ClientWebController {

    @Autowired
    private SparePartService sparePartService;

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Sender jmsSender;

    @GetMapping("/Client")
    public String spareParts(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        jmsSender.sendMessage(currentPrincipalName+" Logged in",currentPrincipalName+" Logged in");
        model.addAttribute("spareParts", sparePartService.findAllSpareParts());
        return "Client.html";
    }
    @GetMapping("/MaintenanceRequest")
    public String readMaintenance(Model model){
        model.addAttribute("maintenanceObj", new Maintenance());
        model.addAttribute("clientMaintenance", maintenanceService.findAllMaintenancesByClientUsername());
        return "MaintenanceRequest";
    }
    @GetMapping("/createMaintenanceAsClient")
    public String saveMaintenance (Maintenance maintenance){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        maintenance.setPrice(0);
        maintenance.setCheckInDate(new Date());
        maintenance.setCheckOutDate(new Date());
        maintenance.setJobHistory("/"+ new Date()+ "Order Placed by "+currentPrincipalName+" /.\n");
        maintenance.setClient(clientService.getClientByUsername(currentPrincipalName));
        maintenanceService.createMaintenance(maintenance);
        return "redirect:/MaintenanceRequest";
    }
    @GetMapping("/MaintenanceDetailsClient/{id}")
    public String maintenanceDetails(@PathVariable("id") Long id, Model model){
        Maintenance maintenance = maintenanceService.findMaintenanceById(id).get();
        model.addAttribute("detailsClientMain", maintenance);
        return "MaintenanceDetailsClient.html";
    }

}
