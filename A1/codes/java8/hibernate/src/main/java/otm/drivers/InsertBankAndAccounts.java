package otm.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import otm.entities.Account;
import otm.entities.Bank;

public class InsertBankAndAccounts {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank b = new Bank();
		b.setName("CBI");
		b.setType("national");

		Account a1 = new Account();
		a1.setHolderName("Yatharth");
		a1.setAccountNumber(23792379);
		a1.setType("saving");

		Account a2 = new Account();
		a2.setHolderName("mallya");
		a2.setAccountNumber(563792379);
		a2.setType("current");

		List<Account> accounts = List.of(a1, a2);

		b.setAccounts(accounts);
		et.begin();
		for (Account a : accounts) {
			em.persist(a);
		}
		em.persist(b);
		et.commit();
	}
}
