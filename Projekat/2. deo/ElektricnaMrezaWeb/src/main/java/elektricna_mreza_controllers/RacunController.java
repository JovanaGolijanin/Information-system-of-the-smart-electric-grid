package elektricna_mreza_controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.lang.String;

import elektricna_mreza_servisi.RacunService;
import elektricna_mreza.Racun;

@ManagedBean
public class RacunController {
	
	
	private int id=0;
	private Racun racun=new Racun();
	private int sid=0;
	private String vremeIzdavanja="";
	private String rokZaPlacanje="";
	private int idstanja=0;
	private int iddomacinstva=0;
	@EJB
	private RacunService service;

	

	public boolean vidiIznosRacuna(int iddomacinstva,int idstanja)
	{
		return service.vidiIznosRacuna(iddomacinstva, idstanja);
	}
	public void pregledRacuna(int id)
	{
		service.pregledRacuna(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getVremeIzdavanja() {
		return vremeIzdavanja;
	}
	public void setVremeIzdavanja(String vremeIzdavanja) {
		this.vremeIzdavanja = vremeIzdavanja;
	}
	public String getRokZaPlacanje() {
		return rokZaPlacanje;
	}
	public void setRokZaPlacanje(String rokZaPlacanje) {
		this.rokZaPlacanje = rokZaPlacanje;
	}
	public int getIdstanja() {
		return idstanja;
	}
	public void setIdstanja(int idstanja) {
		this.idstanja = idstanja;
	}
	public int getIddomacinstva() {
		return iddomacinstva;
	}
	public void setIddomacinstva(int iddomacinstva) {
		this.iddomacinstva = iddomacinstva;
	}
	public RacunService getService() {
		return service;
	}
	public void setService(RacunService service) {
		this.service = service;
	}

}
