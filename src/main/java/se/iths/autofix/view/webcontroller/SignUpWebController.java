package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.autofix.entity.Client;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.service.ClientService;

@Controller
public class SignUpWebController {
    @Autowired
    ClientService clientService;

    @GetMapping("/createClient")
    public String createClient(Client client) throws BadInputFormatException {
        clientService.createClient(client);
        return"redirect:/login";
    }

    @GetMapping("/signUp")
    public String readClient(Model model){
        model.addAttribute("readClient",new Client());
        return "signUp.html";
    }
}
