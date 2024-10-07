package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Article;

public interface ContentRepository extends JpaRepository<Article, UUID> {

}
