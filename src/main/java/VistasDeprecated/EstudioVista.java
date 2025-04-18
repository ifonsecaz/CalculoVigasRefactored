package VistasDeprecated;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class EstudioVista extends JFrame {

	protected JButton altaEstudio;
	protected JLabel meses, dias7,dias14,dias28;
	protected JTextField mesesTxt,f1,f2,f3;
	protected JTextArea infoEstudio;
	
	public EstudioVista (String titulo) {
		super(titulo);
		
		infoEstudio= new JTextArea(8,20);
		altaEstudio= new JButton("Alta Estudios");
		meses= new JLabel("Meses:");
		dias7 = new JLabel("7 dias:");
		dias14 = new JLabel("14 dias:");
		dias28 = new JLabel("28 dias");
		mesesTxt= new JTextField(5);
		f1 = new JTextField(5);
		f2 = new JTextField(5);
		f3 = new JTextField(5);
		
		JPanel p1= new JPanel(new FlowLayout());
		
		p1.add(meses);
		p1.add(mesesTxt);
		p1.add(dias7);
		p1.add(f1);
		p1.add(dias14);
		p1.add(f2);
		p1.add(dias28);
		p1.add(f3);
		p1.add(altaEstudio);
		

		JScrollPane p2 = new JScrollPane(infoEstudio);
		
		JPanel pf= new JPanel(new GridLayout(2,1));
		
		pf.add(p2);
		pf.add(p1);
		
		this.add(pf);

		this.setVisible(true);
		
		this.setBounds(600,400,600,200);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		//EstudioVista yo= new EstudioVista("Prueba");
	}

}
