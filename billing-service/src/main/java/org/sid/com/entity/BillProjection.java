package org.sid.com.entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "bill", types = {Bill.class})
public interface BillProjection{
    public Date getBillingDate();
    public Collection<ProductItem> getProductItems();
}
