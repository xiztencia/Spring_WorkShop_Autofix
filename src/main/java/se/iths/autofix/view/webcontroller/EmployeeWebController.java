package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.autofix.service.ClientService;

@Controller
public class EmployeeWebController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/admin")
    public String clients(Model model){
        model.addAttribute("clients", clientService.findAllClients());
        return "/admin.html";
    }
}
