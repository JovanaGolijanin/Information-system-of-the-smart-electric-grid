package elektricna_mreza_servisi;
import elektricna_mreza.Domacinstvo;

public interface DomacinstvoService {
	
	public void addDomacinstvo(Domacinstvo dom);
	public void createDomacinstvo(int iddomacinstva,String ime,String prezime,String adresa);
	public Domacinstvo getDomacinstvo(int id);
	public Domacinstvo findDomacinstvo(int id_domacinstva);
	public void deleteDomacinstvo(int id);
	public void updateDomacinstvo(int id,String adresa);
	public String listAllDomacinstva();
	
}

