package se.iths.autofix.view.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.autofix.jms.sender.Sender;
import se.iths.autofix.service.SparePartService;

@Controller
public class ClientWebController {

    @Autowired
    private SparePartService sparePartService;
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
}
