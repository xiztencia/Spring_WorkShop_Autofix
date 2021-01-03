package se.iths.autofix.rest.verifiers;

import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.rest.exceptions.BadFormatInputException;
import se.iths.autofix.rest.exceptions.MaintenanceNotFoundException;
import se.iths.autofix.service.MaintenanceService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MaintenanceVerifier {

    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with maintenance's information must include fields:\n {\n \"type\":\"value\" \n \"price\":\"value\" \n  \"checkInDate\":\"value\"\n  \"checkOutDate\":\"value\"\n}\n");
    }

    public void verifyMaintenance(Maintenance maintenance) {
        if (maintenance.getType() == null || maintenance.getPrice() == 0 || maintenance.getCheckInDate() == null || maintenance.getCheckOutDate() == null)
            badformatInput();
    }

    public List<Maintenance> list_maintenancesCheck(List<Maintenance> maintenancelist, String message) {
        List<Maintenance> maintenanceList = maintenancelist;
        if (maintenanceList.size() > 0)
            return maintenanceList;
        else
            throw new MaintenanceNotFoundException(message);
    }

    public Response MaintenanceExist(Maintenance foundmaintenance, MaintenanceService maintenanceService) {
        if (!(foundmaintenance == null)) {
            long removed = foundmaintenance.getId();
            maintenanceService.deleteMaintenance(foundmaintenance.getId());
            return Response.ok().entity("Maintenance with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new MaintenanceNotFoundException("Maintenance attempting to delete is not registered");
        }

    }

    public Maintenance MaintenanceExist(Maintenance foundmaintenance, Long id) {
        if (foundmaintenance != null) {
            return foundmaintenance;
        } else {
            throw new MaintenanceNotFoundException("Not maintenance found with id " + id);
        }
    }
}
