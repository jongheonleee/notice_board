package com.example.notice_board.service;

import com.example.notice_board.dto.ArticleDTO;
import com.example.notice_board.dto.SearchCondDTO;
import com.example.notice_board.entity.Article;
import com.example.notice_board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
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

    public Article create(ArticleDTO dto) {
        Article article = dto.toEntity();
        Article saved = articleRepository.save(article);
        return saved;
    }

    public Article update(Long id, ArticleDTO dto) {
        Article target = articleRepository.findById(id).orElse(null);
        Article update = dto.toEntity();
        if (target != null)  {
            target.patch(update);
        }
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        articleRepository.deleteById(id);
        return target;
    }

    public List<ArticleDTO> getBySearchCond(SearchCondDTO dto) {
        List<ArticleDTO> targets = articleRepository.findByTitle(dto.getTitle());
        return targets;
    }
}
