package com.seb.restapi.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.seb.restapi.model.Customer;
import com.seb.restapi.model.Customers;

@Repository
public class CustomerDAO {

private static Customers customerList = new Customers();

	static {
		customerList.getCustomerList().add(new Customer(1, "AAA", "111", new Date(), 37061111111L, "email1@adress.com"));
		customerList.getCustomerList().add(new Customer(2, "BBB", "222", new Date(), 37062222222L, "email2@adress.com"));
		customerList.getCustomerList().add(new Customer(3, "CCC", "333", new Date(), 37063333333L, "email3@adress.com"));
		customerList.getCustomerList().add(new Customer(4, "DDD", "444", new Date(), 37064444444L, "email4@adress.com"));
		customerList.getCustomerList().add(new Customer(5, "EEE", "555", new Date(), 37065555555L, "email5@adress.com"));
	}
	
	public Customers getCustomerList() {
		return customerList;
	}
	
	public Customer getCustomerByID(String id) {
		for(Customer customer : customerList.getCustomerList()) { 
			   if(customer.getId() == (Integer.valueOf(id))) { 
			       return customer;
			   }
			}
		return null;
	}
	
	public void addCustomer(Customer customer) {
		customerList.getCustomerList().add(customer);
	}
	
	
	public void update(Long id, Customer newItem) {
		int c = 0;
		for (Customer cst : customerList.getCustomerList()) { 	
        	if (cst.getId().longValue() == id) {
        		newItem.setId(id.intValue());
        		customerList.getCustomerList().set(c, newItem);
        		break;
        	}
        	c += 1;
        }
    }

    public void delete(Long id) {
    	int c = 0;
        for (Customer cst : customerList.getCustomerList()) { 	
        	if (cst.getId().longValue() == id) {
        		customerList.getCustomerList().remove(c);
        		break;
        	}
        	c += 1;
        }
    }
    
}
