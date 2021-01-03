package se.iths.autofix.rest;

import javax.inject.Inject;
import se.iths.autofix.entity.Client;
import se.iths.autofix.rest.verifiers.ClientVerifier;
import se.iths.autofix.service.ClientService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("client")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientRest {

    @Inject
    ClientService clientService;
    @Inject
    ClientVerifier verifier;

    @Path("new")
    @POST
    public Response createClient(Client client) {
        verifier.verifyClient(client);
        return Response.ok(clientService.createClient(client)).build();
    }

//    @Path("update")
//    @PUT
//    public Response updateClient(Client client) {
//        verifier.verifyClient(client);
//        return Response.ok(clientService.update(client)).build();
//    }

//    @Path("searchById/{id}")
//    @GET
//    public Client getClient(@PathParam("id") Long id) {
//        return verifier.ClientExist(clientService.findClientById(id), id);
//    }

//    @Path("getClientAndSubject/{firstname}")
//    @GET
//    public List<Client> getClientAndSubject(@PathParam("firstname") String firstname){
//        return clientService.findNameAndSubject(firstname);
//    }

//    @Path("searchByUserName/{username}")
//    @GET
//    public List<Client> getClientByUserName(@PathParam("username") String username) {
//        return verifier.list_clientsCheck(clientService.getClientByUsername(username), "No client registered with username " + username);
//    }

//    @Path("getall")
//    @GET
//    public List<Client> getAllClients() {
//        return verifier.list_clientsCheck(clientService.findAllClients(), "No clients registered");
//    }

//    @Path("deleteById/{id}")
//    @DELETE
//    public Response deleteClient(@PathParam("id") Long id) {
//        return verifier.ClientExist(clientService.findClientById(id), clientService);
//    }


}
