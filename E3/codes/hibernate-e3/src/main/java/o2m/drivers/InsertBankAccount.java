package o2m.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m.entities.Account;
import o2m.entities.Bank;

public class InsertBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Bank bank1=new Bank();
		bank1.setName("CBI");
		bank1.setBranch("Wakad");
		bank1.setAddress("Pune");
		
		Bank bank2=new Bank();
		bank2.setName("SBI");
		bank2.setBranch("Hinjewadi phase 1");
		bank2.setAddress("Pune");
		
		Account a1=new Account();
		a1.setAccountNo(92893646737l);
		a1.setHolderName("Raju");
		a1.setType("Current");
		
		Account a2=new Account();
		a2.setAccountNo(928936463437l);
		a2.setHolderName("Pranav");
		a2.setType("Saving");
		
		Account a3=new Account();
		a3.setAccountNo(94893646737l);
		a3.setHolderName("Sanket");
		a3.setType("Current");
		
		Account a4=new Account();
		a4.setAccountNo(92893646737l);
		a4.setHolderName("Shweta");
		a4.setType("Saving");
		
		Account a5=new Account();
		a5.setAccountNo(92899946737l);
		a5.setHolderName("Shreta");
		a5.setType("Current");
		
		bank1.setAccounts(List.of(a1,a2));
		bank2.setAccounts(List.of(a3,a4,a5));
		
		et.begin();
			em.persist(bank1);
			em.persist(bank2);
			
			for(Account a:List.of(a1,a2,a3,a4,a5)) {
				em.persist(a);
			}
		et.commit();
	}
}
