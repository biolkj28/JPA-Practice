package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceCtxStateEx {

    // 영속 상태
    public void stateEx(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // 비영속
            Member member = Member.createMember(1L, "HelloA");

            //객체를 저장한 상태 (영속 상태)
            System.out.println("=== BEFORE(QUERY FLUSH?) ===");
            em.persist(member);
            System.out.println("=== AFTER(QUERY FLUSH?) ===");

            //영속성 컨텍스트에서 분리, 준영속 상태
            //em.detach(member);

            //트랜잭션 커밋 시 쿼리가 DB로 전송
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }


    /*
    * 한 트랜잭션에 영속성 컨텍스트 조회
    * 같은 인스턴스가 반환 된다(동일성 보장).
    */
    public void pcx1StepCacheEx(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = Member.createMember(101L, "HelloJpa");
            em.persist(member);

            Member findMember = em.find(Member.class, 101L);
            System.out.println(member+" == "+ findMember);
            System.out.println(member == findMember);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }



}
