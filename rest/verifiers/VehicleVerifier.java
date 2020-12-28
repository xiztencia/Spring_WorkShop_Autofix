package se.iths.autofix.rest.verifiers;

import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.rest.exceptions.BadFormatInputException;
import se.iths.autofix.rest.exceptions.VehicleNotFoundException;
import se.iths.autofix.service.VehicleService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class VehicleVerifier {

    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with vehicle's information must include fields:\n {\n \"username\":\"value\" \n \"numberPlate\":\"value\" \n  \"maker\":\"value\"\n  \"model\":\"value\"\n}\n");
    }

    public void verifyVehicle(Vehicle vehicle) {
        if (vehicle.getNumberPlate() == null || vehicle.getMaker() == null || vehicle.getModel() == null)
            badformatInput();
    }

    public List<Vehicle> list_vehiclesCheck(List<Vehicle> vehiclelist, String message) {
        List<Vehicle> vehicleList = vehiclelist;
        if (vehicleList.size() > 0)
            return vehicleList;
        else
            throw new VehicleNotFoundException(message);
    }

    public Response VehicleExist(Vehicle foundvehicle, VehicleService vehicleService) {
        if (!(foundvehicle == null)) {
            long removed = foundvehicle.getId();
            vehicleService.deleteVehicle(foundvehicle.getId());
            return Response.ok().entity("Vehicle with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new VehicleNotFoundException("Vehicle attempting to delete is not registered");
        }

    }

    public Vehicle VehicleExist(Vehicle foundvehicle, Long id) {
        if (foundvehicle != null) {
            return foundvehicle;
        } else {
            throw new VehicleNotFoundException("Not vehicle found with id " + id);
        }
    }
}
