package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import Operatii.*;
import Parsare.*;
import Polinom.*;

public class Controller {
	public View view;
	public Operatie operatie;

	public Controller(View view, Operatie operatie)
	{
		this.view = view;
		this.operatie = operatie;
		view.addText1Listener(new CalcListener());
		view.addText2Listener(new CalcListener());
		view.addComboListener(new CalcListener());
		view.addButton1Listener(new CalcListener());
		view.addButton2Listener(new CalcListener());
	}

	class CalcListener implements ActionListener {

		public void selectIndex0() {
			try{
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if(view.t1.getText().equals("")) //Daca intr-una dintre casute nu se introduce nimic
					p1 = p.parseaza("0"); //adunarea se va realiza cu elementul neutru
				else
					p1 = p.parseaza(view.t1.getText());
				if(view.t2.getText().equals(""))
					p2 = p.parseaza("0");
				else 
					p2 = p.parseaza(view.t2.getText());
				operatie.adunaTermeniiAsemenea(p1);
				operatie.adunaTermeniiAsemenea(p2); 
				Collections.sort(p1.polinom); //Sortez polinoamele in functie de exponenti
				Collections.sort(p2.polinom);
				Polinom p3 = operatie.aduna(p1, p2);
				view.t3.setText(p3.afiseaza());
				view.t4.setText(null);
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); 
				view.t4.setText(null);
			}
		}

		public void selectIndex1() {
			try {
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if(view.t1.getText().equals("")) //Daca intr-una dintre casute nu se introduce nimic
					p1 = p.parseaza("0"); //scaderea se va realiza cu elementul neutru
				else
					p1 = p.parseaza(view.t1.getText());
				if(view.t2.getText().equals(""))
					p2 = p.parseaza("0");
				else 
					p2 = p.parseaza(view.t2.getText());
				operatie.adunaTermeniiAsemenea(p1);
				operatie.adunaTermeniiAsemenea(p2); 
				Collections.sort(p1.polinom); //Sortez polinoamele in functie de exponenti
				Collections.sort(p2.polinom);
				Polinom p3 = operatie.scade(p1, p2);
				view.t3.setText(p3.afiseaza());
				view.t4.setText(null);
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); 
				view.t4.setText(null);
			}
		}

		public void selectIndex2() {
			try {
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if(view.t1.getText().equals("")) //Daca intr-una dintre casute nu se introduce nimic
					p1 = p.parseaza("1"); //inmultirea se va realiza cu elementul neutru
				else
					p1 = p.parseaza(view.t1.getText());
				if(view.t2.getText().equals(""))
					p2 = p.parseaza("1");
				else 
					p2 = p.parseaza(view.t2.getText());
				operatie.adunaTermeniiAsemenea(p1);
				operatie.adunaTermeniiAsemenea(p2); 
				Collections.sort(p1.polinom); //Sortez polinoamele in functie de exponenti
				Collections.sort(p2.polinom);
				Polinom p3 = operatie.inmulteste(p1, p2);
				view.t3.setText(p3.afiseaza());
				view.t4.setText(null);
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); 
				view.t4.setText(null);
			}
		}

		public void selectIndex3() {
			try { 
				if(view.t2.getText().equals("0")) {
					view.t3.setText("Nu se poate imparti la 0");
					return;}
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if(view.t1.getText().equals("")) //Daca intr-una dintre casute nu se introduce nimic
					p1 = p.parseaza("1"); //impartirea se va realiza cu elementul neutru
				else 
					p1 = p.parseaza(view.t1.getText());
				if(view.t2.getText().equals(""))
					p2 = p.parseaza("1");
				else 
					p2 = p.parseaza(view.t2.getText());
				operatie.adunaTermeniiAsemenea(p1);
				operatie.adunaTermeniiAsemenea(p2); 
				Collections.sort(p1.polinom); //Sortez polinoamele in functie de exponenti
				Collections.sort(p2.polinom);
				try { 
					ArrayList<Polinom> p3 = operatie.imparte(p1, p2);
					view.t3.setText(p3.get(0).afiseaza());
					view.t4.setText(p3.get(1).afiseaza()); }
				catch(NullPointerException e) {
					view.t3.setText("Polinomul 1 trebuie sa aiba");
					view.t4.setText("aiba gradul mai mare!"); }
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); }
		}

		public void selectIndex4() {
			try {
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				if(view.t1.getText().equals("")) //Verific in care dintre casute s-a introdus polinomul
					p1 = p.parseaza(view.t2.getText());
				else
					p1 = p.parseaza(view.t1.getText());
				operatie.adunaTermeniiAsemenea(p1);
				Collections.sort(p1.polinom);
				Polinom p3 = operatie.deriveaza(p1);
				view.t3.setText(p3.afiseaza());
				view.t4.setText(null);
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); 
				view.t4.setText(null);
			}
		}

		public void selectIndex5() {
			try {
				ParsarePolinom p = new ParsarePolinom();
				Polinom p1 = new Polinom();
				if(view.t1.getText().equals("")) //Verific in care dintre casute s-a introdus polinomul
					p1 = p.parseaza(view.t2.getText());
				else
					p1 = p.parseaza(view.t1.getText());
				operatie.adunaTermeniiAsemenea(p1);
				Collections.sort(p1.polinom);
				Polinom p3 = operatie.integreaza(p1);
				view.t3.setText(p3.afiseaza());
				view.t4.setText(null);
			}
			catch(NumberFormatException e) {
				view.t3.setText("Polinom invalid!!"); 
				view.t4.setText(null);
			}
		}

		public void reset() {
			view.t1.setText(null);
			view.t2.setText(null);
			view.t3.setText(null);
			view.t4.setText(null);
		}
		
		public void actionPerformed(ActionEvent action) {
			if(action.getSource() == view.b1) {
				if(view.c1.getSelectedIndex() == 0) 
					selectIndex0();
				if(view.c1.getSelectedIndex() == 1) 
					selectIndex1(); 
				if(view.c1.getSelectedIndex() == 2) 
					selectIndex2(); 
				if(view.c1.getSelectedIndex() == 3) 
					selectIndex3();
				if(view.c1.getSelectedIndex() == 4) 
					selectIndex4(); 
				if(view.c1.getSelectedIndex() == 5) 
					selectIndex5(); 
			}
			if(action.getSource() == view.b2)
				reset(); 
		}
	}
}


