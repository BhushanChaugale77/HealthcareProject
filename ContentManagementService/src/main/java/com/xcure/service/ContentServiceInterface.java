package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.entity.Article;

public interface ContentServiceInterface {

	
	Article findArticleById(UUID articleId);
	
	List<Article> allArticle();
	
	Article createArticle(Article article);
	
	void deleteArticleById(UUID articleId);
	
	Article updateArticleById(UUID articleId, Article article);
	
	Article patchArticleById(UUID ArticleId, Article article);
	
	Page<Article> paginationArticle(int page, int size);
}
