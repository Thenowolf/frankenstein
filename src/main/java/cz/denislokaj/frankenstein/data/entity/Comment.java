package cz.denislokaj.frankenstein.data.entity;

import cz.denislokaj.frankenstein.common.dto.CommentI;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Comment implements CommentI {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private UserEntity author;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserEntity getAuthor() {
		return author;
	}
	public void setAuthor(UserEntity author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
