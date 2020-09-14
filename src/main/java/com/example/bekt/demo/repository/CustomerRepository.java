package com.example.bekt.demo.repository;

import com.example.bekt.demo.entity.Customer;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
    
	@Query("SELECT c FROM Customer WHERE c.id = :id ")
	public Mono<Customer> getTest(@Param("id") Integer id);
}
