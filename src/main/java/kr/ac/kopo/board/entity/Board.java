package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Board extends BaseEntitiy{

// 기본키(Primary-key), bno 자동 증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;

    @ManyToOne
    private Member writer;
    // 실제 board 테이블에는 writer_email 컬럼이 생성 되고 FK(Member 테이블의 email값만 참조 하기 위해)가 생성됨
}
