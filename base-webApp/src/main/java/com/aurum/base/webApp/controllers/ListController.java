package com.aurum.base.webApp.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurum.base.application.services.PersonService;
import com.aurum.base.model.entities.Person;

@Controller

public class ListController {
	@Autowired
	private PersonService persons;

	@RequestMapping({"/","index"})
	public String getIndex(Model model){
	
			Date today = new Date();
			Iterable<Person> dayList=persons.getDayList(today);
			model.addAttribute("dayList", dayList);
	
		return "index";
	}

}
