package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected Member() {
    }

    private Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Member createMember(Long id,String name) {
        return new Member(id,name);
    }

    public void updateName(String name){
        this.name = name;
    }
}
