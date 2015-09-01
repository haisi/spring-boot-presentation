package ch.fhnw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepo repo) {
        return args -> {
            Arrays.asList("Hasan,Michael,Lucas,Elias,Frank".split(","))
                    .forEach(name -> repo.save(new Customer(name)));

            repo.findAll().forEach(System.out::println);
            repo.findByName("Michael").forEach(System.out::println);
        };
    }
}
