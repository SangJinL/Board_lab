package kr.ac.kopo.board.repository.search;

import kr.ac.kopo.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {
    Board search1();


    Page<Object[]> seachPage(String type, String keyword, Pageable pageable);
}
