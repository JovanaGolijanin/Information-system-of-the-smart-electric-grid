package elektricna_mreza_servisi_impl;

import elektricna_mreza_servisi.RacunService;
import elektricna_mreza.Stanje;
import elektricna_mreza.Racun;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Remote(RacunService.class)
public class RacunServiceImpl implements RacunService{

	public RacunServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("EmployeePU");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	@Override
	public boolean vidiIznosRacuna(int idRacuna,int idStanja) {
		Racun r=em.find(Racun.class,idRacuna);
		Stanje s=em.find(Stanje.class,idStanja);
		
		
		if(r!=null && s!=null) {
			
	
		
		double vrednostUNizojTarifi=s.getPotrosnja_u_nizoj_tarifi();
		double vrednostUVisojTarifi=s.getPotrosnja_u_visoj_tarifi();
		
		double cenaUNizojTarifi=r.getNizaTarifa();
		double cenaUVisojTarifi=r.getVisaTarifa();
		
		
				//		3				*		2		+		5				*		5
		double racun=vrednostUNizojTarifi*cenaUNizojTarifi+vrednostUVisojTarifi*cenaUVisojTarifi;
		//	3*2+5*5 
		//	6+25
		//	31
		
		System.out.println("iznos je :"+ racun);
		return true;
		}
		else {
			System.out.println("greska");
		
		return false ;
		}
	}
	
	@Override
	public void pregledRacuna(int idRacuna) {
		Racun r=em.find(Racun.class,idRacuna);
		System.out.println("Mesto izdavanja: "+r.getMesto_izdavanja()+r.getNizaTarifa()+r.getVisaTarifa()+r.getVreme_izdavanja());
	}
	
	@Override
	public Racun getRacun(int id) {
		Racun r = em.find(Racun.class,id);
		return r;
	}
	
}
