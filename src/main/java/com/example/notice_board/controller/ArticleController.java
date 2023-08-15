package com.example.notice_board.controller;


import com.example.notice_board.entity.Article;
import com.example.notice_board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // get - 1. 한개 조회, 2. 모두 조회

    // 1. 1개 조회
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        Article article = articleService.getById(id);
        model.addAttribute("article", article);
        return "/articles/show";

    }

    // 2. 모두 조회
    @GetMapping("/articles")
    public String showAll(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "/articles/all";
    }
}
