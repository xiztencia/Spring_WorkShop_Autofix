package se.iths.autofix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.repository.AuthGroupRepository;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    public boolean doesUsernameExist(String username){
        List<AuthGroup> list = authGroupRepository.findByUsername(username);
        return list.isEmpty();
    }
}
