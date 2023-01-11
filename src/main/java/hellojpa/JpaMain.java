package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();

//        try {
            //Member findMember = em.find(Member.class, 1L);
            //System.out.println("findMember Id = " + findMember.getId());
            //System.out.println("findMember Name= " + findMember.getName());

            //JPQL(객체 지향 쿼리) 전체 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            //저장 em.persist(Entity object)
            //삭제 em.remove(Entity object)
            /*
            수정 JPA를 통해 객체를 가져오면, JPA가 관리 함 그리고, 변경 감지를 통해 변화된 내용을 확인하여
            update set 쿼리를 날림
             */

//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            //엔티티 매니저가 DB Connection 물고 동작함으로 꼭 닫아줘야 한다.
//            em.close(); // db connection 반환
//        }
//
//        emf.close(); // 자원 반환
        PersistenceCtxStateEx pcs = new PersistenceCtxStateEx();
        /*
        * 영속 상태 설명
        * pcs.stateEx();
        */

        pcs.pcx1StepCacheEx();
    }
}
