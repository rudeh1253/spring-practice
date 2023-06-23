package hello.service;

import hello.domain.Member;
import hello.repository.MemberRepository;
import hello.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateOfName(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    private void validateDuplicateOfName(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent((m) -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
    }
    
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
