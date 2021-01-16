package se.iths.autofix.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import se.iths.autofix.entity.AuthGroup;
import se.iths.autofix.entity.Client;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.repository.AuthGroupRepository;
import se.iths.autofix.repository.ClientRepository;
import se.iths.autofix.repository.EmployeeRepository;
import se.iths.autofix.repository.SparePartRepository;
@Configuration
@Component
public class SetupH2DataBase {
    Logger logger = LoggerFactory.getLogger(SetupH2DataBase.class);
    @Bean
    @ConditionalOnProperty(value="SPRING_DATASOURCE_URL",
            havingValue = "jdbc:h2:mem:test")
    CommandLineRunner initDatabase(EmployeeRepository emprepository,
                                   ClientRepository clientRepository,
                                    SparePartRepository sparePartRepository,
                                   AuthGroupRepository authGroupRepository) {
            return args -> {
                if(System.getProperty("SPRING_DRIVER_CLASS").equals("org.h2.Driver")) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    //New empty database, add some persons
                    Employee employee = new Employee("admin","admin","admin","admin","god");
                    employee.setPassword(passwordEncoder.encode(employee.getPassword()));
                    emprepository.save(employee);
                    logger.info("Added to database " + employee.getUsername());
                    authGroupRepository.save(new AuthGroup(employee.getUsername(), "ADMIN"));

                    Client client = new Client("user","user","user","user","human");
                    client.setPassword(passwordEncoder.encode(client.getPassword()));
                    clientRepository.save(client);
                    logger.info("Added to database " + client.getUsername());
                    authGroupRepository.save(new AuthGroup(client.getUsername(), "USER"));

                    Client clientX = new Client("user2","Jn","Doe","jhon_doe@google.com","human");
                    clientX.setPassword(passwordEncoder.encode(clientX.getPassword()));
                    clientRepository.save(clientX);
                    logger.info("Added to database " + clientX.getUsername());
                    authGroupRepository.save(new AuthGroup(clientX.getUsername(), "USER"));

                    SparePart wheel = new SparePart("wheels","car wheel",800.00, 1);
                    SparePart backMirror = new SparePart("mirrors","back wheel",549.00, 1);
                    SparePart frontLight = new SparePart("lights","front light", 1200.00, 2 );

                    sparePartRepository.save(wheel);
                    sparePartRepository.save(backMirror);
                    sparePartRepository.save(frontLight);
                    logger.info("Added to database 3 spare parts");
                }
            };

    }
}
