package Polinom;

import java.util.ArrayList;

public class Polinom {

	public ArrayList<Monom> polinom = new ArrayList<Monom>();

	public Polinom() {}

	public Polinom(Monom m) { 
		polinom.add(m); //Adaug un monom in lista
	}

	public String afiseaza() {
		String output = new String();
		for(Monom m : polinom) 
			output = output + m.toString(); //Concatenez monoamenele din lista
		return output; 
	}

}
