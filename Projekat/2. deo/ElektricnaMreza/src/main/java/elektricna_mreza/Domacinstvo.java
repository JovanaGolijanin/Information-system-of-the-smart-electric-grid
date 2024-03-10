package elektricna_mreza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "domacinstvo")
public class Domacinstvo {
	
	@TableGenerator(name = "dom_gen", table = "id_domacinstvo_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "dom_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "dom_gen")
	
	private int iddomacinstva;
	
	@Column(name = "ime")
	private String ime;
	@Column(name = "prezime")
	private String prezime;
	@Column (name="adresa")
	private String adresa;
	
	
	public Domacinstvo() {}
	
	public Domacinstvo(int domacinstvoId,String ime,String prezime,String adresa) {
		this.iddomacinstva=domacinstvoId;
		this.ime=ime;
		this.prezime=prezime;
		this.adresa=adresa;
	}
	//id
	public int getIddomacinstva() {
		return iddomacinstva;
	}
	public void setIddomacinstva(int iddomacinstva) {
		this.iddomacinstva = iddomacinstva;
	}
	//ime
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	//prezime
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	//adresa
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}

