package com.example.notice_board.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class QuoteDTO {
    private Long id;

    private String name;
    private String content;
}
