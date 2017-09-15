package com.aurum.base.webApp.dtos;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

public class PlaceDTO {

    @NotEmpty(message="Nazwa nie może być pusta")
    @Size(min=3, max=20)
    private String name;

    @NotEmpty
    @Size(min=3)
    private String size;
    
    @NotEmpty
    @Size(min=3)
    private String industry;
    
    @Size(min=3)
    private String politics;

	@Size(min=3)
    private String culture;

	@Size(min=3)
    private String fauna;

	@Size(min=3)
    private String flora;

	@Size(min=3)
    private String military;

	@Size(min=3)
    private String description;

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
	

}
