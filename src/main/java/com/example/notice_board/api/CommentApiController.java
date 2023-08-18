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

    // 1. Create : 댓글 생성 기능
    @PostMapping("/articles/api/{articleId}/comments")
    public ResponseEntity<CommentDTO> create(@PathVariable Long articleId,
                                             @RequestBody CommentDTO dto) {
        CommentDTO created = commentService.create(articleId, dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    // 2. Read : 댓글 조회 기능
    @GetMapping("/articles/api/{articleId}/comments")
    public ResponseEntity<List<CommentDTO>> showAllCommentOnArticleId(
            @PathVariable Long articleId
    ) {
        List<CommentDTO> comments = commentService.getByArticleId(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }


    // 3. Update
    @PatchMapping("/comments/api/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id, @RequestBody CommentDTO dto) {
        CommentDTO updated = commentService.update(id, dto);

        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    // 4. Delete
    @DeleteMapping("/comments/api/{id}")
    public ResponseEntity<CommentDTO> delete(@PathVariable Long id) {
        CommentDTO deleted = commentService.delete(id);

        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
