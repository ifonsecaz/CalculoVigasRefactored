package VistasDeprecated;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class CompatibilidadVista extends JFrame {

	private JLabel claveLb, cargaLb, tiempoLb, tipoLb;
	protected JTextField claveTxt, tiempoTxt, tipoTxt;
	protected JButton info, info1Viga, infoEstudio, altaViga, vigaTiemp, altaCali, infoFactor, bajaEst, bajaViga, reempViga, mayF, minF;
	protected JComboBox cargaBx;
	protected JTextArea res;
	
	public CompatibilidadVista(String titulo) {
		super(titulo);
		
		String[] cargas= {"7 dias","14 dias", "28 dias"};	
		
		
		claveLb = new JLabel("Clave:");
		tipoLb = new JLabel("Calidad:");
		cargaLb = new JLabel("Carga:");
		tiempoLb = new JLabel("Tiempo:");
		
		claveTxt = new JTextField(5);
		cargaBx = new JComboBox (cargas); 
		tipoTxt = new JTextField(5);
		tiempoTxt = new JTextField(5);
		
		info = new JButton("Informacion obra");
		info1Viga = new JButton("1 Info. Viga");
		infoEstudio = new JButton("2 Info. Estudio");
		infoFactor = new JButton("3 Info. Factor");
		altaViga = new JButton("5 Alta Viga");
		altaCali= new JButton("4 Alta Calidad");
		vigaTiemp = new JButton("Deterioro de la viga");
		reempViga = new JButton("Reemplazar viga");
		bajaEst = new JButton("5 Dar de baja estudio");
		bajaViga = new JButton("6 Dar de baja viga");
		mayF = new JButton("Factor mayor");
		minF= new JButton("7 Factor menor");
		
		res= new JTextArea(10,10);
		
		JScrollPane p9 = new JScrollPane(res);
		
		JPanel p1= new JPanel(new FlowLayout());
		
		
		Border gap= BorderFactory.createEmptyBorder(0,5,0,5);
		p1.setBorder(gap);
		
		p1.add(claveLb);
		p1.add(claveTxt);
		p1.add(tipoLb);
		p1.add(tipoTxt);
		p1.add(cargaLb);
		p1.add(cargaBx);
		p1.add(tiempoLb);
		p1.add(tiempoTxt);
		
		JPanel p2= new JPanel(new FlowLayout());
		
		p2.setBorder(gap);
		
		p2.add(info);
		p2.add(info1Viga);
		p2.add(infoFactor);
		p2.add(infoEstudio);
		
		JPanel p3= new JPanel(new FlowLayout());
		
		p3.setBorder(gap);
		
		p3.add(altaViga);
		p3.add(altaCali);
		p3.add(bajaViga);
		p3.add(bajaEst);
		
		JPanel p4 = new JPanel(new FlowLayout());
		
		p4.setBorder(gap);
		
		p4.add(vigaTiemp);
		p4.add(reempViga);
		p4.add(mayF);
		p4.add(minF);
		
		JScrollPane scroll = new JScrollPane();
		res.add(scroll);
		
		JPanel p= new JPanel(new GridLayout(5,1));
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p9);
		
		
		 
		
		this.setContentPane(p);

		this.setVisible(true);
		
		this.setBounds(600,400,800,300);

		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		//CompatibilidadVista yo= new CompatibilidadVista("Prueba");
	}

}
