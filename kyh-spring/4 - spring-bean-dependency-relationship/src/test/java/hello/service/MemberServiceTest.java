package hello.service;

import hello.domain.Member;
import hello.repository.MemberRepository;
import hello.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemoryMemberRepository memberRepository;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");
        // when
        Long saveId = memberService.join(member);
        // then
        Member one = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(one.getName());
    }

    @Test
    void memberDuplicateOfName() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);
        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}