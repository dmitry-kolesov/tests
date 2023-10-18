package com.luxoft.springadvanced.projections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/projection")
public class ProjectionController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<NameOnlyProjection> findAllByName(@RequestParam String lastname) {
        return customerRepository.findByLastname(lastname);
    }
}
