package se.iths.autofix.rest;

import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.rest.verifiers.VehicleVerifier;
import se.iths.autofix.service.VehicleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleRest {

    @Inject
    VehicleService vehicleService;
    @Inject
    VehicleVerifier verifier;

    @Path("new")
    @POST
    public Response createVehicle(Vehicle vehicle) {
        verifier.verifyVehicle(vehicle);
        return Response.ok(vehicleService.createVehicle(vehicle)).build();
    }

//    @Path("getall")
//    @GET
//    public List<Vehicle> getallVehicles() {
//        return verifier.list_vehiclesCheck(vehicleService.findAllVehicles(),"No vehicles registered");
//    }

//    @Path("update")
//    @PUT
//    public Response updateVehicle(Vehicle vehicle) {
//        verifier.verifyVehicle(vehicle);
//        return Response.ok(vehicleService.updateTodo(vehicle)).build();
//    }

//    @Path("searchById/{id}")
//    @GET
//    public Vehicle getVehicle(@PathParam("id") Long id) {
//        return verifier.VehicleExist(vehicleService.findVehicleById(id),id);
//    }

//    @Path("getVehiclesByVehicleNumberPlate/{numberPlate}")
//    @GET
//    public Set<Client> getClientsPerVehicle(@PathParam("numberPlate") String numberPlate){
//        try{
//            return vehicleService.findClientsByVehicle(numberPlate);}
//        catch(NoResultException e){
//            throw new VehicleNotFoundException("Not found matches to given vehicle. Make sure you spell vehicle's number plate right and that vehicle is registered");
//        }
//    }
//
//    @Path("deleteById/{id}")
//    @DELETE
//    public Response deleteVehicle(@PathParam("id") Long id) {
//        return verifier.VehicleExist(vehicleService.findVehicleById(id), vehicleService);
//    }

}
