package elektricna_mreza_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elektricna_mreza_servisi_impl.DomacinstvoServiceImpl;
import elektricna_mreza.Domacinstvo;


public class DomacinstvoTest {

	private static DomacinstvoServiceImpl service;
	
	 @BeforeClass
	   public static void initTest()
	   {
		   service=new DomacinstvoServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
	
	  //Preduslov:Ne postoji domacinstvo sa ID-jem 55
	   @Before
	   public void testPrecondition()
	   {
		   Domacinstvo d1=service.getDomacinstvo(55);
	       assertNull(d1);
		   System.out.println("Before: Preduslov");

	   }
	  
	   //Dodajemo domacinstvo sa ID-jem 1515
	   @Test
	   public void testAssertions() 
	   {	service.listAllDomacinstva();
		   Domacinstvo d = new Domacinstvo(3, "Janko", "Jankovic", "PP32");
		  service.addDomacinstvo(d);  
		   System.out.println("Test:izvrsen");

	   }
	   
	   //Post-uslov:Postoji domacinstvo sa ID-jem 1515
	   @After
	   public void testPostcondition()
	   {
		  Domacinstvo d1=service.getDomacinstvo(3);
	      assertNotNull(d1);
	      System.out.println("After: post-uslov");
	   }
	   
	   //Brisemo test podatke iz baze
	   @AfterClass
	   public static void clearTest()
	   {	
		   service.deleteDomacinstvo(service.getDomacinstvo(3).getIddomacinstva());
		   System.out.println("AfterClass:obrisani test podaci");

	   }
}
