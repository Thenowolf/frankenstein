package cz.denislokaj.frankenstein.data.entity;

import jakarta.persistence.Id;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class UserEntity implements UserEntityI {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	private UserRole role;
	
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
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
}
