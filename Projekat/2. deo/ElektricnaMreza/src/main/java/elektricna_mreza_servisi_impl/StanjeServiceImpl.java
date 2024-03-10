package elektricna_mreza_servisi_impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import elektricna_mreza.Stanje;
import elektricna_mreza_servisi.StanjeService;


@Stateless
@Remote(StanjeService.class)
public class StanjeServiceImpl implements StanjeService {
	public StanjeServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("EmployeePU");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	@Override
	public void vratiKolPotroseneEnergijeUVisojTarifi(int id) {
		Stanje s=em.find(Stanje.class,id);
		if(s==null)
		{
			System.out.println("greska");
		}
		else
		{
			System.out.println("visa tarifa"+s.getPotrosnja_u_visoj_tarifi());
		}
	}
	
	@Override
	public void vratiKolPotroseneEnergijeUNizojTarifi(int id) {
		Stanje s=em.find(Stanje.class,id);
		if(s==null) { System.out.println("greska");}
		else
		{		System.out.println("niza tarifa"+s.getPotrosnja_u_nizoj_tarifi());}
	}
	
	@Override
	public Stanje getStanje(int id) {
		Stanje s = em.find(Stanje.class,id);
		return s;
	}
	
	
	
	@Override
	public void saveStanje(Stanje st) {
		em.getTransaction().begin();
		em.persist(st);
		System.out.println("Stanje je dodato ");
		em.getTransaction().commit();
	}
	
	
	
	@Override
	public void createStanje(int idstanja,double nt, double vt) {
		em.getTransaction().begin();  //obavlja se transakcija
		Stanje st = new Stanje(idstanja,nt,vt);
		em.persist(st);  //odradjuje persistenciju odnosno trajno cuvanje poziva
		System.out.println("Stanje je dodato ");
        em.getTransaction().commit();
	}
	
	

}
