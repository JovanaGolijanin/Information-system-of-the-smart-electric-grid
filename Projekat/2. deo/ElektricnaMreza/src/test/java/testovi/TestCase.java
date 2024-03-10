package testovi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elektricna_mreza.Domacinstvo;
import elektricna_mreza_servisi_impl.DomacinstvoServiceImpl;

import static org.junit.Assert.*;

public class TestCase {

    private static DomacinstvoServiceImpl service;
	
   @BeforeClass
   public static void initTest()
   {
	   service=new DomacinstvoServiceImpl();
	   System.out.println("BeforeClass: Uspesno inicijalizovan test");
   }
	
  // !!!
  //Preduslov:Postoji domacinstvo sa id-jem 66 	
   @Before
   public void testPrecondition()
   {
	   Domacinstvo e1=service.getDomacinstvo(66);
       assertNotNull(e1);
	   System.out.println("Before: Preduslov");

   }
   
   //adresa domacinstva 66 se uspesno update-uje na 100
   @Test
   public void testAssertions() 
   {	//service.listAllStudents();
	  service.updateDomacinstvo(66, "100");  
	   System.out.println("Test:izvrsen");

   }
   
   //Post-uslov:Postoji domacinstvo sa id-jem 66 i sa adresom 100
   @After
   public void testPostcondition()
   {
	   Domacinstvo e1=service.getDomacinstvo(66);
	   assertEquals(e1.getAdresa(),"100");
      System.out.println("After: post-uslov");
   }
   
   //Brisemo test podatke iz baze
   @AfterClass
   public static void clearTest()
   {	
	   //service.deleteDomacinstvo(service.getDomacinstvo(66).getIddomacinstva());
	   System.out.println("AfterClass:obrisani test podaci");

   }
   
   
}

