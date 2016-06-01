package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HelloController
{
	public HelloController()
	{
		System.out.println("Hi");
	}
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
	ModelAndView addCustomerDetails(@ModelAttribute("customer") Customer customer )
	{
		ModelAndView modelView = new ModelAndView("details");
		System.out.println(customer.getName());
		modelView.addObject("msg","hi");
		return modelView;
	}
}
