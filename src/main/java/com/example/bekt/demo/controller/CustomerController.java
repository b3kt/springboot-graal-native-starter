package com.example.bekt.demo.controller;

import com.example.bekt.demo.entity.Customer;
import com.example.bekt.demo.service.CustomerHandler;

import org.flywaydb.core.internal.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import reactor.core.publisher.Flux;

@Controller
public class CustomerController {

    private Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerHandler customerHandler;

    @GetMapping("/")
    public String customer(final Model model) {

        log.info("begin. fetch customer data ");
        final StopWatch sw = new StopWatch();
        sw.start();

        Flux<Customer> customerList = customerHandler.getAllCustomer();
        log.info("{}", customerList);

        IReactiveDataDriverContextVariable reactiveDataDrivenMode = 
            new ReactiveDataDriverContextVariable(customerList, 1);
        model.addAttribute("customers", reactiveDataDrivenMode);

        sw.stop();
        log.info("finished. fetch customer data ");
        log.info("Processing time: Customer.customer() : {} ms", sw.getTotalTimeMillis());
        return "customer";
    }
}
