package se.iths.autofix.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.Property;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")

       public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();

    }



}