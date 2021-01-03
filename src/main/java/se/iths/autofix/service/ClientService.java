package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Client;
import se.iths.autofix.exception.BadInputFormatException;
import se.iths.autofix.exception.ClientNotFoundException;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.ClientRepository;
import se.iths.autofix.verifier.ClientVerifier;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    private ClientRepository clientRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private ClientVerifier verifier;

    // Constructor injection
    public ClientService(ClientRepository clientRepository, TestScopes testScopes) {
        this.clientRepository = clientRepository;
    }

    // Setter injection
//    @Autowired
//    void setClientRepository(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }


    public Client createClient(Client client) throws BadInputFormatException{

           //verifier.verifyClient(client);

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        authGroupRepository.save(new AuthGroup(client.getUsername(), "USER"));
        return clientRepository.save(client);
    }

//    public Client update(Client client){
//
//    }

    public void deleteClient(Long id) {
        Optional<Client> foundClient = clientRepository.findById(id);
        clientRepository.deleteById(foundClient.get().getId());
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAllClients() throws ClientNotFoundException{
        return clientRepository.findAll();
    }

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }


    public Client getAuthenticatedClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUsername = authentication.getName();
        return getClientByUsername(authenticatedUsername);
    }

}
