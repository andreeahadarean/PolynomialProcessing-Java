package PT2019_30226_Hadarean_AndreeRoxana_Assignment1.PT2019_30226_Hadarean_AndreeRoxana_Assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.*;
import org.junit.Test;
import Operatii.*;
import Parsare.*;
import Polinom.*;

public class Assignment1Test {
	@Test
	public void testParsare1() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("x^4-4x^3+2x^2-x+1");
		Monom m1 = new Monom((float)1,4);
		Monom m2 = new Monom((float)-4,3);
		Monom m3 = new Monom((float)2,2);
		Monom m4 = new Monom((float)-1,1);
		Monom m5 = new Monom((float)1,0);
		polinom2.polinom.add(m1); 
		polinom2.polinom.add(m2); 
		polinom2.polinom.add(m3); 
		polinom2.polinom.add(m4); 
		polinom2.polinom.add(m5); 
		for(int i = 0; i < polinom1.polinom.size(); i++) {
			assertEquals(polinom1.polinom.get(i).exponent, polinom2.polinom.get(i).exponent);
			assertEquals((int)polinom1.polinom.get(i).coeficient, (int)polinom2.polinom.get(i).coeficient);
		}
	}

	@Test(expected = NumberFormatException.class)
	public void testParsare2() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("x^4+4y^3+2x^2+x+1"); 
		Monom m1 = new Monom((float)1,4);
		Monom m2 = new Monom((float)4,3);
		Monom m3 = new Monom((float)2,2);
		Monom m4 = new Monom((float)1,1);
		Monom m5 = new Monom((float)1,0);
		polinom2.polinom.add(m1); 
		polinom2.polinom.add(m2); 
		polinom2.polinom.add(m3); 
		polinom2.polinom.add(m4); 
		polinom2.polinom.add(m5); 
		for(int i = 0; i < polinom1.polinom.size(); i++) {
			assertEquals(polinom1.polinom.get(i).exponent, polinom2.polinom.get(i).exponent);
			assertEquals((int)polinom1.polinom.get(i).coeficient, (int)polinom2.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testAdunare1() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("x^4+4x^3+2x^2+x+1");
		polinom2 = p.parseaza("3x^4-x^3+2x-7");
		Polinom suma = new Polinom();
		Monom m1 = new Monom((float)4,4);
		Monom m2 = new Monom((float)3,3);
		Monom m3 = new Monom((float)2,2);
		Monom m4 = new Monom((float)3,1);
		Monom m5 = new Monom((float)-6,0);
		suma.polinom.add(m1);
		suma.polinom.add(m2);
		suma.polinom.add(m3);
		suma.polinom.add(m4);
		suma.polinom.add(m5);
		Operatie a = new Operatie();
		Polinom sumaObt = a.aduna(polinom1, polinom2);
		for(int i = 0; i < suma.polinom.size(); i++) {
			assertEquals(suma.polinom.get(i).exponent, sumaObt.polinom.get(i).exponent);
			assertEquals((int)suma.polinom.get(i).coeficient, (int)sumaObt.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testAdunare2() {
		//gresit
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("x^4+4x^3+2x^2+x+1");
		polinom2 = p.parseaza("3x^4-x^3+2x-7");
		Polinom suma = new Polinom();
		Monom m1 = new Monom((float)4,4);
		Monom m2 = new Monom((float)5,3); 
		Monom m3 = new Monom((float)2,2);
		Monom m4 = new Monom((float)3,1);
		Monom m5 = new Monom((float)-6,0);
		suma.polinom.add(m1);
		suma.polinom.add(m2);
		suma.polinom.add(m3);
		suma.polinom.add(m4);
		suma.polinom.add(m5);
		Operatie a = new Operatie();
		Polinom sumaObt = a.aduna(polinom1, polinom2);
		assertNotEquals(suma, sumaObt); 
	}

	@Test
	public void testScadere1() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("5x^5-4x^4+3x^3-2x^2+x-1");
		polinom2 = p.parseaza("4x^5+2x^3-x^2+x-1");
		Polinom diferenta = new Polinom();
		Monom m1 = new Monom((float)1,5);
		Monom m2 = new Monom((float)-4,4);
		Monom m3 = new Monom((float)1,3);
		Monom m4 = new Monom((float)-1,2);
		Monom m5 = new Monom((float)0,1);
		Monom m6 = new Monom((float)0,0);
		diferenta.polinom.add(m1);
		diferenta.polinom.add(m2);
		diferenta.polinom.add(m3);
		diferenta.polinom.add(m4);
		diferenta.polinom.add(m5);
		diferenta.polinom.add(m6);
		Operatie s = new Operatie(); 
		Polinom diferentaObt = s.scade(polinom1, polinom2);
		for(int i = 0; i < diferenta.polinom.size(); i++) {
			assertEquals(diferenta.polinom.get(i).exponent, diferentaObt.polinom.get(i).exponent);
			assertEquals((int)diferenta.polinom.get(i).coeficient, (int)diferentaObt.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testScadere2() {
		//gresit
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("5x^5+4x^4+3x^3+2x^2+x+1");
		polinom2 = p.parseaza("-4x^5-2x^3-x^2-x-1");
		Polinom diferenta = new Polinom();
		Monom m1 = new Monom((float)1,5); //se aduna coeficientii in loc sa se scada
		Monom m2 = new Monom((float)4,4);
		Monom m3 = new Monom((float)1,3);
		Monom m4 = new Monom((float)1,2);
		Monom m5 = new Monom((float)0,1);
		Monom m6 = new Monom((float)0,0);
		diferenta.polinom.add(m1);
		diferenta.polinom.add(m2);
		diferenta.polinom.add(m3);
		diferenta.polinom.add(m4);
		diferenta.polinom.add(m5);
		diferenta.polinom.add(m6);
		Operatie s = new Operatie(); 
		Polinom diferentaObt = s.scade(polinom1, polinom2);
		assertNotEquals(diferenta,diferentaObt);
	}

	@Test
	public void testInmultire1() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("3x^3+2x^2+1");
		polinom2 = p.parseaza("x-1");
		Polinom produs = new Polinom();
		Monom m1 = new Monom((float)3,4); 
		Monom m2 = new Monom((float)-1,3);
		Monom m3 = new Monom((float)-2,2);
		Monom m4 = new Monom((float)1,1);
		Monom m5 = new Monom((float)-1,0);
		produs.polinom.add(m1);
		produs.polinom.add(m2);
		produs.polinom.add(m3);
		produs.polinom.add(m4);
		produs.polinom.add(m5);
		Operatie i1 = new Operatie(); 
		Polinom produsObt = i1.inmulteste(polinom1, polinom2);
		for(int i = 0; i < produs.polinom.size(); i++) {
			assertEquals(produs.polinom.get(i).exponent, produsObt.polinom.get(i).exponent);
			assertEquals((int)produs.polinom.get(i).coeficient, (int)produsObt.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testInmultire2() {
		//gresit
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom(); 
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("x+1");
		polinom2 = p.parseaza("x-1");
		Polinom produs = new Polinom();
		Monom m1 = new Monom((float)1,2); 
		Monom m2 = new Monom((float)1,1);
		Monom m3 = new Monom((float)-1,1); //nu se aduna termenii cu acelasi exponent
		Monom m4 = new Monom((float)-1,0);
		produs.polinom.add(m1);
		produs.polinom.add(m2);
		produs.polinom.add(m3);
		produs.polinom.add(m4);
		Operatie i1 = new Operatie(); 
		Polinom produsObt = i1.inmulteste(polinom1, polinom2);
		assertNotEquals(produs, produsObt); 
	}

	@Test
	public void testImpartire1() {
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom();
		ParsarePolinom p = new ParsarePolinom();
		polinom1 = p.parseaza("x^4-x^3+2x^2-x+3");
		polinom2 = p.parseaza("x-1");
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		cat = p.parseaza("x^3+2x+1");
		rest = p.parseaza("4");
		ArrayList<Polinom> impartire = new ArrayList<Polinom>();
		impartire.add(cat);
		impartire.add(rest);
		Operatie o = new Operatie();
		ArrayList<Polinom> impartireEf = o.imparte(polinom1, polinom2);
		for(int i = 0; i < impartire.size(); i++) {
			for(int j = 0; j < impartire.get(i).polinom.size(); j++) {
				assertEquals((int)impartire.get(i).polinom.get(j).coeficient, (int)impartireEf.get(i).polinom.get(j).coeficient);
				assertEquals((int)impartire.get(i).polinom.get(j).exponent, (int)impartireEf.get(i).polinom.get(j).exponent);
			}
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testImpartire2() {
		//gresit
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom();
		ParsarePolinom p = new ParsarePolinom();
		polinom1 = p.parseaza("x^4-x^3+2x^2-x+3");
		polinom2 = p.parseaza("x^5-1");
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		cat = p.parseaza("x+1");
		rest = p.parseaza("4");
		ArrayList<Polinom> impartire = new ArrayList<Polinom>();
		impartire.add(cat);
		impartire.add(rest);
		Operatie o = new Operatie();
		ArrayList<Polinom> impartireEf = o.imparte(polinom1, polinom2);
		for(int i = 0; i < impartire.size(); i++) {
			for(int j = 0; j < impartire.get(i).polinom.size(); j++) {
				assertEquals((int)impartire.get(i).polinom.get(j).coeficient, (int)impartireEf.get(i).polinom.get(j).coeficient);
				assertEquals((int)impartire.get(i).polinom.get(j).exponent, (int)impartireEf.get(i).polinom.get(j).exponent);
			}
		}
	}

	@Test
	public void testDerivare1() {
		Polinom polinom1 = new Polinom();
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("-7x^4+2x^3-9x^2+9x-9");
		Polinom derivata = new Polinom();
		Monom m1 = new Monom((float)-28,3); 
		Monom m2 = new Monom((float)6,2);
		Monom m3 = new Monom((float)-18,1); 
		Monom m4 = new Monom((float)9,0);
		derivata.polinom.add(m1);
		derivata.polinom.add(m2);
		derivata.polinom.add(m3);
		derivata.polinom.add(m4);
		Operatie d = new Operatie(); 
		Polinom derivataObt = d.deriveaza(polinom1);
		for(int i = 0; i < derivata.polinom.size(); i++) {
			assertEquals(derivata.polinom.get(i).exponent, derivataObt.polinom.get(i).exponent);
			assertEquals((int)derivata.polinom.get(i).coeficient, (int)derivataObt.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testDerivare2() {
		Polinom polinom1 = new Polinom();
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("3x^2+7x-1");
		Polinom derivata = new Polinom();
		Monom m1 = new Monom((float)6,2); 
		Monom m2 = new Monom((float)7,0);
		Monom m3 = new Monom((float)-1,-1); //nu se respecta regulile derivarii
		derivata.polinom.add(m1);
		derivata.polinom.add(m2);
		derivata.polinom.add(m3);
		Operatie d = new Operatie(); 
		Polinom derivataObt = d.deriveaza(polinom1);
		assertNotEquals(derivata, derivataObt);
	}

	@Test
	public void testIntegrare1() {
		Polinom polinom1 = new Polinom();
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("-8x^3+9x^2+4x-1");
		Polinom integrala = new Polinom();
		Monom m1 = new Monom((float)-2,4); 
		Monom m2 = new Monom((float)3,3);
		Monom m3 = new Monom((float)2,2); 
		Monom m4 = new Monom((float)-1,1); 
		integrala.polinom.add(m1);
		integrala.polinom.add(m2);
		integrala.polinom.add(m3);
		integrala.polinom.add(m4);
		Operatie i1 = new Operatie();  
		Polinom integralaObt = i1.integreaza(polinom1);
		for(int i = 0; i < integrala.polinom.size(); i++) {
			assertEquals(integrala.polinom.get(i).exponent, integralaObt.polinom.get(i).exponent);
			assertEquals((int)integrala.polinom.get(i).coeficient, (int)integralaObt.polinom.get(i).coeficient);
		}
	}

	@Test
	public void testIntegrare2() {
		//gresit
		Polinom polinom1 = new Polinom();
		ParsarePolinom p = new ParsarePolinom(); 
		polinom1 = p.parseaza("6x^2-1");
		Polinom integrala = new Polinom();
		Monom m1 = new Monom((float)4,1); 
		Monom m2 = new Monom((float)-1,0); 
		integrala.polinom.add(m1);
		integrala.polinom.add(m2);
		Operatie i1 = new Operatie();  
		Polinom integralaObt = i1.integreaza(polinom1);
		assertNotEquals(integrala, integralaObt); 
	}
}