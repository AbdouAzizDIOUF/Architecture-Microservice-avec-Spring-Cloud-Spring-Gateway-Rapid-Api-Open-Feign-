package org.sid.com.controller;

import org.sid.com.Iservice.CostumerServiceClient;
import org.sid.com.Iservice.InventoryServiceClient;
import org.sid.com.repository.BillRepository;
import org.sid.com.repository.ProductItemRepository;
import org.sid.com.entity.Bill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillController {

    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CostumerServiceClient costumerServiceClient;
    private final InventoryServiceClient inventoryServiceClient;

    public BillController(BillRepository billRepository, ProductItemRepository productItemRepository, CostumerServiceClient costumerServiceClient, InventoryServiceClient inventoryServiceClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.costumerServiceClient = costumerServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCostumer(costumerServiceClient.findCostumerById(bill.getCostumerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(p->{
            p.setProduct(inventoryServiceClient.findProductById(p.getProductID()));
        });

        return bill;
    }

}
