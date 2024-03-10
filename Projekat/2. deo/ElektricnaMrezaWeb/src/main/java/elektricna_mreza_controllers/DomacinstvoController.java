package elektricna_mreza_controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.lang.String;

import elektricna_mreza_servisi.DomacinstvoService;
import elektricna_mreza.Domacinstvo;

/*ManagedBean predstavlja model i spregu sa kontrolerom za našu MVC JSF aplikaciju. Ovakva klasa se 
definiše dovanjem @ManagedBean anotacije. Potrebno je definisati podatke koje naša web stranica 
čuva i koje funkcije očekujemo da poziva.*/

@ManagedBean
public class DomacinstvoController {

	//cuvamo info o Domacinstvu
	//podaci koje cuvamo u okviru stranice 
	private int id=0;
	private Domacinstvo domacinstvo=new Domacinstvo();
	private int sid=0;
	private String adresa="";
	private String ime="";
	private String prezime="";
	
//referenca na servis poslovne logike (njegov interface)
//obracamo mu se kao objektu poslovne logike	
	@EJB
	private DomacinstvoService service;
	//getter
	public Domacinstvo getDomacinstvo() {
		if(domacinstvo==null) {domacinstvo=new Domacinstvo();}
		return domacinstvo;
	}
	//setter
	public void setDomacinstvo(Domacinstvo domacinstvo) {
		this.domacinstvo = domacinstvo;
	}
	
	//ime
	public String getIme()
	{
		return ime;
	}
	public void setIme(String ime)
	{
		this.ime=ime;
	}
	
	//prezime
	public void setPrezime(String prezime)
	{
		this.prezime=prezime;
	}
	public String getPrezime()
	{
		return prezime;
	}
	
	//id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//sid
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	//adresa
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	//imamo i pozive servisa poslovne logike
	
	//ustvari persist
	public void addDomacinstvo(Domacinstvo dom) {
		service.addDomacinstvo(dom);
	}
	
	public void deleteDomacinstvo(int id) {
		service.deleteDomacinstvo(id);
	}
	
	public void updateDomacinstvo(int idDom, String mesto) {
		service.updateDomacinstvo(idDom, mesto);
	}
	
}
