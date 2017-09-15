package com.aurum.base.webApp.dtos;

import org.hibernate.validator.constraints.NotBlank;

public class SearchDTO {
	@NotBlank
	private String nickToSearch;

	public String getNickToSearch() {
		return nickToSearch;
	}

	public void setNickToSearch(String nickToSearch) {
		this.nickToSearch = nickToSearch;
	}
	@NotBlank
	private String nameToSearch;

	public String getNameToSearch() {
		return nameToSearch;
	}

	public void setNameToSearch(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}
}
