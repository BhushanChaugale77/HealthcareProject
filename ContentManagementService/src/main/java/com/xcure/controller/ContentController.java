package com.xcure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcure.entity.Article;
import com.xcure.service.ContentServiceInterface;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/article")
public class ContentController {

	@Autowired
	private ContentServiceInterface serviceInterface;

	@GetMapping("/{id}")
	public ResponseEntity<Article> findArticleById(@PathVariable UUID articleId) {

		return new ResponseEntity<Article>(serviceInterface.findArticleById(articleId), HttpStatus.FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Article>> allArticle() {
		return new ResponseEntity<List<Article>>(serviceInterface.allArticle(), HttpStatus.FOUND);
	}

 @PostMapping 
	public ResponseEntity<Object> createArticle(@Valid @RequestBody Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<Object, Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError) error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
		}
		
		try {
	        Article createdArticle = serviceInterface.createArticle(article);
	        return ResponseEntity.ok(createdArticle);
	    } catch (EntityNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body("Author not found: " + ex.getMessage());
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("Error creating article: " + ex.getMessage());
	    }

 	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> updateArticleById(@Valid @PathVariable UUID articleId, @RequestBody Article article,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<Object, Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError) error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Article>(serviceInterface.updateArticleById(articleId, article),
				HttpStatus.UPGRADE_REQUIRED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Article> patchArticleById(@Valid @PathVariable UUID articleId, @RequestBody Article article,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<Object, Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError) error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Article>(serviceInterface.patchArticleById(articleId, article),
				HttpStatus.UPGRADE_REQUIRED);
	}

	@GetMapping
	public ResponseEntity<Page<Article>> paginationArticle(@RequestParam int page, @RequestParam int size) {
		return new ResponseEntity<Page<Article>>(serviceInterface.paginationArticle(page, size), HttpStatus.OK);
	}
}
