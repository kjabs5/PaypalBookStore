package com.kishor.paypalbookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishor.paypalbookstore.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
