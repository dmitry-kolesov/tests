package com.luxoft.springadvanced.beanvalidation;

import com.luxoft.springadvanced.beanvalidation.error.PersonNotFoundException;
import com.luxoft.springadvanced.beanvalidation.error.PersonUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons")
    List<Person> findAll() {
        return repository.findAll();
    }

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    Person newPerson(
            // turns controller validation on
            //@Valid
             @RequestBody Person newPerson
    ) {
        // insert on Commit
        //return repository.save(newPerson);

        // insert on method invocation
        return repository.saveAndFlush(newPerson);
    }

    @GetMapping("/persons/{id}")
    Person findOne(@PathVariable @Min(value = 1, message = "AAAAAAA")  @Max(value = 10, message = "SSSS") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/persons/{id}")
    Person saveOrUpdate(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setCountry(newPerson.getCountry());
                    person.setSalary(newPerson.getSalary());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
    }

    @PatchMapping("/persons/{id}")
    Person patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(person -> {

                    String country = update.get("country");
                    if (!StringUtils.isEmpty(country)) {
                        person.setCountry(country);

                        return repository.save(person);
                    } else {
                        throw new PersonUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new PersonNotFoundException(id);
                });

    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
