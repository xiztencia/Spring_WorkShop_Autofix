package se.iths.autofix.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.User;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.EmployeeRepository;
import se.iths.autofix.repository.UserRepository;

import java.util.List;

@Service
public class AutofixUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;
    private AuthGroupRepository authGroupRepository;

    public AutofixUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

//    public AutofixUserDetailsService(EmployeeRepository employeeRepository, AuthGroupRepository authGroupRepository) {
//        super();
//        this.employeeRepository = employeeRepository;
//        this.authGroupRepository = authGroupRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("Can't find username: " + username);
        }
        List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
        return new AutofixUserPrincipal(user, authGroups);
    }

}
