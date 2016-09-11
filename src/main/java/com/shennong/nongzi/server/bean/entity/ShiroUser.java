package com.shennong.nongzi.server.bean.entity;

import java.io.Serializable;

public class ShiroUser implements Serializable{

	private static final long serialVersionUID = -6597853935518828614L;

	private Integer id;

	private String username;
	
	private Integer userId;

	private Integer type;

	public ShiroUser(Integer id, String username, Integer type) {
		this.id = id;
		this.username = username;
		this.type = type;
	}
	
	public ShiroUser(Integer id,String userName,Integer userId,Integer type){
		this.id=id;
		this.username=userName;
		this.userId=userId;
		this.type=type;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ShiroUser other = (ShiroUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
