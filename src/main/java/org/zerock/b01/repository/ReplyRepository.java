package org.zerock.b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

    @Query("select r from Reply r where r.place.bno = :bno")
    Page<Reply> listOfPlace(Long bno, Pageable pageable);

    void deleteByBoard_Bno(Long bno);
    void deleteByPlace_Bno(Long bno);
}
