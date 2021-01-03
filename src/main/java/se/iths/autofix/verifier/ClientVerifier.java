package se.iths.autofix.verifier;

import se.iths.autofix.entity.Client;
import se.iths.autofix.exception.BadInputFormatException;

public class ClientVerifier {

    public BadInputFormatException badformatInput() throws BadInputFormatException {
        throw new BadInputFormatException("JSON object with client's information must include fields:\n {\n \"username\":\"value\" \n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\" \n\"password\":\"value\"\n}\n");
    }
    public void verifyClient(Client client) throws BadInputFormatException {
        if (client.getUsername() == null || client.getEmail() == null || client.getFirstname() == null || client.getLastname() == null|| client.getPassword() == null)
            badformatInput();
    }
}
