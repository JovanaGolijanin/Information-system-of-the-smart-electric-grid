package elektricna_mreza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "stanje")
public class Stanje {
	@TableGenerator(name = "sta_gen", table = "id_stanje_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "sta_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sta_gen")
	private int idstanja;
	
	@Column(name="potrosnja_u_nizoj_tarifi")
	private double potrosnja_u_nizoj_tarifi;
	@Column(name="potrosnja_u_visoj_tarifi")
	private double potrosnja_u_visoj_tarifi;
	
	public Stanje() {}
	public Stanje(int idstanja, double potrosnjav, double potrosnjan)
	{
		this.idstanja=idstanja;
		this.potrosnja_u_visoj_tarifi=potrosnjav;
		this.potrosnja_u_nizoj_tarifi=potrosnjan;
		
	}
	
	//id
	public int getIdstanja() {
		return idstanja;
	}

	public void setIdstanja(int idstanja) {
		this.idstanja = idstanja;
	}
	
	//Potrosnja_u_nizoj_tarifi
	public double getPotrosnja_u_nizoj_tarifi() {
		return potrosnja_u_nizoj_tarifi;
	}
	
	public void setPotrosnja_u_nizoj_tarifi(double potrosnja_u_nizoj_tarifi) {
		this.potrosnja_u_nizoj_tarifi = potrosnja_u_nizoj_tarifi;
	}

	//Potrosnja_u_visoj_tarifi
	public double getPotrosnja_u_visoj_tarifi() {
		return potrosnja_u_visoj_tarifi;
	}

	public void setPotrosnja_u_visoj_tarifi(double potrosnja_u_visoj_tarifi) {
		this.potrosnja_u_visoj_tarifi = potrosnja_u_visoj_tarifi;
	}
}
