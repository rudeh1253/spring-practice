package hello.repository;

import hello.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    private final EntityManager entityManager;

    @Autowired
    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> resultList = entityManager.createQuery("SELECT m FROM Member AS m " +
                "WHERE m.name = :name")
                .setParameter("name", name)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT m FROM Member AS m";
        List<Member> resultList = entityManager.createQuery(sql, Member.class).getResultList();
        return resultList;
    }
}
