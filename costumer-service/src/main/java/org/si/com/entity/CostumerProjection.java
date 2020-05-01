package org.si.com.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@Projection(name = "p1", types = {Costumer.class})
public interface CostumerProjection {
    @Value("#{target.id}")
    public Long getId();
    public String getNom();
}
