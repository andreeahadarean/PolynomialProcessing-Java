package Operatii;

import java.util.*;
import Polinom.*;

public class Operatie {

	public Polinom aduna(Polinom p1, Polinom p2) {
		Polinom suma = new Polinom(); 
		suma.polinom.addAll(p1.polinom); //Adaug monoamele din primul polinom in polinomul suma
		suma.polinom.addAll(p2.polinom); //Adaug monoamele din al doilea polinom in polinomul suma
		adunaTermeniiAsemenea(suma); 
		Collections.sort(suma.polinom); //Sortez polinomul in functie de exponent
		return suma; 
	}

	public Polinom scade(Polinom p1, Polinom p2) {
		Polinom diferenta = new Polinom(); 
		diferenta.polinom.addAll(p1.polinom); //Adaug monoamele din primul polinom in polinomul diferenta
		for(Monom m : p2.polinom)
			diferenta.polinom.add(new Monom((-1)*m.coeficient, m.exponent)); //Adaug monoamele din al doile polinom in polinomul diferenta,cu semn schimbat
		adunaTermeniiAsemenea(diferenta); 
		Collections.sort(diferenta.polinom); //Sortez polinomul in functie de exponent
		return diferenta; 
	}

	public Polinom inmulteste(Polinom p1, Polinom p2) {
		Polinom produs = new Polinom();
		for(Monom i :p1.polinom) 
			for(Monom j : p2.polinom) 
				produs.polinom.add(new Monom(i.coeficient * j.coeficient, i.exponent + j.exponent)); 
		//Parcurgand ambele polinoame, inmultesc coeficientii si adun exponentii, rezultatul adaugandu-l in lista de monoame a polinomului produs
		adunaTermeniiAsemenea(produs); 
		Collections.sort(produs.polinom); //Sortez polinomul in functie de exponent
		return produs;
	}

	public ArrayList<Polinom> imparte(Polinom p1, Polinom p2) {
		if(p2.equals(new Polinom(new Monom(0, 0)))) 
			return null; 
		ArrayList<Polinom> rezultat = new ArrayList<Polinom>(); //Pe pozitia 0 se afla polinom cat, pe pozitia 1 se afla polinomul rest
		if(p1.polinom.get(0).exponent >= p2.polinom.get(0).exponent) { //Polinoamul de impartit trebuie sa aiba gradul mai mare sau egal
			Polinom cat = new Polinom(); //decat gradul impartitorului
			Polinom rest = new Polinom();
			Polinom copie = new Polinom();
			copie.polinom.addAll(p1.polinom); //Operatiile vor fi realizate pe un polinom copie
			Polinom scalar = new Polinom(new Monom((float)-1, 0));
			for(int i = 0; i < p1.polinom.get(0).exponent - p2.polinom.get(0).exponent + 1; i++) {
				int diferentaGrade = copie.polinom.get(0).exponent - p2.polinom.get(0).exponent; //Gradul polinomului din cat
				if(diferentaGrade < 0 )
					break; //Daca diferenta gradelor este mai mica decat 0, nu mai putem impartii
				cat.polinom.add(new Monom(copie.polinom.get(0).coeficient, diferentaGrade)); //Adaug in polinomul cat monomul
				Polinom aux = new Polinom(cat.polinom.get(i)); //Monomul cu care realizez operatiile
				rest = inmulteste(p2, aux); //Inmultesc monomul din cat cu impartitorul
				rest = inmulteste(rest, scalar); //Inmultesc rezultatul cu -1
				rest = aduna(copie, rest); //Il adun la copie
				for(int j = 0; j < rest.polinom.size(); j++) {
					if(rest.polinom.get(0).coeficient == 0)
						rest.polinom.remove(0); } //Elimin elementele de pe pozitille goale (monoame cu coeficienti 0)
				copie.polinom.removeAll(copie.polinom); //Golesc copia
				copie.polinom.addAll(rest.polinom);} //Polinomul de impartit va deveni restul obtinut
			rezultat.add(cat);
			rezultat.add(rest); }
		else {
			return null;  }
		return rezultat;
	}

	public Polinom deriveaza(Polinom p1) {
		Polinom derivata = new Polinom();
		derivata.polinom.addAll(p1.polinom); //Adaug monoamele polinomului de derivat in polinomul derivata
		for(int i = 0; i < derivata.polinom.size(); i++) {
			if(derivata.polinom.get(i).exponent == 0) {
				derivata.polinom.remove(i); //Daca exponentul este 0 (exista doar coeficient), scoat monomul din lista
			}
			else {
				derivata.polinom.add(i, new Monom(derivata.polinom.get(i).coeficient * derivata.polinom.get(i).exponent, derivata.polinom.get(i).exponent - 1));
				//Monomul derivat va avea coeficientul monomului nederivat inmultit cu exponentul monomului nederivat
				//si exponentul scazut cu o unitate
				derivata.polinom.remove(i+1); //Scot monomul nederivat din lista
			}
		}
		Collections.sort(derivata.polinom); //Sortez polinomul in functie de exponent
		return derivata; 
	}

	public Polinom integreaza(Polinom p1) {
		Polinom integrala = new Polinom();
		for(Monom m : p1.polinom) {
			float coeficient = m.coeficient / (m.exponent + 1); //Coeficientul monomului integrat va fi catul impartirii dintre coeficientul
			//monomului nederivat si exponentul acestuia adunat cu o unitate
			int exponent = m.exponent + 1; //Exponentul este adunat cu o unitate
			integrala.polinom.add(new Monom(coeficient, exponent)); //Adaugu monomul integrat in lista polinomului integrala
		}
		Collections.sort(integrala.polinom); //Sortez polinomul in functie de exponentu
		return integrala;
	}

	public void adunaTermeniiAsemenea(Polinom p) {
		for(int i = 0; i < p.polinom.size(); i++) {
			for(int j = 1; j < p.polinom.size(); j++) {
				if(p.polinom.get(i).exponent == p.polinom.get(j).exponent && i != j) {
					p.polinom.add(i, new Monom(p.polinom.get(i).coeficient + p.polinom.get(j).coeficient, p.polinom.get(i).exponent));
					////Parcurg polinomul si de fiecare data cand se gasesc 2 monoame ce au acelasi exponent, coeficientii se aduna
					p.polinom.remove(i+1);
					p.polinom.remove(j);
				}
			}
		}
	}
}
