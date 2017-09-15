package com.aurum.base.application.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurum.base.application.dao.PersonDAO;
import com.aurum.base.application.dao.RelationshipDAO;
import com.aurum.base.application.dao.RelationshipTypeDAO;
import com.aurum.base.model.entities.Person;
import com.aurum.base.model.entities.Relationship;
import com.aurum.base.model.entities.RelationshipType;


@Service
public class PersonService {
	@Autowired
	private PersonDAO persons;
	@Autowired
	private RelationshipDAO relationship;
	@Autowired
	private RelationshipTypeDAO types;
	
	public void addPerson(Person person){
		persons.save(person);
	}
	
	public Person getByID(Long id){
		return persons.findOne(id);
	}
	
	public Iterable<Person> getList(){
		return persons.findAll();
	}
	public Iterable<Person> getDayList(Date date){
		
		return persons.searchByDate(date);
	}
	
	public Person getByNick(String nick){
		return persons.findByNick(nick);
	}

	public RelationshipType getByType(String type){
		return types.findByType(type);
	}

	public Iterable<Person> search(String nickToSearch) {
		return persons.searchByNick("%" + nickToSearch +"%");
	}
	
	public void deletePerson(Long id){
		persons.delete(id);
	}
	
	public void deleteRelationship(Long id){
		relationship.delete(id);
	}
	
	public Iterable<RelationshipType> getRelationshipTypes(){
		return types.findAll();
	}
	public Relationship getRelationship(Long id){
		
		return relationship.findOne(id);
	}
	public void addRelationship(Person person, Person personSecond, RelationshipType type){
   
        Relationship relations = new Relationship();
        relations.setPerson_owner(person);
        relations.setPerson_second(personSecond);
        relations.setRelationshipType(type);
        person.getRelationshipSetOwner().add(relations);
        relationship.save(relations);
	}
	public void editRelationship( Relationship relation){

		relationship.save(relation);
	}

}

