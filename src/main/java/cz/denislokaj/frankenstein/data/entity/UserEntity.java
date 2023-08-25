package cz.denislokaj.frankenstein.data.entity;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
//@JsonIgnoreProperties("password")
public class UserEntity implements UserEntityI {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private UserRole role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
