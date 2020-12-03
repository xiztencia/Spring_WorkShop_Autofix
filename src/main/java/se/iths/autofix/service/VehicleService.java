package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.User;
import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.repository.UserRepository;
import se.iths.autofix.repository.VehicleRepository;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {

//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        Optional<Vehicle> foundVehicle = vehicleRepository.findById(id);
        vehicleRepository.deleteById(foundVehicle.get().getId());
    }

    public Optional<Vehicle> findVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Iterable<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        return vehicleRepository.findVehicleByNumberPlate(plateNumber);
    }
}
