package hello.repository;

import hello.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequecne = 0L;
    
    @Override
    public Member save(Member member) {
        member.setId(++sequecne);
        store.put(member.getId(), member);
        return member;
    }
    
    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }
    
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    
    public void clearStore() {
        store.clear();
    }
}
