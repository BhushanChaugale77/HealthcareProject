package com.xcure.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID likeId;
	
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article; 
	
	private String userName;
	
	private boolean isLike;

	public Comment() {
		super();
 	}

	public UUID getLikeId() {
		return likeId;
	}

	public void setLikeId(UUID likeId) {
		this.likeId = likeId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	@Override
	public String toString() {
		return "Comment [likeId=" + likeId + ", article=" + article + ", userName=" + userName + ", isLike=" + isLike
				+ "]";
	}
}