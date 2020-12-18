package se.iths.autofix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.service.VehicleService;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
//           logger.trace("Vi loggar på TRACE-nivå");
//           logger.debug("Vi loggar på DEBUG-nivå");
        logger.info("createVehicle() was called with number plate: " + vehicle.getNumberPlate());
//           logger.warn("Vi loggar på WARN-nivå");
//           logger.error("Vi loggar på ERROR-nivå");
        return vehicleService.createVehicle(vehicle);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/findall")
    public Iterable<Vehicle> findAllVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping("/id/{id}")
    public Optional<Vehicle> findVehicleById(@PathVariable Long id) {
        return vehicleService.findVehicleById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
