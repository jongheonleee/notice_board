package com.example.notice_board.repository;

import com.example.notice_board.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    List<Article> findAll();
}
