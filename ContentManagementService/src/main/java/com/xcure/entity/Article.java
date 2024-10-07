package com.xcure.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID articleId;
	
	private String title;
	
	private String content;
	
	@ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	private Category category;
	
	private LocalDateTime publishedAt;
	
	private int viewCount;
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	private String tags;
	
	
	public Article() {
		super();
 	}

	public UUID getArticleId() {
		return articleId;
	}

	public void setArticleId(UUID articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", author=" + author
				+ ", category=" + category + ", publishedAt=" + publishedAt + ", viewCount=" + viewCount + ", comments="
				+ comments + ", tags=" + tags + "]";
	}

	public void setAuthor(Article author2) {
 		
	}
}
