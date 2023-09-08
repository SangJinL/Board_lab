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


//즉각 로딩 방식은 기본 설정 무조건 모든 관계에 대해 Join을 하기 때문에
//불필요한 조인이 발생한다.
//데이터의 양이 많을 시 즉각 로딩 방식을 사용했을때 실행시간이 오래 걸린다.
    @ManyToOne(fetch = FetchType.LAZY) //지연(LAZY) 로딩 방식 설정
    private Member writer;
    // 실제 board 테이블에는 writer_email 컬럼이 생성 되고 FK(Member 테이블의 email값만 참조 하기 위해)가 생성됨

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }



}
