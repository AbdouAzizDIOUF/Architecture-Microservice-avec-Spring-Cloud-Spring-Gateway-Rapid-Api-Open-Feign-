package org.sid.com;

import org.sid.com.entity.Product;
import org.sid.com.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null, "Ordinateur", 550.45));
            productRepository.save(new Product(null, "Television", 550.45));
            productRepository.save(new Product(null, "Portable", 550.45));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
