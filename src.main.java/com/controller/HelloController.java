package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.CustomerBean;
import com.pojos.Customer;
import com.service.CustomerServiceImpl;



@Controller
public class HelloController
{
	public HelloController()
	{
		System.out.println("Hi");
	}
	@Autowired
	private CustomerServiceImpl csi;
	
	@RequestMapping("/")
	ModelAndView indexPage()
	{
		return new ModelAndView("index");
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	ModelAndView addCustomer()
	{ 
		ModelAndView modelView = new ModelAndView("feeddetails");
		return modelView; 
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	ModelAndView addCustomerDetails(@ModelAttribute("customer") CustomerBean customer )
	{
		ModelAndView modelView = new ModelAndView("details");
		Customer c = new Customer();
		c.setName(customer.getName());
		csi.registerCustomer(c);
		System.out.println("csi"+csi);
		modelView.addObject("msg","Successfully added into the database");
		return modelView;
	}
}
