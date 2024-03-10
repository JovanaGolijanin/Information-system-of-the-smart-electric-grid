package testovi;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import elektricna_mreza.Stanje;
import elektricna_mreza_servisi_impl.StanjeServiceImpl;

public class TestStanje {

	public void test1()
	{
		EntityManager em;
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("EmployeePU");
		em=emf.createEntityManager();
		
		List <Stanje> svi=em.createQuery("SELECT e from Stanje e", Stanje.class).getResultList();
		assertNotNull(svi);
	}
	
	@Test
	   public void testAssertions() 
	   {
		   test1();
		   
		   StanjeServiceImpl service=new StanjeServiceImpl();
		   
		   //Da li stanje sa id-jem 1 ima Potrosnja_u_nizoj_tarifi 3 ?
		   Stanje s1=service.getStanje(1);
	       assertTrue(s1.getPotrosnja_u_nizoj_tarifi() == 3);
	       
	       //Da li stanje sa id-jem 1 ima Potrosnja_u_visoj_tarifi 5 ?
	       Stanje s2=service.getStanje(1);
	       assertTrue(s2.getPotrosnja_u_visoj_tarifi() == 5);
	       
	     }
	
	
}
