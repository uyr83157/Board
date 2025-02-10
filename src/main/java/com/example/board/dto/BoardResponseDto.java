package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private final long id;
    private final String title;
    private final String content;

    public BoardResponseDto(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContent());
    }
}
