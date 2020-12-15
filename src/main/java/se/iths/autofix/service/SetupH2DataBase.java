package se.iths.autofix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import se.iths.autofix.controller.ClientController;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.EmployeeRepository;

@Configuration
//@Slf4j
@Component
public class SetupH2DataBase {
    Logger logger = LoggerFactory.getLogger(SetupH2DataBase.class);


    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository,
                                   AuthGroupRepository authGroupRepository) {
        return args -> {
            if( System.getProperty("SPRING_DRIVER_CLASS")=="org.h2.Driver") {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                //New empty database, add some persons
                Employee employee = new Employee("ADMIN","ADMIN","ADMIN","ADMIN","GOD");
                employee.setPassword(passwordEncoder.encode(employee.getPassword()));
                repository.save(employee);
                logger.info("Added to database " + employee.getUsername());
                authGroupRepository.save(new AuthGroup(employee.getUsername(), "ADMIN"));
            }
        };
    }
}
