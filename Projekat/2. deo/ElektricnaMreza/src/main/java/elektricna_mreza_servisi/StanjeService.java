package elektricna_mreza_servisi;
import elektricna_mreza.Stanje;

public interface StanjeService {
	
	public void vratiKolPotroseneEnergijeUVisojTarifi(int id);
	public void vratiKolPotroseneEnergijeUNizojTarifi(int id);
	public Stanje getStanje(int id);
	
	public void saveStanje(Stanje stanje);
	public void createStanje(int idstanja,double nt, double vt);

	
}
