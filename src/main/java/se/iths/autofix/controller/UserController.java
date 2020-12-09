package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Client;
import se.iths.autofix.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Client createUser(@RequestBody Client client) {
//           logger.trace("Vi loggar på TRACE-nivå");
//           logger.debug("Vi loggar på DEBUG-nivå");
           logger.info("createUser() was called with username: " + client.getUsername());
//           logger.warn("Vi loggar på WARN-nivå");
//           logger.error("Vi loggar på ERROR-nivå");
           return userService.createUser(client);
    }

    @GetMapping("/findall")
    public Iterable<Client> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/id/{id}")
    public Optional<Client> findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getauthenticateduser")
    public Client getAuthenticatedUser() {
        return userService.getAuthenticatedUser();
    }

}
