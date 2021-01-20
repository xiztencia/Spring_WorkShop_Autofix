package se.iths.autofix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AutofixApplication {

    public static void main(String[] args) {

        if (System.getenv("SPRING_DATASOURCE_URL")==null){
            System.setProperty("SPRING_DATASOURCE_URL","jdbc:h2:mem:test");
            System.setProperty("SPRING_DATASOURCE_USERNAME","sa");
            System.setProperty("SPRING_DATASOURCE_PASSWORD","sa");
            System.setProperty("SPRING_JPA_DATABASE-PLATFORM","org.hibernate.dialect.H2Dialect");
            System.setProperty("SPRING_DRIVER_CLASS","org.h2.Driver");
            System.setProperty("SPRING_H2_CONSOLE","true");
        }

        SpringApplication.run(AutofixApplication.class, args);
    }

}
