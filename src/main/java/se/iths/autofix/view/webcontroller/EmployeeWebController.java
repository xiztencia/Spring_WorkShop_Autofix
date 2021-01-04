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
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.service.ClientService;

@Controller
public class EmployeeWebController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthGroupRepository authGroupRepository;

    @GetMapping("/Employee")
    public String clients(Model model) throws ClientNotFoundException {
        model.addAttribute("clients", clientService.findAllClients());
        return "Employee.html";
    }

    @GetMapping("/saveUser")
    public String saveClient(Client client) throws BadInputFormatException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.createClient(client);
        authGroupRepository.save(new AuthGroup(client.getUsername(), "USER"));

        return "redirect:/createUser";
    }
    @GetMapping("/createUser")
    public String readClient(Model model){
        model.addAttribute("clientObj",new Client());
        return "createUser.html";
    }
}
