package elektricna_mreza_servisi_impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import elektricna_mreza.Domacinstvo;
import elektricna_mreza_servisi.DomacinstvoService;


@Stateless
@Remote(DomacinstvoService.class)
public class DomacinstvoServiceImpl implements DomacinstvoService {

	public DomacinstvoServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("EmployeePU");
	       em = emf.createEntityManager();
	}
	private EntityManager em;
	
	@Override
	public void addDomacinstvo(Domacinstvo dom) {
		em.getTransaction().begin();
		em.persist(dom);
		System.out.println("Domacinstvo je dodato ");
		em.getTransaction().commit();
	}
	
	@Override
	public void createDomacinstvo(int iddomacinstva,String ime,String prezime,String adresa) {
		em.getTransaction().begin();  //obavlja se transakcija
		Domacinstvo dom = new Domacinstvo(iddomacinstva,ime,prezime,adresa);
		em.persist(dom);  //odradjuje persistenciju odnosno trajno cuvanje poziva
		System.out.println("Domacinstvo je dodato ");
        em.getTransaction().commit();
	}
	
	@Override
	public Domacinstvo getDomacinstvo(int id) {
		Domacinstvo d = em.find(Domacinstvo.class,id);
		return d;
	}
		  
	  @Override
	  public Domacinstvo findDomacinstvo(int iddomacinstva) {
			 TypedQuery<Domacinstvo> query = em.createQuery("SELECT e FROM Domacinstvo e WHERE e.iddomacinstva=" + iddomacinstva, Domacinstvo.class);
			 Domacinstvo sva = query.getSingleResult();
		    return sva;
		}
	
	@Override
	public void deleteDomacinstvo(int id) {
		
		Domacinstvo d = em.find(Domacinstvo.class,id);
		em.getTransaction().begin();
		em.remove(d);
		System.out.println("Izabrano domacinstvo je obrisano!");
		em.getTransaction().commit();
	}
	
	
	@Override
	public void updateDomacinstvo(int id,String adresa) {
		
		Domacinstvo d = em.find(Domacinstvo.class,id);
		em.getTransaction().begin();
		d.setAdresa(adresa);
		System.out.println("Izabrano domacinstvo je azurirano!");
		em.getTransaction().commit();
		
	}
	
	
	@Override
	public String listAllDomacinstva() {
		String rezultat="";
		TypedQuery<Domacinstvo> query = em.createQuery("SELECT e FROM Domacinstvo e", Domacinstvo.class);
        List<Domacinstvo> domacinstva = query.getResultList();  //izvrsava se query
        
        for (Domacinstvo e1: domacinstva) {
     	   rezultat="ID:"+e1.getIddomacinstva()+", "+"Ime: "+e1.getIme()+", Prezime: "+e1.getPrezime()+", Adresa: "+e1.getAdresa()+"\n";
        }
        return rezultat;
	}
	
	  public List<Domacinstvo> returnAllDomacinstva()
	    {
	      
	        TypedQuery<Domacinstvo> query = em.createQuery("SELECT e FROM Domacinstvo e", Domacinstvo.class);
	        List<Domacinstvo> domacinstvaSva = query.getResultList();
	        return domacinstvaSva;
	     
	   }
	
}
