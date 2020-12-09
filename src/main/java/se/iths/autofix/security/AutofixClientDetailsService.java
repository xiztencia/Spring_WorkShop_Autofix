package se.iths.autofix.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Client;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.EmployeeRepository;
import se.iths.autofix.repository.ClientRepository;

import java.util.List;

@Service
public class AutofixClientDetailsService implements UserDetailsService {
//AutofixUserDetailsService
    private ClientRepository clientRepository;
    private AuthGroupRepository authGroupRepository;

    public AutofixClientDetailsService(ClientRepository clientRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.clientRepository = clientRepository;
        this.authGroupRepository = authGroupRepository;
    }

//    public AutofixUserDetailsService(EmployeeRepository employeeRepository, AuthGroupRepository authGroupRepository) {
//        super();
//        this.employeeRepository = employeeRepository;
//        this.authGroupRepository = authGroupRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if(client ==null) {
            throw new UsernameNotFoundException("Can't find username: " + username);
        }
        List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
        return new AutofixClientPrincipal(client, authGroups);
    }

}
