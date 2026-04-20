package m2m.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import m2m.bi.entities.Trainer;

public class FetchTrainerSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		em.createQuery("Select t from Trainer t join fetch t.subjects"
				,Trainer.class)
		.getResultList()
		.forEach(t->{
			System.out.println("Trainer: "+t.getName()+"\nSubjects:");
			t.getSubjects()
				.forEach(s->{
					System.out.println(s.getName()+
							" Duration: "+s.getDuration());
				});
			System.out.println("---------------------------------------------");
		});
	}
}
