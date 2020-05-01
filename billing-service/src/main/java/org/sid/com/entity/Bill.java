package org.sid.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long costumerID;
    @Transient
    private Costumer costumer;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
}
