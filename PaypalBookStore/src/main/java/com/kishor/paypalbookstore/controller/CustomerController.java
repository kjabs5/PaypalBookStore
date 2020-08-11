package com.kishor.paypalbookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kishor.paypalbookstore.entity.Customer;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@RequestMapping("/registerform")
	public String registerCustomer(Model theModel)
	{
		Customer customer=new Customer();
		theModel.addAttribute("customer", customer);
		return "customer/login/registration";
	}
	
	

}
