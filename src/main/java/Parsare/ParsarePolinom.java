package Parsare;

import Polinom.*;

public class ParsarePolinom {

	public Polinom parseaza(String polinomInput) {
		Polinom polinom = new Polinom(); 
		String polinomNou = polinomInput.replace("-", "+-"); //Inlocuiesc semnele "-" din polinom cu "+-"
		String[] aux1 = polinomNou.split("\\+"); //Impart Stringul intr-un sir de subStringuri (monoame) in functie de pozitia semnului "+"
		for(String i : aux1) {
			Monom m = new Monom();
			ParsareMonom p = new ParsareMonom();
			if(i.equals(""))
				continue; 
			m = p.parseaza(i); //Parsez fiecare subString => devine monom
			polinom.polinom.add(m); //Il adaug in lista de monoame ce alcatuiesc polinomul
		}
		return polinom; 
	}
}
