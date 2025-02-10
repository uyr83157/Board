package com.example.board.service;


import com.example.board.dto.BoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String content, String username) {

        Member findMember = memberRepository.findMemberByUserNameOrElseThrow(username);

        Board board = new Board(title, content);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContent());
    }
}
