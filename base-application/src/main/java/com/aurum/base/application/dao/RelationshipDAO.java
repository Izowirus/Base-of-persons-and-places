package com.aurum.base.application.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurum.base.model.entities.Person;
import com.aurum.base.model.entities.Relationship;
@Repository
public interface RelationshipDAO extends CrudRepository<Relationship, Long>{
	//@Query("SELECT * FROM relationships WHERE id_owner = :ID")
	//public Iterable<Relationship> findByPerson_owner(@Param("ID") Long ID);
	
}
