package com.aurum.base.webApp.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aurum.base.application.services.UserService;
import com.aurum.base.model.entities.User;
import com.aurum.base.webApp.dtos.UserDTO;

@Controller
public class UserController {

	@Autowired
	private UserService users;
	
	@GetMapping("/register")
	public String logIn(Model model){
		model.addAttribute("UserDTO", new UserDTO());
		model.addAttribute("title", "Zaloguj się");
		return "logIn";
	}
	@PostMapping("/register")
	public String postlogIn(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult result, Model model ){
		
		 if (result.hasErrors()) {
			 model.addAttribute(BindingResult.class.getName()+".UserDTO", result);
			 model.addAttribute("UserDTO", userDTO);
			 model.addAttribute("title", "Zaloguj się");
	         return "logIn";
	     } else {
	    	   
	            User user= createUser(userDTO);
	            users.addUser(user);

	            return "redirect:/index";
	       }
	}
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/profile")
	public String getProfile(Model model){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = users.getByName(username);
		model.addAttribute("user",user);
		model.addAttribute("UserDTO",new UserDTO());
		model.addAttribute("title", "Twój profil");
		model.addAttribute("PersonsList", user.getPerson());
		model.addAttribute("PlacesList", user.getPlace());
		return "profile";
	}
	
	@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/index";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	@RequestMapping("/contact")
	public String getContact(Model model){
		
		return "contact";
	}
	private User createUser(UserDTO userDTO){
        User user= new User();
        user.setName(userDTO.getName());
        user.setMail(userDTO.getMail());
        user.setPassword(userDTO.getPassword());
        user.setRole("user");

        return user;
	}

}
