package org.si.com.repository;

import org.si.com.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CostumerRepository extends JpaRepository<Costumer, Long> {

}
