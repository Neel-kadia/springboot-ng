package com.example.CustomerRegistration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerRegistration.model.Customer;
import com.example.CustomerRegistration.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// get all Customers
	@GetMapping("/customers")
	public List < Customer > getAllCustomers() {
		return customerService.findbyAllOrderByIdDesc();
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity < Customer > getCustomerById(@PathVariable int id) {
		Customer customer = customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity < Customer > updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		Customer updateCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(updateCustomer);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity < Map < String, Boolean >> deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomerById(id);
		Map < String, Boolean > response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}