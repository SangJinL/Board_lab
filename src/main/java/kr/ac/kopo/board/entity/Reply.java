package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntitiy{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    private String text;
    private String replyer;

    @ManyToOne(fetch = FetchType.LAZY) // LAZY 과부화를 방지 하기 위함
    private Board board;
    // 실제 reply 테이블에는 board_bno 컬럼이 생성 되고 FK(Board 테이블의 bno 컬럼값만 참조 하기 위해)가 생성됨
}
