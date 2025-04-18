package com.mycompany.calculovigasre.DeprecatedControladores;

import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;
import VistasDeprecated.AltaVista;
import com.mycompany.calculovigasre.ElementosLinealesCubiertas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaControlador extends AltaVista{

	private static CompatibilidadEnIntervencionesHistoricas d;
	
	public AltaControlador(String titulo,CompatibilidadEnIntervencionesHistoricas d) {
		super(titulo);
		
		this.d=d;
		
		alta.addActionListener(new Escuchador8());
		altaR.addActionListener(new Escuchador9());
		altaP.addActionListener(new Escuchador9());
		altaC.addActionListener(new Escuchador9());
	}
	
	private class Escuchador8 implements ActionListener{
		public void actionPerformed(ActionEvent arg8) {
			String cTxt= calTxt.getText();
			String baTxt= bTxt.getText();
			String rTxt= reTxt.getText();
			String mTxt= modTxt.getText();
			String sTxt= seccTxt.getText();
						
			int cI=Integer.parseInt(cTxt);
			int baI=Integer.parseInt(baTxt);
			int sI=Integer.parseInt(sTxt);
			
			Double rI= Double.parseDouble(rTxt);
			Double mI= Double.parseDouble(mTxt);
		
			String g;
			
			ElementosLinealesCubiertas f;

			f=d.altaViga(cI, baI, rI, mI, sI);
		
                        if(f!=null) {
				g=f.toString()+"\nSe registro con exito";
			}
			else {
				g="No se registro";
			}
			
			info.setText(g);
		}
	}
	
	private class Escuchador9 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String peTxt= pTxt.getText();
			String clTxt = claTxt.getText();
			String riTxt= rigTxt.getText();
			String clavTxt=claveTxt.getText();
			
			int claveI=Integer.parseInt(clavTxt);
			
			Double peI, clI,riI;
			
			String r=arg0.getActionCommand();
			String f="";
			
			switch(r.charAt(0)) {
				case '1':					
					peI= Double.parseDouble(peTxt);
					clI= Double.parseDouble(clTxt);
							
					f=d.setRigidez(claveI, clI, peI);
					break;
				case '2': 
					clI= Double.parseDouble(clTxt);
					riI= Double.parseDouble(riTxt);
					
					f=d.setPeralte(claveI, clI, riI);
					break;
				case '3':
					peI= Double.parseDouble(peTxt);
					riI= Double.parseDouble(riTxt);
					
					f=d.setClaro(claveI, peI, riI);
					break;
			}
			
			
			info.setText(f);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
