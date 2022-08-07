package com.seb.restapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seb.restapi.dao.CustomerDAO;
import com.seb.restapi.exception.ClientError;
import com.seb.restapi.model.Customer;
import com.seb.restapi.model.Customers;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
    private CustomerDAO customerDAO;
	
	@Autowired
    private Validator validator;
    
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/", produces = "application/json")
    public Customers getEmployees() 
    {
        return customerDAO.getCustomerList();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	@ResponseBody
	public String getCustomerById(@PathVariable String id) {
		Customer cst = customerDAO.getCustomerByID(id);
		return cst != null ? cst.toString() : "Not found";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCustomer(
                        @RequestBody Customer customer) 
                 throws Exception 
    {       
		
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		
		 if (!violations.isEmpty()) {
			 	List<String> details = new ArrayList<>();
	            for (ConstraintViolation<Customer> cv : violations) {
	                details.add(cv.getPropertyPath() + " " + cv.getMessage());
	            }
	            ClientError error = new ClientError("Bad Request", details);
	            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	        }
        
		Integer id = customerDAO.getCustomerList().getCustomerList().size() + 1;
		customer.setId(id);

        
		customerDAO.addCustomer(customer);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(customer.getId())
                                    .toUri();

        return ResponseEntity.created(location).build();
    }
	
	
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(
            @PathVariable("id") Long id,
            @RequestBody Customer updatedItem) {

    	Set<ConstraintViolation<Customer>> violations = validator.validate(updatedItem);
		
		 if (!violations.isEmpty()) {
			 	List<String> details = new ArrayList<>();
	            for (ConstraintViolation<Customer> cv : violations) {
	                details.add(cv.getPropertyPath() + " " + cv.getMessage());
	            }
	            ClientError error = new ClientError("Bad Request", details);
	            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	        }
    	
    	customerDAO.update(id ,updatedItem);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedItem.getId())
                .toUri();

    	return ResponseEntity.created(location).build();
    }
	
	
	 @CrossOrigin(origins = "http://localhost:4200")
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
		 customerDAO.delete(id);
	    //return new ResponseEntity("Deleted", HttpStatus.OK);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(id)
	                .toUri();

	    	return ResponseEntity.created(location).build();
	 }
	
	
	
}
