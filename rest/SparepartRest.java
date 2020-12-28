package se.iths.autofix.rest;

import se.iths.autofix.entity.SparePart;
import se.iths.autofix.rest.verifiers.SparepartVerifier;
import se.iths.autofix.service.SparePartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("sparepart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SparepartRest {

    @Inject
    SparePartService sparePartService;
    @Inject
    SparepartVerifier verifier;

    @Path("new")
    @POST
    public Response createSparepart(SparePart sparePart) {
        verifier.verifySparePart(sparePart);
        return Response.ok(sparePartService.createSparePart(sparePart)).build();
    }

//    @Path("getall")
//    @GET
//    public List<SparePart> getallSpareParts() {
//        return verifier.list_sparePartsCheck(sparePartService.findAllSpareParts(),"No spareParts registered");
//    }

//    @Path("update")
//    @PUT
//    public Response updateSparePart(SparePart sparePart) {
//        verifier.verifySparePart(sparePart);
//        return Response.ok(sparePartService.updateTodo(sparePart)).build();
//    }

//    @Path("searchById/{id}")
//    @GET
//    public SparePart getSparePart(@PathParam("id") Long id) {
//        return verifier.SparePartExist(sparePartService.findSparePartById(id),id);
//    }

//    @Path("getStudentsBySparePartName/{name}")
//    @GET
//    public Set<Client> getStudentsPerSparePart(@PathParam("name") String name){
//        try{
//            return sparePartService.findStudentsBySparePart(name);}
//        catch(NoResultException e){
//            throw new StudentNotFoundException("Not found matches to given sparePart. Make sure you spell sparePart's name right and that sparePart is registered");
//        }
//    }
//
//    @Path("deleteById/{id}")
//    @DELETE
//    public Response deleteSparePart(@PathParam("id") Long id) {
//        return verifier.SparePartExist(sparePartService.findSparePartById(id), sparePartService);
//    }

}
