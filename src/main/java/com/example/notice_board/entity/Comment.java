package com.example.notice_board.entity;


import com.example.notice_board.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public void patch(CommentDTO dto) {
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("댓글 수정 실패");
        }

        if (dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }

        if (dto.getBody() != null) {
            this.body = dto.getBody();
        }
    }

    public static Comment createComment(Article article, CommentDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("댓글 생성 실패!, 댓글 id가 있으면 안됨");
        }

        if (dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 생성 실패!, 게시글의 id가 잘못됨");
        }

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody());
    }
}
