package com.greatlearning.CRM.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.CRM.Entities.Customers;

@Service
public interface CRM_Services {
	
	public List<Customers> findAll();
	
	
	// Finding Customer By ID
	public Customers findById(int id);

	
	// Insert and update method
	public void save(Customers customer);

	// Delete method
	public void deleteById(int id);


}