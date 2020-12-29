package se.iths.autofix.rest.verifiers;

import se.iths.autofix.entity.Client;
import se.iths.autofix.rest.exceptions.BadFormatInputException;
import se.iths.autofix.rest.exceptions.ClientNotFoundException;
import se.iths.autofix.service.ClientService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ClientVerifier {
    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("JSON object with client's information must include fields:\n {\n \"username\":\"value\" \n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n}\n");
    }

    public void verifyClient(Client client) {
        if (client.getUsername() == null || client.getEmail() == null || client.getFirstname() == null || client.getLastname() == null)
            badformatInput();
    }

    public List<Client> list_clientsCheck(List<Client> clientlist, String message) {
        List<Client> clientList = clientlist;
        if (clientList.size() > 0)
            return clientList;
        else
            throw new ClientNotFoundException(message);
    }

    public Response ClientExist(Client foundclient, ClientService clientService) {
        if (!(foundclient == null)) {
            long removed = foundclient.getId();
            clientService.deleteClient(foundclient.getId());
            return Response.ok().entity("Client with ID " + removed + " removed from registry").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new ClientNotFoundException("Client attempting to delete is not registered");
        }

    }

    public Client ClientExist(Client foundclient, Long id) {
        if (foundclient != null) {
            return foundclient;
        } else {
            throw new ClientNotFoundException("Not client found with id " + id);
        }
    }
}
