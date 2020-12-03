package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.User;
import se.iths.autofix.service.UserService;
import se.iths.autofix.service.VehicleService;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //REFORMATERA:
//
//    @PostMapping("/create")
//    public User createUser(@RequestBody User user) {
////           logger.trace("Vi loggar på TRACE-nivå");
////           logger.debug("Vi loggar på DEBUG-nivå");
//        logger.info("createUser() was called with username: " + user.getUsername());
////           logger.warn("Vi loggar på WARN-nivå");
////           logger.error("Vi loggar på ERROR-nivå");
//        return userService.createUser(user);
//    }
//
//    @GetMapping("/findall")
//    public Iterable<User> findAllUsers() {
//        return userService.findAllUsers();
//    }
//
//    @GetMapping("/id/{id}")
//    public Optional<User> findUserById(@PathVariable Long id) {
//        return userService.findUserById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }

}
