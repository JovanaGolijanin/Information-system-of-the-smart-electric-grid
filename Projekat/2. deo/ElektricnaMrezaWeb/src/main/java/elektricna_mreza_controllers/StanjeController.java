package elektricna_mreza_controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import elektricna_mreza_servisi.StanjeService;
import elektricna_mreza.Stanje;

@ManagedBean
public class StanjeController {

	private int id=0;
	private Stanje stanje=new Stanje();
	private int sid=0;
	private double potrosnja_u_visoj_tarifi=0;
	private double potrosnja_u_nizoj_tarifi=0;
	
	@EJB
	private StanjeService service;
	
	public void vratiKolPotroseneEnergijeUNizojTarifi(int id) {
		service.vratiKolPotroseneEnergijeUNizojTarifi(id);
	}
	public void vratiKolPotroseneEnergijeUVisojTarifi(int id) {
		service.vratiKolPotroseneEnergijeUVisojTarifi(id);
	}
	public void saveStanje(Stanje stanje)
	{
		service.saveStanje(stanje);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Stanje getStanje() {
		if(stanje==null) {stanje=new Stanje();}
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public double getPotrosnja_u_visoj_tarifi() {
		return potrosnja_u_visoj_tarifi;
	}
	public void setPotrosnja_u_visoj_tarifi(double potrosnja_u_visoj_tarifi) {
		this.potrosnja_u_visoj_tarifi = potrosnja_u_visoj_tarifi;
	}
	public double getPotrosnja_u_nizoj_tarifi() {
		return potrosnja_u_nizoj_tarifi;
	}
	public void setPotrosnja_u_nizoj_tarifi(double potrosnja_u_nizoj_tarifi) {
		this.potrosnja_u_nizoj_tarifi = potrosnja_u_nizoj_tarifi;
	}
	public StanjeService getService() {
		return service;
	}
	public void setService(StanjeService service) {
		this.service = service;
	}

}
