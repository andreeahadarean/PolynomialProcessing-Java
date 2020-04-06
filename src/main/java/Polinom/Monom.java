package Polinom;

public class Monom implements Comparable<Monom> {
	public float coeficient;
	public int exponent;

	public Monom() {
		this.coeficient = 0;
		this.exponent = 0;
	}

	public Monom(float coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public float getCoeficient() {
		return coeficient;
	}

	public int getExponent() {
		return exponent;
	}

	public String toString() {
		String output = new String(); // String-ul ce va contine polinomul de afisat
		if (this.coeficient == 0 && this.exponent == 0) {
			return output; // Daca coeficientul si exponentul sunt 0, nu modific stringul;
		}
		if (this.coeficient == 1) {
			output = output + "+"; // Concatenez semnul pentru numere pozitive
			if (this.exponent == 0)
				output = output + "1"; // Daca coeficientul este 1 si exponentul zero, concatenez "1"
			if (this.exponent == 1)
				output = output + "x"; // Daca exponentul este 1, concatenez "x"
			if (this.exponent > 1)
				output = output + "x^" + this.exponent; // Daca exponentul este mai mare dacat 1, concatenez "x^exponent"
			return output; }
		if (this.coeficient == -1) {
			if (this.exponent == 0)
				output = output + "-1"; // Daca coeficientul este -1 si exponentul zero, concatenez "-1"
			if (this.exponent == 1)
				output = output + "-x"; // Daca exponentul este 1, concatenez "-x"
			if (this.exponent > 1)
				output = output + "-x^" + this.exponent; // Daca exponentul este mai mare dacat 1, concatenez "-x^exponent"
			return output; }
		if (this.coeficient > 0) {
			output = output + "+"; // Concatenez semnul pentru numere pozitive
			output = output + afiseazaExponent();
			return output; }
		if (this.coeficient < -1) {
			output = afiseazaExponent(); }
		return output;
	}
	
	public String afiseazaExponent() {
		String output = new String();
		if (this.exponent == 0)
			output = output + this.coeficient; // Daca coeficientul este negativ (si diferit de -1) si exponentul 0, concatenez coeficientul
		if (this.exponent == 1)
			output = output + this.coeficient + "x"; // Daca exponentul este 1, concatenez "coeficientx"
		if (this.exponent > 1)
			output = output + this.coeficient + "x^" + this.exponent; // Daca exponentul este mai mare decat 1, concatenez "coeficientx^exponent"
		return output;
	}

	public int compareTo(Monom o) {
		return -(Integer.compare(this.getExponent(), o.getExponent())); // Suprascriu metoda compareTo
	}
}
