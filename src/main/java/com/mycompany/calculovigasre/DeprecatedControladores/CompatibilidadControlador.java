package com.mycompany.calculovigasre.DeprecatedControladores;

import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;
import VistasDeprecated.CompatibilidadVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompatibilidadControlador extends CompatibilidadVista{

	private static CompatibilidadEnIntervencionesHistoricas a= new CompatibilidadEnIntervencionesHistoricas();
	
	public CompatibilidadControlador(String titulo) {
		super(titulo);
		
		info.addActionListener(new Escuchador1());
		info1Viga.addActionListener(new Escuchador2());
		infoEstudio.addActionListener(new Escuchador3());
		altaViga.addActionListener(new Escuchador4());
		infoFactor.addActionListener(new Escuchador5());
		altaCali.addActionListener(new Escuchador5());
		vigaTiemp.addActionListener(new Escuchador5());
		reempViga.addActionListener(new Escuchador5());
		bajaEst.addActionListener(new Escuchador5());
		bajaViga.addActionListener(new Escuchador5());
		mayF.addActionListener(new Escuchador5());
		minF.addActionListener(new Escuchador5());
	}
	
	private class Escuchador1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String r;
			
			r=a.toString();
			
			res.setText(r);
		}
	}
		
	private class Escuchador2 implements ActionListener{
		public void actionPerformed(ActionEvent arg1) {
			String clave=claveTxt.getText();
			
			if(!clave.equals("")) {
				InfoControlador q = new InfoControlador("Viga",a,clave);
			}
			else {
				res.setText("Inserta clave");
			}
		}
	}
	
	private class Escuchador3 implements ActionListener{
		public void actionPerformed(ActionEvent arg2) {
			String tip=tipoTxt.getText();
			
			if(!tip.equals("")) {
				EstudioControlador c= new EstudioControlador("Estudio",a,tip);
			}
			else {
				res.setText("Inseta la calidad");
			}
		}
	}
		
	private class Escuchador4 implements ActionListener{
		public void actionPerformed(ActionEvent arg3) {
			AltaControlador f= new AltaControlador("Alta",a);
		}
	}
		
	private class Escuchador5 implements ActionListener{
		public void actionPerformed(ActionEvent arg4) {
			
			String r;
			String clv,tip,tiemp,car;
			int clv1,tip1,tiemp1,car1;
			String infor="";
			boolean d;
			
			r=arg4.getActionCommand();
			
			switch(r.charAt(0)) {
				case '3':
					tip=tipoTxt.getText();
					tiemp=tiempoTxt.getText();
					car=(String) cargaBx.getSelectedItem();
					
					if(!tip.equals("")&&!tiemp.equals("")) {
						tip1=Integer.parseInt(tip);
						tiemp1=Integer.parseInt(tiemp);
						if(cargaBx.getSelectedIndex()==0) {
							car1=Integer.parseInt(car.substring(0,1));
						}
						else {
							car1=Integer.parseInt(car.substring(0, 2));
						}
						infor="" + a.getUnFactor(tip1, tiemp1, car1);
					}
					else {
						infor="Inserta el tipo, tiempo y carga";
					}
					
					break;
				case '4':
					tip=tipoTxt.getText();
					
					if(!tip.equals("")) {
						tip1=Integer.parseInt(tip);
					
						d=a.altaCalidad(tip1);
					
						if(d) {
							infor="Registrado con exito";
						}
						else {
							infor="No se registro";
						}
					}
					else {
						infor="Inserta un tipo";
					}
					break;
				case 'D':
					tiemp=tiempoTxt.getText();
					clv=claveTxt.getText();
					car=(String) cargaBx.getSelectedItem();
					
					if(!tiemp.equals("")&&!clv.equals("")) {
						tiemp1=Integer.parseInt(tiemp);
						clv1=Integer.parseInt(clv);
						if(cargaBx.getSelectedIndex()==0) {
							car1=Integer.parseInt(car.substring(0,1));
						}
						else {
							car1=Integer.parseInt(car.substring(0, 2));
						}
						
						infor=a.vigaEnElTiempo(clv1, tiemp1, car1);
					}
					else {
						infor="Inserta la clave, tiempo y carga";
					}
					break;
				case 'R':
					clv=claveTxt.getText();
					tiemp=tiempoTxt.getText();
					car=(String) cargaBx.getSelectedItem();
					
					if(!clv.equals("")&&!tiemp.equals("")) {
						clv1=Integer.parseInt(clv);
						tiemp1=Integer.parseInt(tiemp);
						if(cargaBx.getSelectedIndex()==0) {
							car1=Integer.parseInt(car.substring(0,1));
						}
						else {
							car1=Integer.parseInt(car.substring(0, 2));
						}
						
						infor=a.reemplazaViga(clv1);
					}
					else {
						infor="Inserta la clave, tiempo y carga";
					}
					break;
				case '5':
					tip=tipoTxt.getText();
					tiemp=tiempoTxt.getText();
					
					if(!tip.equals("")&&!tiemp.equals("")) {
						tip1=Integer.parseInt(tip);
						tiemp1=Integer.parseInt(tiemp);
						
						d=a.bajaEstudio(tip1, tiemp1);
						
						if(d) {
							infor="Baja exitosa";
						}
						else {
							infor="No se encontro";
						}
					}
					else {
						infor="Inserta tipo y tiempo";
					}
					break;
				case '6':
					clv=claveTxt.getText();
					
					if(!clv.equals("")) {
						clv1=Integer.parseInt(clv);
						
						d=a.bajaViga(clv1);
						
						if(d) {
							infor="Baja exitosa";
						}
						else {
							infor="No se encontro";
						}
					}
					else {
						infor="Inserta la clave";
					}
					break;
				case 'F':
					infor="" + a.getMayFactor();
					break;
				case '7':
					infor="" + a.gatMinFact();
					break;
			}
			
			res.setText(infor);
			
		}
	}
	
	public static void main(String[] args) {
		CompatibilidadControlador b= new CompatibilidadControlador("Compatibilidad");
		
		int numC, c, numM,m, numS, numV, ba, mod, s, p, cl, inicio, fin, carg;
		double f1, f2, f3, r;
		
		File datos = new File("src/main/java/Files/CasaVirreinal.txt");
		
		try (Scanner lec= new Scanner(datos)){
			a.setNomPatrimonioHistorico("Casa Virreinal");
			
			numC= lec.nextInt();
			
			for(int i=0; i<numC; i++) {
				c=lec.nextInt();
				a.altaCalidad(c);
			}
			
			for(int i=0; i<numC; i++) {
				numM= lec.nextInt();
				c=lec.nextInt();
				for(int j=0; j<numM; j++) {
					m=lec.nextInt();
					f1=lec.nextDouble();
					f2= lec.nextDouble();
					f3=lec.nextDouble();
					
					a.altaEstudio(c, m, f1, f2, f3);
				}
			}
			
			numS= lec.nextInt();
			
			for(int i=0; i<numS; i++) {
				numV=lec.nextInt();
				c=lec.nextInt();
				ba=lec.nextInt();
				r=lec.nextDouble();
				mod=lec.nextInt();
				s=lec.nextInt();
				
				for(int j=0; j<numV; j++) {
					
					a.altaViga(1,c, ba, r, mod, s);
				}
				inicio=lec.nextInt();
				fin=lec.nextInt();
				p=lec.nextInt();
				cl=lec.nextInt();
				m=lec.nextInt();
				carg=lec.nextInt();
				
				while(inicio<=fin) {
					
					a.setRigidez(inicio, cl, p);
					a.vigaEnElTiempo(inicio, m, carg);
					
					inicio++;
				}
			}
			
			numV=lec.nextInt();
			
			for(int i=0; i<numV; i++) {
				cl=lec.nextInt();
				
				a.reemplazaViga(cl);
			}
			
		}
		catch(FileNotFoundException err){
			System.err.println(err);
			System.exit(-1);
		}
	}

}
