package m2m.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student;
import m2m.uni.entities.Subject;

import java.util.List;

public class InsertStudentSubject {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "many_to_many");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student s1 = new Student();
        s1.setName("John");
        s1.setAge(23);

        Student s2 = new Student();
        s2.setName("Bob");
        s2.setAge(21);

        Subject sub1 = new Subject();
        sub1.setName("Maths");
        sub1.setCredits(4);

        Subject sub2 = new Subject();
        sub2.setName("Python");
        sub2.setCredits(3);

        //many to many unidirectional mapping
        List<Subject> subjects = List.of(sub1, sub2);

        s1.setSubjects(subjects);
        s2.setSubjects(subjects);

        try{
            et.begin();
                em.persist(s1);
                em.persist(s2);
                subjects.forEach(em::persist);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
