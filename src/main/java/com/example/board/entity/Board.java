package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board() {
    }

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
