package com.example.board.repository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUserName(String userName);

    default Member findMemberByUserNameOrElseThrow(String userName) {
        return findMemberByUserName(userName)
                .orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userName));
    }


    default Member findByIdOrElseThrow(long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
