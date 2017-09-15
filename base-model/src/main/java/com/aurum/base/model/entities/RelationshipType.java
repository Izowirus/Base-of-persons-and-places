package com.aurum.base.model.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="relationshiptypes")
public class RelationshipType {

	@GeneratedValue
	@Id
	private Long id;
	private String type;
	private String typeSecond;
	
	@OneToMany(mappedBy="relationshipType")
	private Set<Relationship> relationshipSetType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Relationship> getRelationshipSetType() {
		return relationshipSetType;
	}

	public void setRelationshipSetType(Set<Relationship> relationshipSetType) {
		this.relationshipSetType = relationshipSetType;
	}

	public String getTypeSecond() {
		return typeSecond;
	}

	public void setTypeSecond(String typeSecond) {
		this.typeSecond = typeSecond;
	}
	
	
}
