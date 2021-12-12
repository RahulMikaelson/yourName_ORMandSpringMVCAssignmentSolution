package com.greatlearning.CRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.CRM.Entities.Customers;
import com.greatlearning.CRM.Services.CRM_Services;

@Controller
@RequestMapping("/customers")
public class CRM_Controller {

	@Autowired
	private CRM_Services crm_services;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customers> customer = crm_services.findAll();
		model.addAttribute("customers", customer);
		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customers customer = new Customers();
		theModel.addAttribute("customers", customer);

		// send over to our form
		return "new-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customer id") int id, Model theModel) {

		// get the customers from the service
		Customers thecustomer = crm_services.findById(id);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("customers", thecustomer);

		// send over to our form
		return "new-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("First Name") String f_name,
			@RequestParam("Last Name") String l_name, @RequestParam("E-Mail") String email) {

		System.out.println(id);
		Customers customer;
		if (id != 0) {
			customer = crm_services.findById(id);
			customer.setId(id);
			customer.setF_name(f_name);
			customer.setL_name(l_name);
			customer.setEmail(email);
		} else {
			customer = new Customers(f_name, l_name, email);

			// save the book
			crm_services.save(customer);

		}

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String deleteById(int id) {

		// delete the student
		crm_services.deleteById(id);

		return "redirect:/customers/list";

	}

}
