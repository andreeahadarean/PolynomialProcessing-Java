package PT2019_30226_Hadarean_AndreeRoxana_Assignment1.PT2019_30226_Hadarean_AndreeRoxana_Assignment1;

import java.util.ArrayList;
import GUI.*;
import Operatii.*;

public class Main {

	public static void main(String[] args) {
		Operatie o = new Operatie(); //Modelul
		View v = new View(o); //Vederea
		v.setVisible(true); 
		Controller c = new Controller(v, o); //Controller
	}
}
