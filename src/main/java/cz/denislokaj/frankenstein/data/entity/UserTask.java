package cz.denislokaj.frankenstein.data.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cz.denislokaj.frankenstein.common.dto.UserTaskI;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class UserTask implements UserTaskI {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name="task_comments")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Comment> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
