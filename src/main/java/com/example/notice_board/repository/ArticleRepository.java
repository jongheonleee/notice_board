package com.example.notice_board.repository;

import com.example.notice_board.dto.ArticleDTO;
import com.example.notice_board.dto.SearchCondDTO;
import com.example.notice_board.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    List<Article> findAll();


    List<ArticleDTO> findByTitle(String title);
}
