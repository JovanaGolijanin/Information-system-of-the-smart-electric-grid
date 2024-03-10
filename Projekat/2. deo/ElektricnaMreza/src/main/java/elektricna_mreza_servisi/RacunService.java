package elektricna_mreza_servisi;

import elektricna_mreza.Racun;

public interface RacunService {
	
	public boolean vidiIznosRacuna(int idRacuna,int idStanja);
	public void pregledRacuna(int idRacuna);
	public Racun getRacun(int id);

}
