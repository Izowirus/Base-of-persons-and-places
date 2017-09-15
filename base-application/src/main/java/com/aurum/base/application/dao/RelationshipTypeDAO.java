package com.aurum.base.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aurum.base.model.entities.Person;
import com.aurum.base.model.entities.RelationshipType;
@Repository
public interface RelationshipTypeDAO extends CrudRepository<RelationshipType, Long>{

	public RelationshipType findByType(String type);

}
