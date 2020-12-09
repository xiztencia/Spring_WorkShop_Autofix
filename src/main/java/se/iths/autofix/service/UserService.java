package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Client;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public UserService(UserRepository userRepository, TestScopes testScopes) {
        this.userRepository = userRepository;
    }

    // Setter injection
//    @Autowired
//    void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public Client createUser(Client client) {

        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return userRepository.save(client);
    }

    public void deleteUser(Long id) {
        Optional<Client> foundUser = userRepository.findById(id);
        userRepository.deleteById(foundUser.get().getId());
    }

    public Optional<Client> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<Client> findAllUsers() {
        return userRepository.findAll();
    }

    public Client getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public Client getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUsername = authentication.getName();
        return getUserByUsername(authenticatedUsername);
    }

}
