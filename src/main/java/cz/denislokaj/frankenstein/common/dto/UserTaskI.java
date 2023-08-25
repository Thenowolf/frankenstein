package cz.denislokaj.frankenstein.common.dto;

import java.util.List;

import cz.denislokaj.frankenstein.data.entity.Comment;

public interface UserTaskI {
	public int getId();
	public void setId(int id);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public List<Comment> getComments();
	public void setComments(List<Comment> comments);
}
