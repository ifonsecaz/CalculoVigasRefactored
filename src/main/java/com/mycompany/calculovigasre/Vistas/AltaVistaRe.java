/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.calculovigasre.Vistas;

import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;
import com.mycompany.calculovigasre.ElementosLinealesCubiertas;
//import com.mycompany.calculovigasre.Controladores.AltaControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author ifons
 */
public class AltaVistaRe extends javax.swing.JFrame {
    private static CompatibilidadEnIntervencionesHistoricas d;
    /**
     * Creates new form AltaVistaRe
     */
    public AltaVistaRe(String titulo,CompatibilidadEnIntervencionesHistoricas d) {
        super(titulo);
	initComponents();	
        this.d=d;

        alta.addActionListener(new Listener8());
        altaR.addActionListener(new Listener9());
        altaP.addActionListener(new Listener9());
        altaC.addActionListener(new Listener9());
        getviga.addActionListener(new Listener10());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        altaR = new javax.swing.JButton();
        altaP = new javax.swing.JButton();
        altaC = new javax.swing.JButton();
        calTxt = new javax.swing.JTextField();
        bTxt = new javax.swing.JTextField();
        modTxt = new javax.swing.JTextField();
        claveTxt = new javax.swing.JTextField();
        reTxt = new javax.swing.JTextField();
        secTxt = new javax.swing.JTextField();
        rText = new javax.swing.JTextField();
        pText = new javax.swing.JTextField();
        cText = new javax.swing.JTextField();
        alta = new javax.swing.JButton();
        getviga = new javax.swing.JButton();
        tipoBx = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(647, 358));

        info.setColumns(20);
        info.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        info.setRows(5);
        jScrollPane1.setViewportView(info);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Calidad:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Base: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Recubrimientos:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Modulado:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sección:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Clave: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Peralte: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Claro:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Rigidez:");

        altaR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        altaR.setText("Dar de alta rigidez");
        altaR.setActionCommand("1");

        altaP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        altaP.setText("Dar de alta peralte");
        altaP.setActionCommand("2");

        altaC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        altaC.setText("Dar de alta claro");
        altaC.setActionCommand("3");

        calTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        calTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        bTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        modTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        claveTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        reTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        secTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        alta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alta.setText("Dar de alta");

        getviga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getviga.setText("Info Viga");
        getviga.setActionCommand("getviga");

        tipoBx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Trabe losa" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tipo de viga:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altaR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(altaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(altaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reTxt)
                                    .addComponent(calTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cText, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                .addComponent(rText)
                                                .addComponent(pText))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel6)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(claveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(secTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(modTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alta)
                                    .addComponent(jLabel10))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(getviga)
                                    .addComponent(tipoBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(calTxt)
                    .addComponent(bTxt))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(modTxt)
                    .addComponent(reTxt))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(secTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(getviga)
                    .addComponent(alta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaR)
                    .addComponent(jLabel9)
                    .addComponent(rText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pText, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altaP)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaC)
                    .addComponent(jLabel8)
                    .addComponent(cText))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private class Listener8 implements ActionListener{
		public void actionPerformed(ActionEvent arg8) {
			String cTxt= calTxt.getText();
			String baTxt= bTxt.getText();
			String rTxt= reTxt.getText();
			String mTxt= modTxt.getText();
			String sTxt= secTxt.getText();
						
			int cI=Integer.parseInt(cTxt);
			int baI=Integer.parseInt(baTxt);
			int sI=Integer.parseInt(sTxt);
			
			Double rI= Double.parseDouble(rTxt);
			Double mI= Double.parseDouble(mTxt);
		
			String g;
			
			ElementosLinealesCubiertas f;

                        int tipo=tipoBx.getSelectedIndex();
                        
			f=d.altaViga(tipo,cI, baI, rI, mI, sI);
		
			
			if(f!=null) {
				g=f.toString()+"\nSe registro con exito";
			}
			else {
				g="No se registro";
			}
			
			info.setText(g);
		}
	}
    
    private class Listener9 implements ActionListener{
                    public void actionPerformed(ActionEvent arg0) {
                            String peTxt= pText.getText();
                            String clTxt = cText.getText();
                            String riTxt= rText.getText();
                            String clavTxt=claveTxt.getText();
                            String f="";
                            

                            Double peI, clI,riI;

                            String r=arg0.getActionCommand();
                            
                            if(clavTxt.equals("")){
                                f="Inserta la clave";
                                info.setText(f);
                                
                            }
                            else{
                                int claveI=Integer.parseInt(clavTxt);

                                switch(r.charAt(0)) {
                                        case '1':	
                                                if(!clTxt.equals("")&&!peTxt.equals("")){
                                                    peI= Double.parseDouble(peTxt);
                                                    clI= Double.parseDouble(clTxt);

                                                    f=d.setRigidez(claveI, clI, peI);
                                                }
                                                else{
                                                    f="Se necesita el claro y el peralte";
                                                }
                                                break;
                                        case '2': 
                                                if(!clTxt.equals("")&&!riTxt.equals("")){
                                                    clI= Double.parseDouble(clTxt);
                                                    riI= Double.parseDouble(riTxt);

                                                    f=d.setPeralte(claveI, clI, riI);
                                                }
                                                else{
                                                    f="Se necesita el claro y rigidez";
                                                }
                                                break;
                                        case '3':
                                                if(!riTxt.equals("")&&!peTxt.equals("")){
                                                    peI= Double.parseDouble(peTxt);
                                                    riI= Double.parseDouble(riTxt);

                                                    f=d.setClaro(claveI, peI, riI);
                                                }
                                                else{
                                                    f="Se necesita el peralte y rigidez";
                                                }
                                                break;
                                }

                                info.setText(f);
                            }
                    }
            }
    
    private class Listener10 implements ActionListener{
		public void actionPerformed(ActionEvent arg10) {
			String cTxt= claveTxt.getText();
			
			String f;

			f=d.getUnaViga(Integer.parseInt(cTxt));

			info.setText(f);
		}
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaVistaRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaVistaRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaVistaRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaVistaRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JButton altaC;
    private javax.swing.JButton altaP;
    private javax.swing.JButton altaR;
    private javax.swing.JTextField bTxt;
    private javax.swing.JTextField cText;
    private javax.swing.JTextField calTxt;
    private javax.swing.JTextField claveTxt;
    private javax.swing.JButton getviga;
    private javax.swing.JTextArea info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField modTxt;
    private javax.swing.JTextField pText;
    private javax.swing.JTextField rText;
    private javax.swing.JTextField reTxt;
    private javax.swing.JTextField secTxt;
    private javax.swing.JComboBox<String> tipoBx;
    // End of variables declaration//GEN-END:variables
}
