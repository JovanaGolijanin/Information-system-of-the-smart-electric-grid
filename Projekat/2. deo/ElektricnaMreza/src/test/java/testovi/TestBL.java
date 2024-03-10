package testovi;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import elektricna_mreza.Domacinstvo;
import elektricna_mreza_servisi_impl.DomacinstvoServiceImpl;

public class TestBL {

	public void test1()
	{
		EntityManager em;
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("EmployeePU");
		em=emf.createEntityManager();
		
		List <Domacinstvo> svi=em.createQuery("SELECT e from Domacinstvo e", Domacinstvo.class).getResultList();
		assertNotNull(svi);
	}
	
   @Test
   public void testAssertions() 
   {
	   test1();
	   
	   
	   DomacinstvoServiceImpl service=new DomacinstvoServiceImpl();
	   
	   //f-ja koja nije @Override-ovana iz DomacinstvoServiceImpl
	   
	   //Da li vraca nesto funkcija koja lista domacinstva?
	   List <Domacinstvo> sva=service.returnAllDomacinstva();
       assertNotNull(sva);
       
       //getter-i iz klase Domacinstvo
       
       //Da li domacinstvo sa id-jem 1 ima ime Pera?
       Domacinstvo d1=service.getDomacinstvo(1);
       assertEquals(d1.getIme(),"Pera");
       
       //Da li domacinstvo sa id-jem 1 ima prezime Peric?
       Domacinstvo d2=service.getDomacinstvo(1);
       assertEquals(d2.getPrezime(),"Peric");

       //Da li domacinstvo sa id-jem 1 ima adresu 55?
       Domacinstvo d3=service.getDomacinstvo(1);
       assertEquals(d3.getAdresa(),"55");
       
       //Da li domacinstvo sa id-jem 1 ima isto ime kao domacinstvo sa id-jem 2 ?
       Domacinstvo d4=service.getDomacinstvo(1);
       Domacinstvo d5=service.getDomacinstvo(2);
       assertNotSame(d4.getIme(), d5.getIme());
       
       //Da li se adresa domacinstva 3 uspesno update-uje
       service.updateDomacinstvo(3, "58");
       Domacinstvo d6=service.getDomacinstvo(3);
       assertEquals(d6.getAdresa(),"58");
       
       //find
       service.findDomacinstvo(1);
       
       
       //obrisi domacinstvo sa id-jem 4
       //PRETHODNO KREIRAJ
       
       //service.deleteDomacinstvo(4);
       
     
       
     }
   
   	  

 }


