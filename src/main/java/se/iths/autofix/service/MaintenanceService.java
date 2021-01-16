package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.EmployeeNotFoundException;
import se.iths.autofix.exception.MaintenanceNotFoundException;
import se.iths.autofix.repository.MaintenanceRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
     }

    public Maintenance createMaintenance(Maintenance maintenance) {
        if(maintenance.getPrice()>0){
        return maintenanceRepository.save(maintenance);
        }else{
            throw new BadInputFormatException("Price can not be of negative value.");
        }
    }

    public Maintenance updateMaintenance(Maintenance newMaintenance, Long id){
        if(newMaintenance.getPrice()>0) {
            return maintenanceRepository.findById(id)
                    .map(maintenance -> {
                        maintenance.setType(newMaintenance.getType());
                        maintenance.setPrice(newMaintenance.getPrice());
                        maintenance.setCheckInDate(newMaintenance.getCheckInDate());
                        maintenance.setCheckOutDate(newMaintenance.getCheckOutDate());
                        return maintenanceRepository.save(maintenance);
                    })
                    .orElseThrow(() -> new MaintenanceNotFoundException("Maintenance has not been found.")
                    );
        }else {
            throw new BadInputFormatException("Price can not be of negative value.");
        }
    }

    public void deleteMaintenance(Long id) {
        Optional<Maintenance> foundMaintenance = maintenanceRepository.findById(id);
        maintenanceRepository.deleteById(foundMaintenance.get().getId());
    }

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
        jobHistory = jobHistory + "\n " + LocalDate.now() + " : " + employee.getUsername() + " " + message;
        servicejob.get().setJobHistory(jobHistory);
        maintenanceRepository.save(servicejob.get());
    }

    public Iterable<Maintenance> findAllMaintenancesByClientId(Long id) {
        return maintenanceRepository.findAllMaintenancesByClientId(id);
    }

    public Iterable<Maintenance> findAllMaintenancesByClientUsername() {
        Iterable<Maintenance> allMaintenancesByClientUsername = maintenanceRepository.findAllMaintenancesByClientUsername();
        return allMaintenancesByClientUsername;
    }
}

