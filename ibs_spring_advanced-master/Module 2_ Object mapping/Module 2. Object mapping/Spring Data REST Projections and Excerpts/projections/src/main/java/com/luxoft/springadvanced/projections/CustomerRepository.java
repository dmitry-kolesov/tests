package com.luxoft.springadvanced.projections;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = CustomerProjection.class )
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<NameOnlyProjection> findByLastname(String lastname);
}
