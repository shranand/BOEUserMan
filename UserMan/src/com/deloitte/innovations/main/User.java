package com.deloitte.innovations.main;


import java.util.Arrays;
import java.util.List;



public class User {
	String name;
	String IDPName;
	String identity;
	List<String> roles;
	
	//HanaUserManager hum;
	
	public User(String name, String iDPName, String extIden, String roleList) {
		super();
		this.name = name;
		this.IDPName = iDPName;
		this.identity = extIden;
		this.roles=Arrays.asList(roleList.split("\\s*,\\s*"));
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIDPName() {
		return IDPName;
	}
	public void setIDPName(String iDPName) {
		IDPName = iDPName;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public void setRoles(String roles) {
		this.roles = Arrays.asList(roles.split("\\s*,\\s*"));
	}
	public void removeRole(int indexOf) {
		// TODO Auto-generated method stub
		roles.remove(indexOf);
		
	}
	

	

}
