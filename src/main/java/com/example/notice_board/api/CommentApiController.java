package com.example.notice_board.api;


import com.example.notice_board.dto.CommentDTO;
import com.example.notice_board.entity.Comment;
import com.example.notice_board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {

    @Autowired
    private CommentService commentService;

    // CRUD

    // 1. Create
    @PostMapping("/articles/api/{articleId}/comments")
    public ResponseEntity<CommentDTO> create(@PathVariable Long articleId,
                                          @RequestBody CommentDTO dto) {
        CommentDTO created = commentService.create(articleId, dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    // 2. Read

    // 게시글 id와 관련된 모든 댓글 가져오기
//    @GetMapping("/comments/{articleId}")
//    public List<Comment> getAllCommentByArticleId(@PathVariable Long articleId) {
//        List<Comment> comments = commentService.getAllByArticleId(articleId);
//        return "/";
//    }

    // 3. Update

    // 4. Delete

}
