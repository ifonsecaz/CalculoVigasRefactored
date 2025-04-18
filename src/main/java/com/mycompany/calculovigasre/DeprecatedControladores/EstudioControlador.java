package com.mycompany.calculovigasre.DeprecatedControladores;

import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;
import VistasDeprecated.EstudioVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstudioControlador extends EstudioVista{

	private static CompatibilidadEnIntervencionesHistoricas c;
	private static int tipo;
	
	public EstudioControlador (String titulo,CompatibilidadEnIntervencionesHistoricas c,String tip) {
		super(titulo);

		this.c=c;
		
		altaEstudio.addActionListener(new Escuchador6());
		
		tipo=Integer.parseInt(tip);
		
		infoEstudio.setText(c.getEstudio(tipo));
	}
	
	private class Escuchador6 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String meses=mesesTxt.getText();
			String f1Str=f1.getText();
			String f2Str=f2.getText();
			String f3Str=f3.getText();
			String alta;
			boolean d;
			int mesI;
			Double f1I,f2I,f3I;
			
			if(!meses.equals("")&&!f1Str.equals("")&&!f2Str.equals("")&&!f3Str.equals("")) {
				mesI=Integer.parseInt(meses);
				f1I=Double.parseDouble(f1Str);
				f2I= Double.parseDouble(f2Str);
				f3I=Double.parseDouble(f3Str);
				
				d=c.altaEstudio(tipo, mesI, f1I, f2I, f3I);
				
				if(d) {
					alta="Estudio registrado";
				}
				else {
					alta="No se registro";
				}
			}
			else {
				alta="Inserta los meses y sus 3 factores";
			}
			
			altaEstudio.setText(alta);
		}
	}
	
	public static void main(String[] args) {
		//EstudioControlador d= new EstudioControlador("nml");

	}

}
