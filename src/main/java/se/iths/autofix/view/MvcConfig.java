package se.iths.autofix.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration

public class MvcConfig  implements WebMvcConfigurer{
  @Autowired
  private ThymeleafViewResolver thymeleafViewResolver;

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
        registry.addViewController("/Maintenance").setViewName("Maintenance");
        registry.addViewController("/createAdmin").setViewName("CreateAdmin");
        registry.addViewController("/login").setViewName("Login");

        //registry.addViewController("/Navbar").setViewName("Navbar");

    }

/*    @Bean
    //@Override
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
        dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        dateTimeRegistrar.registerFormatters(conversionService);

        DateFormatterRegistrar dateRegistrar = new DateFormatterRegistrar();
        dateRegistrar.setFormatter(new DateFormatter("yyyy.MM.dd"));
        dateRegistrar.registerFormatters(conversionService);

        return conversionService;
    }*/
//    @Bean
//    @Description("Thymeleaf Template Resolver")
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//
//        return templateResolver;
//    }
//    @Bean
//    @Description("Thymeleaf Template Engine")
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setTemplateEngineMessageSource(messageSource());
//        return templateEngine;
//    }
//    @Bean
//    @Description("Thymeleaf View Resolver")
//    public ThymeleafViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setOrder(1);
//        return viewResolver;
//    }
//    @Bean
//    @Description("Spring Message Resolver")
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        return messageSource;
//    }
}
