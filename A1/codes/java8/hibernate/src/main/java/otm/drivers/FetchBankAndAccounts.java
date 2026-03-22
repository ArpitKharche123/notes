package otm.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import otm.entities.Account;
import otm.entities.Bank;

public class FetchBankAndAccounts {
	public static void main(String[] args) {
		EntityManagerFactory emf 
		= Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		
		Bank bank=em.find(Bank.class, 1);
		if (bank!=null) {
			System.out.println(bank);
			
			List<Account> accounts 
			= bank.getAccounts();
			if (!accounts.isEmpty()) {
				accounts.stream()
				.forEach(System.out::println);
			}else {
				System.err.println("Account not found");
			}
		}else {
			System.err.println("bank not found");
		}
	}
}
