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

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    AuthGroupRepository authGroupRepository;
    @Autowired
    AuthService authService;

    private ClientRepository clientRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Setter injection
//    @Autowired
//    void setClientRepository(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }


    public Client createClient(Client client){
        if(authService.doesUsernameExist(client.getUsername())) {
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            authGroupRepository.save(new AuthGroup(client.getUsername(), "USER"));
            return clientRepository.save(client);
        }else{
            throw new BadInputFormatException("Username is already taken!!");
        }
    }

    public Client updateClient(Client newClient, Long id){
        newClient.setPassword(passwordEncoder.encode(newClient.getPassword()));
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFirstname(newClient.getFirstname());
                    client.setLastname(newClient.getLastname());
                    client.setEmail(newClient.getEmail());
                    client.setPassword(newClient.getPassword());
                    return clientRepository.save(client);
                })
                .orElseThrow(()-> new ClientNotFoundException("Client has not been found.")
                );
    }

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
