package com.aurum.base.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;
@Entity
@Table(name = "places", uniqueConstraints = {
@UniqueConstraint(columnNames = "name")})
public class Place {

	@GeneratedValue
    @Id
    private Long id;
	@Column(name = "name", unique=true)
	private String name;
	private String size;
	@Type(type = "text")
	private String industry;
	@Type(type = "text")
	private String politics;
	@Type(type = "text")
	private String culture;
	@Type(type = "text")
	private String fauna;
	@Type(type = "text")
	private String flora;
	@Type(type = "text")
	private String military;
	@Type(type = "text")
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", size=" + size + ", industry=" + industry + ", politics="
				+ politics + ", culture=" + culture + ", fauna=" + fauna + ", flora=" + flora + ", military=" + military
				+ ", description=" + description + "]";
	}
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getPolitics() {
		return politics;
	}
	public void setPolitics(String politics) {
		this.politics = politics;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getFauna() {
		return fauna;
	}
	public void setFauna(String fauna) {
		this.fauna = fauna;
	}
	public String getFlora() {
		return flora;
	}
	public void setFlora(String flora) {
		this.flora = flora;
	}
	public String getMilitary() {
		return military;
	}
	public void setMilitary(String military) {
		this.military = military;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((culture == null) ? 0 : culture.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fauna == null) ? 0 : fauna.hashCode());
		result = prime * result + ((flora == null) ? 0 : flora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((military == null) ? 0 : military.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((politics == null) ? 0 : politics.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (culture == null) {
			if (other.culture != null)
				return false;
		} else if (!culture.equals(other.culture))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fauna == null) {
			if (other.fauna != null)
				return false;
		} else if (!fauna.equals(other.fauna))
			return false;
		if (flora == null) {
			if (other.flora != null)
				return false;
		} else if (!flora.equals(other.flora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (industry == null) {
			if (other.industry != null)
				return false;
		} else if (!industry.equals(other.industry))
			return false;
		if (military == null) {
			if (other.military != null)
				return false;
		} else if (!military.equals(other.military))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (politics == null) {
			if (other.politics != null)
				return false;
		} else if (!politics.equals(other.politics))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
	
	
	
	
	
}
