package Parsare;

import Polinom.*;

public class ParsareMonom {

	public Monom parseaza(String s) {
		Monom m = new Monom();
		int index = s.indexOf('x'); // Aflu pozitia pe care se afla x in string
		if (index < 0) {
			m.coeficient = Float.parseFloat(s); // Tratez cazul in care x nu exista in string => avem doar coeficient
			m.exponent = 0;
			return m;
		}
		if (index == 0) {
			m.coeficient = 1; // Daca x este la pozitia 0, monomul poate fi de forma "x" sau "x^exponent"
			int indexExp = s.indexOf('^'); // Verific daca exista exponent (cazul "x^exponent")
			if (indexExp < 0) {
				m.exponent = 1; // Daca nu exista, exponentul este 1 (cazul "x")
				return m;
			}
			String exp = (String) s.subSequence(index + 2, s.length()); // Cazul "x^exponent"
			m.exponent = Integer.parseInt(exp); // Exponentul va fi valoarea intreaga a substringului de la pozitia index+2 pana la final
			return m;
		}
		if (index == 1 && s.charAt(0) == '-') {
			m.coeficient = -1; // Daca x este la pozitia 1 si primul caracter este '-', monomul poate fi de forma "-x" sau "-x^exponent"
			int indexExp = s.indexOf('^'); // Verific daca exista exponent (cazul "-x^exponent")
			if (indexExp < 0) {
				m.exponent = 1; // Daca nu exista, exponentul este 1 (cazul "-x")
				return m;
			}
			String exp = (String) s.subSequence(index + 2, s.length()); // Cazul "-x^exponent"
			m.exponent = Integer.parseInt(exp); // Exponentul va fi valoarea intreaga a substringului de la pozitia index+2 pana la final
			return m;
		}
		String coef = (String) s.subSequence(0, index); // Tratez cazul in care coeficientul este mai mare decat 1
		m.coeficient = Float.parseFloat(coef);
		int indexExp = s.indexOf('^'); // Verific daca exista exponent
		if (indexExp < 0) {
			m.exponent = 1; // Daca nu exista, exponentul este 1
			return m;
		}
		String exp = (String) s.subSequence(index + 2, s.length());
		m.exponent = Integer.parseInt(exp); // Exponentul va fi valoarea intreaga a substringului de la pozitia index+2 pana la final
		return m;
	}
}
