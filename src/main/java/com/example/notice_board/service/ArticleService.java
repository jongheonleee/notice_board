package com.example.notice_board.service;

import com.example.notice_board.entity.Article;
import com.example.notice_board.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    public Article getById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        return article;
    }

    public List<Article> getAll() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }
}