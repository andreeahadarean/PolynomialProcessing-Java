package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Operatii.Operatie;

public class View extends JFrame {
	public JTextField t1,t2,t3,t4; 
	public JButton b1,b2;
	public JComboBox c1; 
	public String[] operatii = {"Adunare", "Scadere", "Inmultire", "Impartire", "Derivare", "Integrare"};
	public Operatie operatie  = new Operatie();

	public View(Operatie operatie)
	{
		this.operatie = operatie; //Clasa Operatie este folosita pe post de model
		GridBagLayout gbag = new GridBagLayout(); 
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel(); 
		p.setLayout(gbag); //Setez layoutul panelului
		c1 = new JComboBox(operatii);
		c1.setSelectedIndex(0);
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(15);
		b1 = new JButton("Calculeaza");
		b2 = new JButton("Reset");
		JLabel h = new JLabel("Calculator pentru polinoame");
		JLabel l1 = new JLabel("Polinom 1  ");
		JLabel l2 = new JLabel("Polinom 2  ");
		JLabel l3 = new JLabel("Rezultat  ");
		gbc.weighty=1.0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.anchor=GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(t1, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(t2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(c1, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(b1, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(t3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(t4, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(b2, gbc);
		p.add(h);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(c1);
		p.add(b1);
		p.add(l3);
		p.add(t3);
		p.add(t4); 
		p.add(b2);
		this.setContentPane(p);
		this.setTitle("Calculator de polinoame");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Adaug ascultatori pentru elementele din interfata grafica
	void addText1Listener(ActionListener a)
	{
		t1.addActionListener(a);
	}

	void addText2Listener(ActionListener a)
	{
		t2.addActionListener(a);
	}

	void addComboListener(ActionListener a)
	{
		c1.addActionListener(a);
	}

	void addButton1Listener(ActionListener a)
	{
		b1.addActionListener(a);
	}

	void addButton2Listener(ActionListener a)
	{
		b2.addActionListener(a);
	}
}
