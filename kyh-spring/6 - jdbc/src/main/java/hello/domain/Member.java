package hello.domain;

import jakarta.persistence.*;

@Entity

public class Member {
    @Id
    // DB가 알아서 생성해 주는 게 IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
