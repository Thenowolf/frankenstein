package cz.denislokaj.frankenstein.common.dto;

import cz.denislokaj.frankenstein.common.enums.UserRole;

public interface UserEntityI {
	public String getName();
	public void setName(String name);
	public String getPassword();
	public void setPassword(String password);
	public UserRole getRole();
	public void setRole(UserRole role);
}
