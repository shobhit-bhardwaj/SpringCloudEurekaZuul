package com.employProducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employProducer.bean.Employ;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployController {
	@RequestMapping (value="/employ", method=RequestMethod.GET)
	@HystrixCommand (fallbackMethod="getDataFallBack")
	public Employ getEmploy() {
		Employ employ = new Employ(101, "Shobhit", "Java Developer", 17000);

		/*if(employ.getName().equalsIgnoreCase("Shobhit"))
			throw new RuntimeException();*/

		return employ;
	}

	public Employ getDataFallBack() {
		Employ employ = new Employ(-1, "FALL_BACK", "FALL_BACK", -1);
		return employ;
	}
}