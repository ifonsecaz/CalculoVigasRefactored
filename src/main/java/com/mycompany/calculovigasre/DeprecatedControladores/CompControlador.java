package com.mycompany.calculovigasre.DeprecatedControladores;

import VistasDeprecated.CompatibilidadVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompControlador extends CompatibilidadVista{
	
	public CompControlador(String titulo) {
		super(titulo);
		
		info.addActionListener(new e1());
		
	}
	
	private class e1 implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			System.out.println("e");
		}
	}
	
	public static void main(String[] args) {
		CompControlador a= new CompControlador("d");

	}

}
