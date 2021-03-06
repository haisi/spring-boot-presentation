package ch.fhnw;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(CustomerProperties.class)
public class Demo {

    @Autowired
    CustomerProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepo repo) {
        return args -> {

            String evilName = properties.getEvil();

            Arrays.asList("Hasan,Michael,Lucas,Elias,Frank,Vader".split(","))
                    .forEach(name -> repo.save(new Customer(name)));

            repo.findAll().forEach(System.out::println);
            repo.findByName(evilName).forEach(c -> System.out.println("Evil customer: " + c));
        };
    }

    @Bean
    @Profile("dev")
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
