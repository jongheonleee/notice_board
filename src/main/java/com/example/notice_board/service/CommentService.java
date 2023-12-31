package com.example.notice_board.service;


import com.example.notice_board.dto.CommentDTO;
import com.example.notice_board.entity.Article;
import com.example.notice_board.entity.Comment;
import com.example.notice_board.repository.ArticleRepository;
import com.example.notice_board.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class CommentService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    public CommentDTO create(Long articleId, CommentDTO dto) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패!, 대상 게시글이 없습니다!"));
        Comment created = Comment.createComment(article, dto);
        Comment saved = commentRepository.save(created);

        return CommentDTO.createCommentDTO(saved);

    }



    public List<CommentDTO> getByArticleId(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDTO.createCommentDTO(comment))
                .collect(Collectors.toList());

    }


    public CommentDTO update(Long id, CommentDTO dto) {
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!, 해당 댓글을 찾을 수 없습니다."));
        if (target.getId() == id) {
            target.patch(dto);
        }
        Comment updated = commentRepository.save(target);

        return CommentDTO.createCommentDTO(updated);

    }

    public CommentDTO delete(Long id) {
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패!, 해당 댓글을 찾지 못했습니다"));
        commentRepository.delete(target);

        return CommentDTO.createCommentDTO(target);

    }
}
