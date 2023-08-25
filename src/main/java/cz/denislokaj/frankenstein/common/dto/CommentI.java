package cz.denislokaj.frankenstein.common.dto;

import cz.denislokaj.frankenstein.data.entity.UserEntity;

public interface CommentI {
	public int getId();
	public void setId(int id);
	public UserEntity getAuthor();
	public void setAuthor(UserEntity author);
	public String getContent();
	public void setContent(String content);
}
