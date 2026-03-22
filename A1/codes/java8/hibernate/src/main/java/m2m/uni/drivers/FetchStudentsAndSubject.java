package m2m.uni.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student2;
import m2m.uni.entities.Subject;

public class FetchStudentsAndSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf 
		= Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		
		List<Student2> students=
				em.createQuery("Select s from Student2 s")
				.getResultList();
		if (!students.isEmpty()) {
			students.stream()
			.forEach(student->{
				System.out.println("\nId: "+student.getId()
				+"\nName: "+student.getName()
				+"\nGender: "+student.getGender()
				+"\nMobile: "+student.getMobile());
					
				List<Subject> subjects 
				= student.getSubjects();
				
				if (!subjects.isEmpty()) {
					System.out.println("\nSubjects taken by "
							+student.getName()+": ");
					
					subjects.stream()
					.forEach(subject->{
						System.out.println("\nId: "+subject.getId()
						+"\nName: "+subject.getName()
						+"\nCredits: "+subject.getCredits());
					});
				}
				else {
					System.err.println(student.getName()
					+"does'nt registered for any subject!!");
				}
			});
		}
		else {
			System.err.println("Students not found");
		}
		
	}
}
