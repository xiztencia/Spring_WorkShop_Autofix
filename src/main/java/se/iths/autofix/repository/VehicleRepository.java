package se.iths.autofix.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.autofix.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Vehicle findVehicleByNumberPlate (String numberPlate);
}
