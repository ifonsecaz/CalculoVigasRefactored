package com.mycompany.calculovigasre.DeprecatedControladores;

import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;
import VistasDeprecated.InfoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoControlador extends InfoVista {

	private static CompatibilidadEnIntervencionesHistoricas b;
	private static int claveNum;
	
	public InfoControlador(String titulo,CompatibilidadEnIntervencionesHistoricas b,String clave) {
		super(titulo);
		
		this.b=b;
		inercia.addActionListener(new Escuchador7());
		reMod.addActionListener(new Escuchador7());
		areaA.addActionListener(new Escuchador7());
		areaAT.addActionListener(new Escuchador7());
		ejeN.addActionListener(new Escuchador7());
		inS.addActionListener(new Escuchador7());
		modSec.addActionListener(new Escuchador7());
		
		claveNum=Integer.parseInt(clave);
		
		infoViga.setText(b.getUnaViga(claveNum));
	}
	
	private class Escuchador7 implements ActionListener{
		public void actionPerformed(ActionEvent arg1) {
			String r;
			String info="-1";
			r=arg1.getActionCommand();
			
			switch(r.charAt(0)) {
				case 'I':
					info="" + b.inercia(claveNum);
					break;
				case 'R':
					info="" + b.relacionModular(claveNum);
					break;
				case 'A':
					info="" + b.areaDeAcero(claveNum);
					break;
				case '+':
					info="" + b.areaDeAceroTransformada(claveNum);
					break;
				case 'E':
					info="" + b.ejeNeutro(claveNum);
					break;
				case '*':
					info="" + b.inerciaDeLaSeccionAgrietada(claveNum);
					break;
				case'M':
					info="" + b.moduloDeSeccion(claveNum);
					break;
			}
			
			res.setText(info);
		}
	}
	public static void main(String[] args) {
		//InfoControlador m = new InfoControlador("Viga");

	}

}
