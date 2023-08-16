package com.example.notice_board.controller;


import com.example.notice_board.dto.ArticleDTO;
import com.example.notice_board.entity.Article;
import com.example.notice_board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // CRUD

    // Create(생성) - 1. 게시글 생성

    // 생성 페이지로 이동
    @GetMapping("/articles/new")
    public String showArticleForm() {
        return "/articles/new";
    }

    // 게시글 생성
    @PostMapping("/articles/create")
    public String createArticle(@ModelAttribute ArticleDTO dto) {
        Article created = articleService.create(dto);
        // 상세 페이지로 반환해주기
        return "redirect:/articles/" + created.getId();
    }



    // Read(조회) - 1. 한개 조회, 2. 모두 조회

    // 1. 1개 조회
    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        Article article = articleService.getById(id);
        model.addAttribute("article", article);
        return "/articles/show";

    }

    // 2. 모두 조회
    @GetMapping("/articles")
    public String showAllArticles(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "/articles/all";
    }




}
