package se.iths.autofix.controller;

import org.springframework.web.bind.annotation.*;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.service.MaintenanceService;


import java.util.Optional;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService){this.maintenanceService= maintenanceService; }

    @PostMapping("/create")
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.createMaintenance(maintenance);
    }

    @GetMapping("/findall")
    public Iterable<Maintenance> findAllMaintenances(){
        return maintenanceService.findAllMaintenances();
    }

    @GetMapping("/id{id}")
    public Optional<Maintenance> findMaintenanceById(@PathVariable Long id){
        return maintenanceService.findMaintenanceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMaintenance(@PathVariable Long id){
        maintenanceService.deleteMaintenance(id);
    }

    @GetMapping("/findbyclient/{id}")
    public Iterable<Maintenance> getAllMaintenancesByClient(@PathVariable Long id){
        return maintenanceService.findAllMaintenancesByClientId(id);
    }

    @GetMapping("/findallmaintenancessbyclientusername")
    Iterable<Maintenance> findAllMaintenancesByClientUsername() {
        return maintenanceService.findAllMaintenancesByClientUsername();
    }

    @GetMapping("/findallmaintenancesbyemployee/{id}")
    public Iterable<Maintenance> getAllMaintenancesByEmployee(@PathVariable Long id) {
        return maintenanceService.findAllMaintenancesByEmployeeId(id);
    }

    @GetMapping("/findallmaintenancesbyemployeeusername")
    Iterable<Maintenance> findAllMaintenancesByEmployeeUsername() {
        return maintenanceService.findAllMaintenancesByEmployeeUsername();
    }



}
