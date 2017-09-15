package com.aurum.base.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
	@GeneratedValue
    @Id
    private Long id;
	private String name;
	private String password;
	private String role;
	private String mail;
	
	@OneToMany (mappedBy="user",fetch=FetchType.EAGER)
	private Set<Person> person = new HashSet();
	
	@OneToMany (mappedBy="user",fetch=FetchType.EAGER)
	private Set<Place> place = new HashSet();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Set<Person> getPerson() {
		return person;
	}
	public void setPerson(Set<Person> person) {
		this.person = person;
	}
	public Set<Place> getPlace() {
		return place;
	}
	public void setPlace(Set<Place> place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role=" + role + ", mail=" + mail + "]";
	}
	
	

}
