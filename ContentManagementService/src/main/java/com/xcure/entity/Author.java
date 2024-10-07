package com.xcure.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID authorId;
	
	private String name;
	
	private String bio;
	
	private String proilePicture;
	
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Article> articles;

	public Author() {
		super();
 	}

	public UUID getAuthorId() {
		return authorId;
	}

	public void setAuthorId(UUID authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProilePicture() {
		return proilePicture;
	}

	public void setProilePicture(String proilePicture) {
		this.proilePicture = proilePicture;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", bio=" + bio + ", proilePicture=" + proilePicture
				+ ", articles=" + articles + "]";
	}
	
	
}
