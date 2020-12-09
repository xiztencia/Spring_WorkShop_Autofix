package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Client;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    private ClientRepository clientRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public ClientService(ClientRepository clientRepository, TestScopes testScopes) {
        this.clientRepository = clientRepository;
    }

    // Setter injection
//    @Autowired
//    void setClientRepository(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }


    public Client createClient(Client client) {

        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Optional<Client> foundClient = clientRepository.findById(id);
        clientRepository.deleteById(foundClient.get().getId());
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAllClients() {
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
