package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.entity.Article;
import com.xcure.entity.Author;
import com.xcure.repository.ContentRepository;
import com.xcure.service.ContentServiceInterface;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContentServiceImpl implements ContentServiceInterface {

	@Autowired
	private ContentRepository repository;

	@Override
	public Article findArticleById(UUID articleId) {
 		return repository.findById(articleId).orElseThrow();
	}

	@Override
	public List<Article> allArticle() {
 		return repository.findAll();
	}

	@Override
	public Article createArticle(Article article) {
	    UUID authorId = article.getAuthor().getAuthorId();
	    Article author = repository.findById(authorId)
	        .orElseThrow(() -> new EntityNotFoundException("Author with ID " + authorId + " not found"));
	    
	    article.setAuthor(author);
	    return repository.save(article);
	}

	@Override
	public void deleteArticleById(UUID articleId) {
		repository.deleteById(articleId);
		
	}

	@Override
	public Article updateArticleById(UUID articleId, Article article) {
 		return repository.saveAndFlush(article);
	}

	@Override
	public Article patchArticleById(UUID ArticleId, Article article) {
 		return repository.save(article);
	}

	@Override
	public Page<Article> paginationArticle(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
}
