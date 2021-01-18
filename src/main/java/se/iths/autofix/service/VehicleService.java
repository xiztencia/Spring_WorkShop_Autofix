package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.MaintenanceNotFoundException;
import se.iths.autofix.exception.VehicleNotFoundException;
import se.iths.autofix.repository.VehicleRepository;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) throws BadInputFormatException{

//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Vehicle newVehicle, Long id){
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicle.setNumberPlate(newVehicle.getNumberPlate());
                    vehicle.setMaker(newVehicle.getMaker());
                    vehicle.setModel(newVehicle.getModel());
                    return vehicleRepository.save(vehicle);
                })
                .orElseThrow(()-> new VehicleNotFoundException("Vehicle has not been found.")
                );
    }

    public void deleteVehicle(Long id) {
        Optional<Vehicle> foundVehicle = vehicleRepository.findById(id);
        vehicleRepository.deleteById(foundVehicle.get().getId());
    }

    public Optional<Vehicle> findVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Iterable<Vehicle> findAllVehicles() throws VehicleNotFoundException {
        return vehicleRepository.findAll();
    }


}
