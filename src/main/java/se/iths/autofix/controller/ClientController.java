package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
        try {
            return clientService.createClient(client);
        } catch (BadInputFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input is incorrect", e);
        }
    }
   // @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")


    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @GetMapping("/findall")
    public Iterable<Client> findAllClients() {
        try {
            return clientService.findAllClients();
        } catch (ClientNotFoundException e){
            throw new ClientNotFoundException();
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found", e);
        }
    }

    @GetMapping("/id/{id}")
    //public Optional<Client> findClientById(@PathVariable Long id) {
    public ResponseEntity<?> findClientById(@PathVariable Long id){
        if(id<0){
            throw new BadInputFormatException("Incorrect input");
        }
        return ResponseEntity.ok(clientService.findClientById(id));
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
