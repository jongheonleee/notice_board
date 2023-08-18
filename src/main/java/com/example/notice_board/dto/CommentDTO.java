package com.example.notice_board.dto;


import com.example.notice_board.entity.Article;
import com.example.notice_board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CommentDTO {

    private Long id;
    private Long articleId;
    private String nickname;
    private String body;


    public static CommentDTO createCommentDTO(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}
