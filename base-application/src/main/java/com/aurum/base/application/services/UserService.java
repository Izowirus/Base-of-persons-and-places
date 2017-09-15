package com.aurum.base.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurum.base.application.dao.UserDAO;
import com.aurum.base.model.entities.Person;
import com.aurum.base.model.entities.User;


@Service
public class UserService {
	@Autowired
	private UserDAO users;
	

	public User getByName(String name){
		return users.findByName(name);
	}
	public void addUser(User user){
		users.save(user);
	}
	

}
