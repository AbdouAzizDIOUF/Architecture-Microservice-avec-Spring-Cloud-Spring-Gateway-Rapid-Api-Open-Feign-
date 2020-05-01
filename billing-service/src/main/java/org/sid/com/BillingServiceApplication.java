package org.sid.com;

import org.sid.com.repository.BillRepository;
import org.sid.com.repository.ProductItemRepository;
import org.sid.com.entity.Bill;
import org.sid.com.entity.ProductItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) { SpringApplication.run(BillingServiceApplication.class, args); }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository){
        return args -> {
            Bill bill1 = billRepository.save(new Bill(null, new Date(), 1L, null, null));
            productItemRepository.save(new ProductItem(null, 1L, null, 80, 50, bill1));
            productItemRepository.save(new ProductItem(null, 2L, null, 80, 50, bill1));
            productItemRepository.save(new ProductItem(null, 3L, null, 80, 50, bill1));
        };
    }
}
