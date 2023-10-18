package com.luxoft.springadvanced.projections;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "myprojection2", types = Customer.class)
public interface CustomerProjection2 {

    String getFirstname();
}
