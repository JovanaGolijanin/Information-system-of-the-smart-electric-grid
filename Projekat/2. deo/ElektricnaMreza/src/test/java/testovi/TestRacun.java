package testovi;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import elektricna_mreza.Racun;
import elektricna_mreza_servisi_impl.RacunServiceImpl;
//
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
//
public class TestRacun {

	public void test1()
	{
		EntityManager em;
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("EmployeePU");
		em=emf.createEntityManager();
		
		List <Racun> svi=em.createQuery("SELECT e from Racun e", Racun.class).getResultList();
		assertNotNull(svi);
	}
	
	 @Test
	   public void testAssertions() 
	   {
		   test1();
		   
		   RacunServiceImpl service=new RacunServiceImpl();
		  
		   //Da li racun sa id-jem 1 ima mesto izdavanja nis ?
		   Racun r1=service.getRacun(1);
	       assertEquals(r1.getMesto_izdavanja(),"nis");
	      
	       //Da li racun sa id-jem 1 ima NizaTarifu 2 ?
	       Racun r2=service.getRacun(1);
	       assertTrue(r2.getNizaTarifa() == 2.0);
	       
	       //Da li racun sa id-jem 1 ima VisaTarifu 5 ?
	       Racun r3=service.getRacun(1);
	       assertTrue(r3.getVisaTarifa() == 5.0);
	       
	      //Da li racun sa id-jem 1 ima Rok_za_placanje 2008-10-03 ?
	       Racun r4=service.getRacun(1);
	       
	       Date date = Calendar.getInstance().getTime();  
           DateFormat dateFormat = new SimpleDateFormat(r4.getRok_za_placanje());  
           String strDate = dateFormat.format(date); 
           String pom;
           pom = strDate;
	       
	       assertEquals(strDate, pom);
	       
	       //Da li racun sa id-jem 1 ima Vreme_izdavanja 2008-10-03 ?
	       Racun r5=service.getRacun(1);
	       
	       Date date1 = Calendar.getInstance().getTime();  
           DateFormat dateFormat1 = new SimpleDateFormat(r5.getVreme_izdavanja());  
           String strDate1 = dateFormat1.format(date1); 
           String pom1;
           pom1 = strDate1;
	       
	       assertEquals(strDate1, pom1);
	       
		   
	       
	     }
}
