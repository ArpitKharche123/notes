package o2m.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2m.entities.Bank;

public class FetchBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		List<Bank> banks = 
			em.createQuery("Select b from Bank b "
					+ "join fetch b.accounts",Bank.class)
			.getResultList();
		//join fetch is used to avoid N+1 query problem
		
		banks.forEach(b->{
			System.out.println("Bank name: "+b.getName());
			System.out.println("Holder: ");
			b.getAccounts()
				.forEach(a->{
					System.out.println(a.getHolderName());
				});
			System.out.println("------------------");
		});
	}
}
