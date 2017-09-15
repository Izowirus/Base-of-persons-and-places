package com.aurum.base.webApp.dtos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RelationshipDTO {

    @Size(min=3, max=20)
    private String nick;
    
    @NotEmpty
    @Size(min=3, max=20)
    private String nickSecond;
    
    @NotEmpty
    @Size(min=3)
    private String type;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNickSecond() {
		return nickSecond;
	}

	public void setNickSecond(String nickSecond) {
		this.nickSecond = nickSecond;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    
    
}
