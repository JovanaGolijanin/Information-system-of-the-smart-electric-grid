package elektricna_mreza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "racun")
public class Racun {

	@TableGenerator(name = "rac_gen", table = "id_racun_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "rac_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "rac_gen")
	
	private int idracuna;
	
	@Column(name="id_domacinstva")
	private int id_domacinstva;
	@Column(name="id_stanja")
	private int id_stanja;
	
	@Column(name="vreme_izdavanja")
	private String vreme_izdavanja;
	@Column(name="rok_za_placanje")
	private String rok_za_placanje;
	@Column (name="visaTarifa")
	private double visaTarifa;// cena elektricne energije u visoj tarifi
	@Column(name="nizaTarifa")
	private double nizaTarifa; // cena elektricne energije u nizoj tarifi (jefiniji rezim)
	@Column(name="mesto_izdavanja")
	private String mesto_izdavanja;
	
	public Racun() {}
	public Racun(int idRacuna, int idDom, int idStanja,String vremeIzdavanja, String rokZaPlacanje,
			double visaTarifa, double nizaTarifa, String mesto)
	{
		this.idracuna=idRacuna;
		this.id_domacinstva=idDom;
		this.id_stanja=idStanja;
		this.vreme_izdavanja=vremeIzdavanja;
		this.rok_za_placanje=rokZaPlacanje;
		this.visaTarifa=visaTarifa;
		this.nizaTarifa=nizaTarifa;
		this.mesto_izdavanja=mesto;
	}
	
	//idRacuna
	public int getIdracuna() {
		return idracuna;
	}
	public void setIdracuna(int idracuna) {
		this.idracuna = idracuna;
	}
	//idDomacinstva
	public int getId_domacinstva() {
		return id_domacinstva;
	}
	public void setId_domacinstva(int id_domacinstva) {
		this.id_domacinstva = id_domacinstva;
	}
	//idStanja
	public int getId_stanja() {
		return id_stanja;
	}
	public void setId_stanja(int id_stanja) {
		this.id_stanja = id_stanja;
	}
	//Vreme_izdavanja
	public String getVreme_izdavanja() {
		return vreme_izdavanja;
	}
	public void setVreme_izdavanja(String vreme_izdavanja) {
		this.vreme_izdavanja = vreme_izdavanja;
	}
	//Rok_za_placanje
	public String getRok_za_placanje() {
		return rok_za_placanje;
	}
	public void setRok_za_placanje(String rok_za_placanje) {
		this.rok_za_placanje = rok_za_placanje;
	}
	//VisaTarifa
	public double getVisaTarifa() {
		return visaTarifa;
	}
	public void setVisaTarifa(double visaTarifa) {
		this.visaTarifa = visaTarifa;
	}
	//NizaTarifa
	public double getNizaTarifa() {
		return nizaTarifa;
	}
	public void setNizaTarifa(double nizaTarifa) {
		this.nizaTarifa = nizaTarifa;
	}
	//Mesto_izdavanja
	public String getMesto_izdavanja() {
		return mesto_izdavanja;
	}
	public void setMesto_izdavanja(String mesto_izdavanja) {
		this.mesto_izdavanja = mesto_izdavanja;
	}



}
