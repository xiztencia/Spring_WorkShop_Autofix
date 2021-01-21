package se.iths.autofix.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig  implements WebMvcConfigurer{


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("Home");
        registry.addViewController("/").setViewName("Home");
        registry.addViewController("/application").setViewName("Application");
        registry.addViewController("/Employee").setViewName("Employee");
        registry.addViewController("/Client").setViewName("Client");
        registry.addViewController("/admin").setViewName("Admin");
        registry.addViewController("/signUp").setViewName("SignUp");
        registry.addViewController("/CreateSparePart").setViewName("CreateSparePart");
        registry.addViewController("/MaintenanceRequest").setViewName("MaintenanceRequest");
        registry.addViewController("/editMaintenance").setViewName("editMaintenance");
        registry.addViewController("/Maintenance").setViewName("Maintenance");
        registry.addViewController("/createAdmin").setViewName("CreateAdmin");
        registry.addViewController("/login").setViewName("Login");
    }

}
