package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * Metodo Transaction serve para iniciar uma o JPA uma transação no banco de dados 
		 */
		
		Pessoa p = em.find(Pessoa.class,2);
		
		System.out.println(p);
		
		Pessoa p1 = em.find(Pessoa.class, 3);
		em.getTransaction().begin();
		em.remove(p1);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
		
		

	
	}
}
