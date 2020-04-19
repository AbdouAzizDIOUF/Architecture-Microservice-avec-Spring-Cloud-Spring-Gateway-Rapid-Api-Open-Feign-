package org.si.com;

import org.si.com.entity.Costumer;
import org.si.com.repository.CostumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CostumerRepository costumerRepository){
        return args -> {
            costumerRepository.save(new Costumer(null, "DIOUF", "abdouazizdiouf@gmail.com"));
            costumerRepository.save(new Costumer(null, "Samebou", "maman@gmail.com"));
            costumerRepository.save(new Costumer(null, "DIOUF", "papa@gmail.com"));
            costumerRepository.findAll().forEach(System.out::print);
        };
    }
}
