package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.repository.MaintenanceRepository;

import java.util.Optional;

@Service
public class MaintenanceService {


    private MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
        //this.userService = userService;
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        //item.setUser(userService.getAuthenticatedUser());
        return maintenanceRepository.save(maintenance);
    }

//    public void deleteMaintenance(Long id) {
//        Optional<Maintenance> foundMaintenance = maintenanceRepository.findById(id);
//        maintenanceRepository.deleteById(foundMaintenance.get().getId());
//    }

    public Optional<Maintenance> findMaintenanceById(Long id) {
        return maintenanceRepository.findById(id);
    }

    public Iterable<Maintenance> findAllMaintenances() {
        return maintenanceRepository.findAll();
    }

//    public Iterable<Maintenance> findMaintenancesByUserId(Long id) {
//        return maintenanceRepository.findMaintenancesByUserId(id);
//    }
//
//    public Iterable<Maintenance> findAllByUser() {
//        Iterable<Item> allMaintenancesByUser = maintenanceRepository.findAllByUser();
//        return allMaintenancesByUser;
//    }
}

