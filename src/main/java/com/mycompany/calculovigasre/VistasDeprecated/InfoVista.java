package VistasDeprecated;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;


public class InfoVista extends JFrame {

	protected JTextArea infoViga;
	protected JTextField res;
	protected JButton inercia, reMod, areaA, areaAT, ejeN, inS, modSec;
	
	public InfoVista(String titulo) {
		super(titulo);
		
		infoViga = new JTextArea(10,10);
		res= new JTextField(10);
		
		inercia= new JButton("Inercia");
		reMod= new JButton("Relacion Modular");
		areaA= new JButton("Area de acero");
		areaAT= new JButton("+Area de acero Transformada");
		ejeN= new JButton("Eje neutro");
		inS= new JButton("*Inercia de la Seccion");
		modSec= new JButton("Modulo de Seccon");
		
		JPanel p1= new JPanel(new FlowLayout());
		
		
		Border gap= BorderFactory.createEmptyBorder(0,5,0,5);
		p1.setBorder(gap);
		
		JScrollPane p2 = new JScrollPane(infoViga);
		
		p1.add(p2);
		p1.add(inercia);
		p1.add(reMod);
		p1.add(areaA);
		p1.add(areaAT);
		p1.add(ejeN);
		p1.add(inS);
		p1.add(modSec);
		p1.add(res);
		
		this.add(p1);
		
		this.setVisible(true);
		
		this.setBounds(600,400,800,400);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//InfoVista yo= new InfoVista("Prueba");
	}

}
