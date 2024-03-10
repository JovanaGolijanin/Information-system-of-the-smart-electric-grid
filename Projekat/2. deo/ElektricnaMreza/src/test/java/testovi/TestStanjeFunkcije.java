package testovi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elektricna_mreza.Stanje;
import elektricna_mreza_servisi_impl.StanjeServiceImpl;

import static org.junit.Assert.*;

public class TestStanjeFunkcije {
	
	private static StanjeServiceImpl service;
	
	 @BeforeClass
	   public static void initTest()
	   {
		   service=new StanjeServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
	 
	  // !!!
	  //Preduslov:Postoji stanje sa id-jem 1 	
	   @Before
	   public void testPrecondition()
	   {
		   Stanje e1=service.getStanje(1);
	       assertNotNull(e1);
		   System.out.println("Before: Preduslov");

	   }
	   
	   // visa tarifa = 5
	   @Test
	   public void testAssertions() 
	   {	
		  service.vratiKolPotroseneEnergijeUVisojTarifi(1);  
		   System.out.println("Test:izvrsen");

	   }
	   
	   
	   /*
	   // niza tarifa = 3
	   @Test
	   public void testAssertions() 
	   {	
		  service.vratiKolPotroseneEnergijeUNizojTarifi(1);  
		   System.out.println("Test:izvrsen");

	   }
	 */

	   
	   @After
	     public void testPostcondition()
	     {
	        System.out.println("After: post-uslov");
	     }
	     
	     @AfterClass
	     public static void clearTest()
	     {	
	  	   System.out.println("AfterClass:prikazan rezultat");

	     }
}
