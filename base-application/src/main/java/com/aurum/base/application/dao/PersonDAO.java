package com.aurum.base.application.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurum.base.model.entities.Person;
@Repository

public interface PersonDAO extends CrudRepository<Person, Long> {

	public Person findByNick(String Nick);

	@Query("SELECT p FROM Person as p WHERE p.nick LIKE :nickToSearch")
	public List<Person> searchByNick(@Param(value = "nickToSearch") String nickToSearch);
	
	@Query("SELECT p FROM Person as p WHERE month(p.birthday)=month(:date) AND day(p.birthday)=day(:date)")
	public List<Person> searchByDate(@Param(value = "date") Date date);

	//public String findOriginByID(Long id);	


	
}
