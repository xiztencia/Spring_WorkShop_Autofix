package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.repository.MaintenanceRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MaintenanceService {


    private MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
        //this.userService = userService;
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        //item.setUser(userService.getAuthenticatedClient());
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

    public void addJobHistoryEvent(Employee employee, String message, Long id) throws Exception {
        Optional<Maintenance> servicejob = maintenanceRepository.findById(id);

        if (!servicejob.isPresent())
            throw new Exception();

        String jobHistory = servicejob.get().getJobHistory();
        jobHistory = jobHistory + "\n "+ LocalDate.now()+" : "+employee.getUsername()+" "+message;
        servicejob.get().setJobHistory(jobHistory);
        maintenanceRepository.save(servicejob.get());
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

