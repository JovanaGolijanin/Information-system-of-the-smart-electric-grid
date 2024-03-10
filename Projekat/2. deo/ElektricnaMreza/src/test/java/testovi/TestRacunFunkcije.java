package testovi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elektricna_mreza.Racun;
import elektricna_mreza_servisi_impl.RacunServiceImpl;

import static org.junit.Assert.*;

public class TestRacunFunkcije {

    private static RacunServiceImpl service;
    
    @BeforeClass
    public static void initTest()
    {
 	   service=new RacunServiceImpl();
 	   System.out.println("BeforeClass: Uspesno inicijalizovan test");
    }
    

    //Preduslov:Postoji racun sa id-jem 1	
    //getRacun
     @Before
     public void testPrecondition()
     {
    	 Racun r1=service.getRacun(1);
         assertNotNull(r1);
  	   System.out.println("Before: Preduslov");

     }
     
/*     
   //stampa racun
     @Test
     public void testAssertions() 
     {	
  	  service.pregledRacuna(1); 
  	   System.out.println("Test:izvrsen");

     }
*/
     
   //stampa iznos racuna
     @Test
     public void testAssertions() 
     {	
  	  service.vidiIznosRacuna(1,1); 
  	   System.out.println("Test:izvrsen");

     }
     
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
