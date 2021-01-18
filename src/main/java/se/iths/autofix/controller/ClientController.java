package se.iths.autofix.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Client;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.service.ClientService;
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path={"/api/client"})
public class ClientController {
    Logger logger = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/create")
    public Client createClient(@RequestBody Client client){
        logger.info("createClient() was called with username: " + client.getUsername());

        if(client.getUsername().isEmpty()) {
            throw new BadInputFormatException("Fill in User name.");
        }else{
            return clientService.createClient(client);
        }
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@RequestBody Client newClient, @PathVariable Long id){
        return clientService.updateClient(newClient, id);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @GetMapping("/findall")
    public Iterable<Client> findAllClients() {
            return clientService.findAllClients();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findClientById(@PathVariable Long id){
        if(id<=0){
            throw new ClientNotFoundException("Incorrect input");
        }
        return ResponseEntity.ok(clientService.findClientById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity  deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Deleted Client with id: "+id);
    }

    @GetMapping("/getauthenticatedclient")
    public Client getAuthenticatedClient() {
        return clientService.getAuthenticatedClient();
    }

}
