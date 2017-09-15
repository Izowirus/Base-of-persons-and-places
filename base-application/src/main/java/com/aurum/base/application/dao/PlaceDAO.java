package com.aurum.base.application.dao;

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

import com.aurum.base.model.entities.Place;
@Repository

public interface PlaceDAO extends CrudRepository<Place, Long> {

	public Place findByName(String Name);

	@Query("SELECT p FROM Place as p WHERE p.name LIKE :nameToSearch")
	public List<Place> searchByName(@Param(value = "nameToSearch") String nameToSearch);
	

		


	
}