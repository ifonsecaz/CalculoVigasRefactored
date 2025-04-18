package VistasDeprecated;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class AltaVista extends JFrame{
	
	private JLabel clave,calidad, base, recub, mod, secc, peralte, claro, rigi;
	protected JTextField claveTxt,calTxt, bTxt, reTxt, modTxt, seccTxt, pTxt, claTxt, rigTxt;
	protected JTextArea info;
	protected JButton alta,altaR,altaP,altaC;
	
	public AltaVista (String titulo) {
		super(titulo);
		
		calidad= new JLabel("Calidad:");
		base= new JLabel("Base:");
		recub= new JLabel("Recubrimientos:");
		mod= new JLabel("Modulado:");
		secc= new JLabel("Seccion");
		peralte= new JLabel("Peralte:");
		claro= new JLabel("Claro:");
		rigi= new JLabel("Rigidez:");
		clave= new JLabel("Clave:");
		
		claveTxt= new JTextField(8);
		calTxt= new JTextField(8);
		bTxt=new JTextField(8);
		reTxt = new JTextField(8);
		modTxt= new JTextField(8);
		seccTxt= new JTextField(8);
		pTxt= new JTextField(8);
		claTxt= new JTextField(8);
		rigTxt = new JTextField(8);
		
		info= new JTextArea(8,10);
		
		alta= new JButton("Dar de alta");
		altaR= new JButton("1 Dar de alta rigidez");
		altaP= new JButton("2 Dar de alta Peralte");
		altaC= new JButton("3 Dar de alta claro");
		
		JPanel p1= new JPanel(new FlowLayout());
		
		
		Border gap= BorderFactory.createEmptyBorder(0,5,0,5);
		p1.setBorder(gap);
		
		JScrollPane p2 = new JScrollPane(info);
		
		p1.add(p2);
		p1.add(calidad);
		p1.add(calTxt);
		p1.add(base);
		p1.add(bTxt);
		p1.add(recub);
		p1.add(reTxt);
		p1.add(mod);
		p1.add(modTxt);
		p1.add(secc);
		p1.add(seccTxt);
		p1.add(alta);
		p1.add(clave);
		p1.add(claveTxt);
		p1.add(peralte);
		p1.add(pTxt);
		p1.add(claro);
		p1.add(claTxt);
		p1.add(rigi);
		p1.add(rigTxt);
		p1.add(altaR);
		p1.add(altaP);
		p1.add(altaC);
		
		this.add(p1);
		
		this.setVisible(true);
		
		this.setBounds(600,400,650,300);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		//AltaVista yo= new AltaVista("Prueba");
	}

}
