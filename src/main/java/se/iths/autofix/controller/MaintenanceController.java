package se.iths.autofix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.MaintenanceNotFoundException;
import se.iths.autofix.service.MaintenanceService;

@RestController
@RequestMapping(path={"/api/maintenance"})
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @PostMapping("/create")
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        if(maintenance.getType().isEmpty()){
            throw new BadInputFormatException("Fill in maintenance type.");
        }
        return maintenanceService.createMaintenance(maintenance);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @PostMapping("/addhistoryevent")
    public void addJobHistoryEvent(@RequestBody Employee employee, String message, Long id) throws Exception {
        maintenanceService.addJobHistoryEvent(employee, message, id);
    }

    @GetMapping("/findall")
    public Iterable<Maintenance> findAllMaintenances() {
        return maintenanceService.findAllMaintenances();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findMaintenanceById(@PathVariable Long id) {
        if(id<=0){
            throw new MaintenanceNotFoundException("The maintenance id was not found.");
        }
        return ResponseEntity.ok(maintenanceService.findMaintenanceById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
    }

    @GetMapping("/findbyclient/{id}")
    public Iterable<Maintenance> getAllMaintenancesByClient(@PathVariable Long id) {
        return maintenanceService.findAllMaintenancesByClientId(id);
    }

    @GetMapping("/findallmaintenancessbyclientusername")
    Iterable<Maintenance> findAllMaintenancesByClientUsername() {
        return maintenanceService.findAllMaintenancesByClientUsername();
    }

//    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
//    @GetMapping("/findallmaintenancesbyemployee/{id}")
//    public Iterable<Maintenance> getAllMaintenancesByEmployee(@PathVariable Long id) {
//        return maintenanceService.findAllMaintenancesByEmployeeId(id);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN') or hasRole('ADMIN')")
//    @GetMapping("/findallmaintenancesbyemployeeusername")
//    Iterable<Maintenance> findAllMaintenancesByEmployeeUsername() {
//        return maintenanceService.findAllMaintenancesByEmployeeUsername();
//    }


}
