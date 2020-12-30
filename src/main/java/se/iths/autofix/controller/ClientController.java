package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Client;
import se.iths.autofix.service.ClientService;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path={"/client","/api/client"})
public class ClientController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/create")
    public Client createClient(@RequestBody Client client) {
        logger.info("createClient() was called with username: " + client.getUsername());
        return clientService.createClient(client);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @GetMapping("/findall")
    public Iterable<Client> findAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/id/{id}")
    public Optional<Client> findClientById(@PathVariable Long id) {
        return clientService.findClientById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/getauthenticatedclient")
    public Client getAuthenticatedClient() {
        return clientService.getAuthenticatedClient();
    }

}
