package com.aurum.base.webApp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurum.base.application.services.PlaceService;
import com.aurum.base.application.services.UserService;
import com.aurum.base.model.entities.Place;
import com.aurum.base.model.entities.User;
import com.aurum.base.webApp.dtos.PlaceDTO;
import com.aurum.base.webApp.dtos.SearchDTO;

@Controller
@RequestMapping("/places")
public class PlacesController {

	@Autowired
	private PlaceService places;
	@Autowired
	private UserService users;

	@RequestMapping
	public String getPlaces(Model model){
		model.addAttribute("places", places.getList());
		return "places";
	}


	@ModelAttribute("searchDTO")
	public SearchDTO getSearchDTO() {
		return new SearchDTO();
	}

	@ModelAttribute("List")
	public Iterable<Place> attributeList() {
		return places.getList();
	}

	@RequestMapping("/place-{id}")
	public String getPlace(@PathVariable Long id, Model model) {
		Place place = places.getByID(id);
		
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = users.getByName(username);
			User userPerson =place.getUser();
		
			if (user.getRole().equals("admin")){
				model.addAttribute("Owner",true);
	
			}
			else if (userPerson.getName().equals(username)){
				model.addAttribute("Owner",true);
			}

		} catch (NullPointerException e) {
			
		}
		if (place != null) {
			model.addAttribute("place", place);
			model.addAttribute("title", place.getName());
			return "place";
		}
		else return "places";

	}

	@RequestMapping("/{name}")
	public String getPlaceByName(@PathVariable String name, Model model) {
		Place place = places.getByName(name);
		if (place != null) {
			model.addAttribute("place", place);
			model.addAttribute("title", place.getName());
			return "place";
		} else {
			PlaceDTO placeDTO = new PlaceDTO();
			placeDTO.setName(name);
			model.addAttribute("placeDTO", placeDTO);
			model.addAttribute("title", "Dodaj miejsce!");

			return "addPlace";
		}

	}

	@GetMapping("/addPlace")
	public String getAddPlace(Model model) {
		model.addAttribute("placeDTO", new PlaceDTO());
		model.addAttribute("title", "Dodaj miejsce!");
		return "addPlace";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addPlace")
	public String postAddPlace(@ModelAttribute("placeDTO") @Valid PlaceDTO placeDTO, BindingResult result,
			Model model) {
		if (result.hasErrors()) {

			model.addAttribute("placeDTO", placeDTO);
			model.addAttribute("title", "Dodaj miejsce!");
			return "addPlace";
		} else {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = users.getByName(username);
			Place place = createPlace(placeDTO, user);
			places.addPlace(place);
			return "redirect:/index";
		}

	}

	@GetMapping("/place-{id}/editPlace")
	public String getEdit(@PathVariable Long id, Model model) {

		model.addAttribute("title", "Edytuj miejsce");
		Place place = places.getByID(id);
		model.addAttribute("place", place);
		PlaceDTO placeDTO = new PlaceDTO();
		setAttributes(placeDTO, place);
		placeDTO.setCulture(place.getCulture());
		model.addAttribute("placeDTO", placeDTO);
		return "editPlace";
	}

	@PostMapping("/place-{id}/editPlace")
	public String postEdit(@ModelAttribute("placeDTO") @Valid PlaceDTO placeDTO, BindingResult result,
			@PathVariable Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("place", places.getByID(id));
			model.addAttribute("placeDTO", placeDTO);
			model.addAttribute("title", "Dodaj miejsce!");
			// for(ObjectError temp:result.getAllErrors())
			// System.out.println(temp);
			return "editPlace";
		} else {
			Place place = places.getByID(id);
			editPlace(placeDTO, place);
			places.addPlace(place);
			return "redirect:/places/place-" + id;
		}

	}

	@PostMapping("/search")
	public String searchName(@ModelAttribute("searchDTO") @Valid SearchDTO searchDTO, BindingResult result,
			Model model) {
		String errors = null;
		if (result.hasErrors()) {
			errors = "Wpisales nieprawidlowo dane, prosze szukaj dalej";
		}
		model.addAttribute("error", errors);
		Iterable<Place> searchingResultPlace = places.search(searchDTO.getNameToSearch());
		for (Place p : searchingResultPlace)
			System.out.println(p);
		model.addAttribute("searchingResultPlace", searchingResultPlace);
		return "searchResultPlace";
	}

	@PostMapping(value = "/place-{id}/delete")
	public String deletePlace(@PathVariable Long id, Model model) {
		places.deletePlace(id);
		return "redirect:/places";
	}

	private Place createPlace(PlaceDTO placeDTO, User user) {
		Place place = new Place();
		editPlace(placeDTO, place);
		place.setUser(user);
		return place;
	}

	private void editPlace(PlaceDTO placeDTO, Place place) {

		place.setName(placeDTO.getName());
		place.setSize(placeDTO.getSize());
		place.setIndustry(placeDTO.getIndustry());
		place.setPolitics(placeDTO.getPolitics());
		place.setCulture(placeDTO.getCulture());
		place.setFauna(placeDTO.getFauna());
		place.setFlora(placeDTO.getFlora());
		place.setMilitary(placeDTO.getMilitary());
		place.setDescription(placeDTO.getDescription());

	}

	private void setAttributes(PlaceDTO placeDTO, Place place) {

		placeDTO.setIndustry(place.getIndustry());
		placeDTO.setPolitics(place.getPolitics());
		placeDTO.setCulture(place.getCulture());
		placeDTO.setFauna(place.getFauna());
		placeDTO.setFlora(place.getFlora());
		placeDTO.setMilitary(place.getMilitary());
		placeDTO.setDescription(place.getDescription());
	}

}