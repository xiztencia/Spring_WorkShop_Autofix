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

    public void deleteUser(Long id) {
        Optional<Client> foundUser = clientRepository.findById(id);
        clientRepository.deleteById(foundUser.get().getId());
    }

    public Optional<Client> findUserById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAllUsers() {
        return clientRepository.findAll();
    }

    public Client getUserByUsername(String username) {
        return clientRepository.findByUsername(username);
    }


    public Client getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUsername = authentication.getName();
        return getUserByUsername(authenticatedUsername);
    }

}
