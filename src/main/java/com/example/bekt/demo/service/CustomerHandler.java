package com.example.bekt.demo.service;

import com.example.bekt.demo.entity.Customer;
import com.example.bekt.demo.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Log4j2
@NoArgsConstructor
public class CustomerHandler {

    private Logger log = LoggerFactory.getLogger(CustomerHandler.class);

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> getAllCustomer() {
        Flux<Customer> result =  customerRepository.findAll();
        log.info("RESULT: "+ result.toString());
        return result;
    }

    public Mono<Customer> getCustomer(Integer id) {
        Mono<Customer> result =  customerRepository.findById(id);
        log.info("RESULT: "+ result.toString());
        return result;
    }
}
