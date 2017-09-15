package com.aurum.base.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="relationships")
public class Relationship {
	
	@GeneratedValue
	@Id
	private Long id;

	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="id_owner")
	private Person person_owner;
	
	@ManyToOne
	@JoinColumn(name="id_second")
	private Person person_second;
	
	@ManyToOne
	@JoinColumn(name="id_relationship")
	private RelationshipType relationshipType;	


	public Person getPerson_owner() {
		return person_owner;
	}

	public void setPerson_owner(Person person_owner) {
		this.person_owner = person_owner;
	}

	public Person getPerson_second() {
		return person_second;
	}

	public void setPerson_second(Person person_second) {
		this.person_second = person_second;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RelationshipType getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(RelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}

	
}
 