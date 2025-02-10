package com.example.board.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    private String title;
    private String content;
    private String username;

    public CreateBoardRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }


}
