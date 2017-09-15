package com.aurum.base.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aurum.base.model.entities.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long>{

	public User findByName(String name);

}
