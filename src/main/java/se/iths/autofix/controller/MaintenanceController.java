package se.iths.autofix.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.service.MaintenanceService;
import sun.security.tools.keytool.Main;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService){this.maintenanceService= maintenanceService; }

    @PostMapping("/create")
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.createMaintenance(maintenance);
    }


}
