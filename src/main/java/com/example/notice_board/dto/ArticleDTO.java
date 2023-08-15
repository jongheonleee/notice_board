package com.example.notice_board.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDTO {

    private Long id;
    private String title;
    private String content;
}
