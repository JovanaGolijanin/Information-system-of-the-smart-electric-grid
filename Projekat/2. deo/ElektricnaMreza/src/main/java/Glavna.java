import elektricna_mreza.*;
//import elektricna_mreza_servisi.*;
//import elektricna_mreza_servisi_impl.*;


public class Glavna {
	
	public static void main(String[] args) {
		
		
		
		
		//obicno domacinstvo
		Domacinstvo dom = new Domacinstvo(1, "Mika", "MIkic", "55");
		int id;
		id = dom.getIddomacinstva();
		System.out.println(id);
		
		//racun
		Racun rac = new Racun(2,1, 1,"pon", "uto",5.0, 2.0, "nis");
		int idR;
		idR = rac.getIdracuna();
		System.out.println(idR);
		
		//stanje
		Stanje st = new Stanje(3, 2.0, 3.0);
		int idS;
		idS = st.getIdstanja();
		System.out.println(idS);
		
		
	}

}
