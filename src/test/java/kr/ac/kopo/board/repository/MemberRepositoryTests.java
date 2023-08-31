package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers(){
            // 반복문 1~100까지 i를 1씩 증가 시키 면서 100번 반복함
        IntStream.rangeClosed(1, 100).forEach(i->{
            Member member = Member.builder()
                    .email("user"+i +"@kopo.ac.kr")
                    .password("1111")
                    .name("USER"+i)
                    .build();
            //Member에 초기화를 시켜 객체 생성을 하고 그 값을 member 참조변수에 대입
            //위에 Member 객체를 member 테이블에 insert(데이터행 삽임)하는 코드
            memberRepository.save(member);
        });
    }
}
