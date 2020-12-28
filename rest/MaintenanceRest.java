package se.iths.autofix.rest;

import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.rest.verifiers.MaintenanceVerifier;
import se.iths.autofix.service.MaintenanceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("maintenance")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MaintenanceRest {

    @Inject
    MaintenanceService maintenanceService;
    @Inject
    MaintenanceVerifier verifier;

    @Path("new")
    @POST
    public Response createMaintenance(Maintenance maintenance) {
        verifier.verifyMaintenance(maintenance);
        return Response.ok(maintenanceService.createMaintenance(maintenance)).build();
    }

//    @Path("getall")
//    @GET
//    public List<Maintenance> getallMaintenances() {
//        return verifier.list_maintenancesCheck(maintenanceService.findAllMaintenances(),"No maintenances registered");
//    }

//    @Path("update")
//    @PUT
//    public Response updateMaintenance(Maintenance maintenance) {
//        verifier.verifyMaintenance(maintenance);
//        return Response.ok(maintenanceService.updateTodo(maintenance)).build();
//    }

//    @Path("searchById/{id}")
//    @GET
//    public Maintenance getMaintenance(@PathParam("id") Long id) {
//        return verifier.MaintenanceExist(maintenanceService.findMaintenanceById(id),id);
//    }

//    @Path("getMaintenancesByMaintenanceNumberPlate/{numberPlate}")
//    @GET
//    public Set<Client> getClientsPerMaintenance(@PathParam("numberPlate") String numberPlate){
//        try{
//            return maintenanceService.findClientsByMaintenance(numberPlate);}
//        catch(NoResultException e){
//            throw new MaintenanceNotFoundException("Not found matches to given maintenance. Make sure you spell maintenance's number plate right and that maintenance is registered");
//        }
//    }
//
//    @Path("deleteById/{id}")
//    @DELETE
//    public Response deleteMaintenance(@PathParam("id") Long id) {
//        return verifier.MaintenanceExist(maintenanceService.findMaintenanceById(id), maintenanceService);
//    }

}
