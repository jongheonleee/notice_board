package com.example.notice_board.api;


import com.example.notice_board.dto.ArticleDTO;
import com.example.notice_board.dto.CommentDTO;
import com.example.notice_board.entity.Article;
import com.example.notice_board.service.ArticleService;
import com.example.notice_board.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;


    // CRUD

    // Create
    // 게시글 생성
    @PostMapping("/articles/api/create")
    public ResponseEntity<Article> create(@RequestBody ArticleDTO dto) {
        Article created = articleService.create(dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



    // Read
    // 1개 조회
    @GetMapping("/articles/api/{id}")
    public ResponseEntity<Article> show(@PathVariable Long id) {
        Article found = articleService.getById(id);

        return (found != null) ?
                ResponseEntity.status(HttpStatus.OK).body(found) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 모두 조회
    @GetMapping("/articles/api")
    public ResponseEntity<List<Article>> showAll() {
        List<Article> founds = articleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(founds);
    }

    // Update
    // 게시글 업데이트
    @PatchMapping("/articles/api/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                                          @RequestBody ArticleDTO dto) {
        Article updated = articleService.update(id, dto);

        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // Delete
    // 게시글 삭제
    @DeleteMapping("/articles/api/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article deleted = articleService.delete(id);

        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
