package com.aurum.base.webApp.controllers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aurum.base.application.dao.RelationshipTypeDAO;
import com.aurum.base.application.services.PersonService;
import com.aurum.base.application.services.PlaceService;
import com.aurum.base.application.services.UserService;
import com.aurum.base.model.entities.Person;
import com.aurum.base.model.entities.Place;
import com.aurum.base.model.entities.Relationship;
import com.aurum.base.model.entities.RelationshipType;
import com.aurum.base.model.entities.User;
import com.aurum.base.webApp.dtos.PersonDTO;
import com.aurum.base.webApp.dtos.PlaceDTO;
import com.aurum.base.webApp.dtos.RelationshipDTO;
import com.aurum.base.webApp.dtos.SearchDTO;
@Controller
@RequestMapping("/profiles")
public class ProfilesController {	
	@Autowired
	private PersonService persons;
	@Autowired
	private PlaceService places;
	@Autowired
	private UserService users;
	
	@RequestMapping
	public String getProfiles(Model model){
		model.addAttribute("persons", persons.getList());
		return "profiles";
	}

	
	@RequestMapping("/person-{id}")
	public String getProfile(@PathVariable Long id, Model model){
		Person person = persons.getByID(id);
		model.addAttribute("person", person);
		model.addAttribute("title", person.getNick());
		String placeName = person.getOrigin();
		Place place = places.getByName(placeName);
		model.addAttribute("place", place);
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = users.getByName(username);
			User userPerson=person.getUser();
		
			if (user.getRole().equals("admin")){
				model.addAttribute("Owner",true);
	
			}
			else if (userPerson.getName().equals(username)){
				model.addAttribute("Owner",true);
			}

		} catch (NullPointerException e) {
			
		}

		model.addAttribute("ListRelations", person.getRelationshipSetOwner());
		model.addAttribute("ListRelationsSecond", person.getRelationshipSetSecond());

		return "person";
	}
	@PostMapping(value = "/person-{id}/delete")
	public String deletePerson(@PathVariable Long id,  Model model){
		persons.deletePerson(id);
		return "redirect:/profiles";
	}
	@PostMapping(value = "/editRelationship-{id}/delete")
	public String deleteRelationship(@PathVariable Long id,  Model model){
		persons.deleteRelationship(id);
		return "redirect:/profiles";
	}
	@GetMapping("/person-{id}/addRelationship")
	public String getAddRelationship(@PathVariable Long id, Model model){
		model.addAttribute("relationshipDTO", new RelationshipDTO());
		model.addAttribute("typeList",persons.getRelationshipTypes());
		model.addAttribute("person",persons.getByID(id));
		return "addRelationship";
	}
	@PostMapping("/person-{id}/addRelationship")
	public String postAddRelationship(@ModelAttribute("relationshipDTO") @Valid RelationshipDTO relationshipDTO, BindingResult result,@PathVariable Long id, String nickSecond, String type, Model model){

		
		if (result.hasErrors()) {
			model.addAttribute("relationshipDTO", relationshipDTO);
			model.addAttribute("typeList",persons.getRelationshipTypes());
	        return "addRelationship";
	       } 
		else {
			
	    	   Person person = persons.getByID(id);
	    	   Person personSecond = persons.getByNick(nickSecond);
	    	   if (personSecond != null){
	    		   RelationshipType relationshipType = persons.getByType(type);
	    		   persons.addRelationship(person, personSecond, relationshipType);

	    		  // return "redirect:/index";
	    		   return "redirect:/profiles/person-"+id;
	    	   }
	    	   else {
	   				PersonDTO personDTO= new PersonDTO();
	   				personDTO.setNick(nickSecond);
	   				model.addAttribute("personDTO", personDTO);
	   				model.addAttribute("title", "Dodaj postać!");
	    		    return "addPerson";
	    	   }
	       }
	}
	@GetMapping("/addPerson")
	public String getAddPerson(Model model){
		model.addAttribute("personDTO", new PersonDTO());
		model.addAttribute("title", "Dodaj postać!");
		model.addAttribute("typeList",persons.getRelationshipTypes());
		return "addPerson";
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addPerson")
	public String postAddPerson(@ModelAttribute("personDTO") @Valid PersonDTO personDTO, BindingResult result, Model model){		
		 if (result.hasErrors()) {
	            
			 	model.addAttribute("personDTO", personDTO);
				model.addAttribute("title", "Dodaj postać!");
	            return "addPerson";
	       } else {
	   			String username = SecurityContextHolder.getContext().getAuthentication().getName();
	   			User user = users.getByName(username);
				//model.addAttribute("user",user);
	            Person person= createPerson(personDTO, user);
	            persons.addPerson(person);

	            return "redirect:/index";
	       }
	    
	}
	@GetMapping("/person-{id}/edit")
	public String getEdit(@PathVariable Long id, Model model){
		model.addAttribute("personDTO", new PersonDTO());
		model.addAttribute("title", "Edytuj postać");
		model.addAttribute("person",persons.getByID(id));
		Person person = persons.getByID(id);
		model.addAttribute("ListRelations", person.getRelationshipSetOwner());
		model.addAttribute("ListRelationsSecond", person.getRelationshipSetSecond());
		return "edit";
	}
	@PostMapping("/person-{id}/edit")
	public String postEdit(@ModelAttribute("personDTO") @Valid PersonDTO personDTO, BindingResult result,@PathVariable Long id, Model model){
		if (result.hasErrors()){
			model.addAttribute("person",persons.getByID(id));
		 	model.addAttribute("personDTO", personDTO);
			model.addAttribute("title", "Dodaj postać!");
			//for(ObjectError temp:result.getAllErrors())	System.out.println(temp);
            return "edit";
		} else {
	    	Person person= persons.getByID(id);   
	    	editPerson(personDTO,person);
            persons.addPerson(person);
            return "redirect:/profiles/person-"+id;
       }
		
	}
	@GetMapping("/editRelationship-{id}")
	public String getEditRelationship(@PathVariable Long id, Model model){
		//model.addAttribute("personDTO", new PersonDTO());
		Relationship relation= persons.getRelationship(id);
		RelationshipDTO relationshipDTO= new RelationshipDTO();
		relationshipDTO.setType(relation.getRelationshipType().getType());
		relationshipDTO.setNick(relation.getPerson_owner().getNick());
		relationshipDTO.setNickSecond(relation.getPerson_second().getNick());
		Person person =relation.getPerson_owner();
		Person personSecond =relation.getPerson_second();
		model.addAttribute("relationshipDTO", relationshipDTO);
		model.addAttribute("typeList",persons.getRelationshipTypes());
		model.addAttribute("person",person);
		model.addAttribute("personSecond",personSecond);
		model.addAttribute("relationship", relation);
		model.addAttribute("title", "Edytuj relację");
		//model.addAttribute("person",persons.getByID(id));
		//Person person = persons.getByID(id);
		//model.addAttribute("ListRelations", person.getRelationshipSetOwner());
		//model.addAttribute("ListRelationsSecond", person.getRelationshipSetSecond());
		return "editRelationship";
	}
	@PostMapping("/editRelationship-{idRelationship}")
	public String postEditRelationship(@ModelAttribute("relationshipDTO") @Valid RelationshipDTO relationshipDTO, BindingResult result,@PathVariable("idRelationship") Long id, Model model)
		{
		if (result.hasErrors()){
			Relationship relation= persons.getRelationship(id);
			relationshipDTO.setType(relation.getRelationshipType().getType());
			Person person =relation.getPerson_owner();
			Person personSecond =relation.getPerson_second();
			model.addAttribute("relationshipDTO", relationshipDTO);
			model.addAttribute("typeList",persons.getRelationshipTypes());
			model.addAttribute("person",person);
			model.addAttribute("personSecond",personSecond);
			model.addAttribute("relationship", relation);
			model.addAttribute("title", "Edytuj relację");
			//for(ObjectError temp:result.getAllErrors())	System.out.println(temp);
            return "editRelationship";
		} else {
	    	Relationship relation= persons.getRelationship(id);
	    	String type =relationshipDTO.getType();
	    	RelationshipType relationshipType=persons.getByType(type);
	    	relation.setRelationshipType(relationshipType);
	    	persons.editRelationship(relation);
            return "redirect:/profiles/person-"+relation.getPerson_owner().getId();
       }
	}
	@PostMapping("/search")
	public String searchNick(@ModelAttribute("searchDTO") @Valid SearchDTO searchDTO, BindingResult result, Model model){
		String errors = null;
		if(result.hasErrors()){
			errors = "Wpisales nieprawidlowo dane, prosze szukaj dalej";
		}
		model.addAttribute("error",errors);
		Iterable<Person> serchingResult = persons.search(searchDTO.getNickToSearch());
		System.out.println(serchingResult);
		model.addAttribute("searchingResult", serchingResult);		
		return "searchResult";
	}

	private Person createPerson(PersonDTO personDTO, User user){
        Person person= new Person();
        person.setNick(personDTO.getNick());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setAge(personDTO.getAge());
        person.setOrigin(personDTO.getOrigin());
        person.setSkills(personDTO.getSkills());
        person.setBirthday(personDTO.getBirthday());
        person.setUser(user);
        return person;
	}
	//private void createRealtionship(Person person, Person personSecond){
	//	addRelationship(person, personSecond);
	//	return relationship;
	//}
	private void editPerson(PersonDTO personDTO, Person person){
        person.setNick(personDTO.getNick());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setAge(personDTO.getAge());
        person.setOrigin(personDTO.getOrigin());
        person.setSkills(personDTO.getSkills());
        person.setBirthday(personDTO.getBirthday());
 
	}


	@ModelAttribute ("List")
	public Iterable<Person> attributeList(){
		return persons.getList();
	}
	@ModelAttribute("searchDTO")
	public SearchDTO getSearchDTO(){
		return new SearchDTO();
	}
}
