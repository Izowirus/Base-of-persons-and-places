package com.aurum.base.webApp.dtos;

import java.util.Date;

import javax.validation.constraints.*;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class PersonDTO {

    @NotEmpty(message="Nick nie może być pusty")
    @Size(min=3, max=20)
    private String nick;

    @NotEmpty
    @Size(min=3)
    private String name;
    
    @NotEmpty
    @Size(min=3)
    private String surname;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private Date birthday;
    
    @Size(min=3, max=30)
    private String origin;
    
    @Min(0)
    private Integer age;
    
	@Size(min=3, max=20)
    private String skills;
	
    @Size(min=3, max=20)
    private String nickSecond;
    
	private String type;
    
    public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNickSecond() {
		return nickSecond;
	}

	public void setNickSecond(String nickSecond) {
		this.nickSecond = nickSecond;
	}
	
}
