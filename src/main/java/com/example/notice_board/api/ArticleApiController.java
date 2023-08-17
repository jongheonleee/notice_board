package com.example.notice_board.api;


import com.example.notice_board.entity.Article;
import com.example.notice_board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;


    // CRUD

    // Create

    // Read
    // 1개 조회
    @GetMapping("/articles/api/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.getById(id);
    }

    // 모두 조회
    @GetMapping("/articles/api")
    public List<Article> showAll() {
        return articleService.getAll();
    }

    // Update

    // Delete


}
