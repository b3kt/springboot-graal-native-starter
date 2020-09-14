package com.example.bekt.demo.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import com.example.bekt.demo.service.CustomerHandler;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/customer")
@Slf4j
public class CustomerController {

    private Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerHandler customerHandler;

    @GetMapping("/all")
    @CrossOrigin
    public ResponseEntity<Mono<?>>  findAll() {
        log.info("1. We are loving coding in production!");
 
        Mono<List<String>> listName = customerHandler.getAllCustomer()
            .map(x -> x.getFirstName().concat(" ").concat(x.getLastName()))
            .collectList();

        final Gson gson = new Gson();
        Mono<String> str = listName.map(x -> gson.toJson(x) );

        return new ResponseEntity<>(str , HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin
    public Mono<String> find(@RequestParam String name) {
        log.info("1. We are loving coding in production!");
        return Mono.just("Hello " + name + " I hope I am reactive application!!!!!");
    }

    @GetMapping("/user")
    @CrossOrigin
    public ResponseEntity<Mono<?>> get() {
        log.info("2. This is a GET request from you");
        return new ResponseEntity<>(Mono.just("One User here"), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/user/second")
    @CrossOrigin
    public Mono<ResponseEntity<?>> load() {
        log.info("3. Load me reactive client!");
        return Mono.just(ResponseEntity.ok().body("Second user location here"));
    }

}
