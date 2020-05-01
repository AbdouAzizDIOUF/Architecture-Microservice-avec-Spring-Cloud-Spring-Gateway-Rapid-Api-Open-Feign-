package org.sid.com.Iservice;

import org.sid.com.entity.Costumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "costumer-service")
public interface CostumerServiceClient {

    @GetMapping("/costumers/{id}?projection=fullCostumer")
    Costumer findCostumerById(@PathVariable("id") Long id);
}
