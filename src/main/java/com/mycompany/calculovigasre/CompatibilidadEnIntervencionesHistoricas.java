package com.mycompany.calculovigasre;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CompatibilidadEnIntervencionesHistoricas {
	private String nomPatrimonioHistorico;
	private ElementosLinealesCubiertas[][] vigas;	//Se opto por crear una matriz de vigas, donde cada renglon representa una seccion de vigas
	private int[] modulado; //arreglo paralelo que cuenta las vigas por seccion
	private Estudios[] calidadConcreto;
	private final int ENTRAMADO_DE_VIGAS=15;  //Numero maximo de secciones
	private final int NUM_VIGAS=16; //Namero maximo de vigas por seccion
	private final int TIPOS=6; //Numero maximo que el usuario puede declarar de calidades de concreto
	private int numCalidades;
	
	public CompatibilidadEnIntervencionesHistoricas() {
		vigas = new ElementosLinealesCubiertas[ENTRAMADO_DE_VIGAS][NUM_VIGAS];
		modulado= new int[ENTRAMADO_DE_VIGAS];
		calidadConcreto= new Estudios[TIPOS];
		numCalidades=0;

		for(int i=0; i<ENTRAMADO_DE_VIGAS; i++) {
			modulado[i]=0;
		}
	}
	
	public CompatibilidadEnIntervencionesHistoricas(String nom) {
		this();
		this.nomPatrimonioHistorico=nom;
	}

	public String getNomPatrimonioHistorico() {
		return nomPatrimonioHistorico;
	}

	public void setNomPatrimonioHistorico(String nomPatrimonioHistorico) {
		this.nomPatrimonioHistorico = nomPatrimonioHistorico;
	}
        
	public boolean altaCalidad(int tipo) {
		Estudios nuevo= new Estudios(tipo);
		boolean res= false;
		int i=numCalidades;
		
		numCalidades=ManejadorArregloGenerico.insertaEnOrden(calidadConcreto, i, nuevo);
		
		if(i<numCalidades) {
			res=true;
		}
		
		return res;
	}
	
	public boolean altaEstudio(int tipo, int mes, double factor1, double factor2, double factor3) {
		boolean res=false;
		Estudios comp= new Estudios(tipo);
		int pos;
		
		pos=ManejadorArregloGenerico.busSecOrd(calidadConcreto, numCalidades, comp);
		
		if(pos>=0) {
			res=calidadConcreto[pos].altaFactor(mes, factor1, factor2, factor3);
		}
		
		return res;
	}
	
	public ElementosLinealesCubiertas altaViga(int tipoLosa, int calidadConcreto, int base, double recubrimientos,double espaciado, int seccion) {
		ElementosLinealesCubiertas res=null;
		int cantVigas=this.modulado[seccion];
		ElementosLinealesCubiertas nueva= new ElementosLinealesCubiertas(tipoLosa,calidadConcreto,base,recubrimientos,espaciado);
		
		this.modulado[seccion]=ManejadorArregloGenerico.insertaAlFinal(vigas[seccion], this.modulado[seccion], nueva);
		
		if(cantVigas<this.modulado[seccion]) {
			res=vigas[seccion][this.modulado[seccion]-1];
		}
		
		return res;
	}
	
	public String getEstudio(int tipo) {
		String res;
		int pos=0;
		
		while(pos<numCalidades&&tipo>calidadConcreto[pos].getCalidadConcreto()) {
			pos++;
		}
		
		if(pos==numCalidades||tipo!=calidadConcreto[pos].getCalidadConcreto()) {
			res= "No se encontro";
		}
		else {
			res=calidadConcreto[pos].toString();
		}
		return res;
	}
	
	public double getUnFactor(int tipo, int meses, int carga) {
		double res;
		int pos=0;
		
		while(pos<numCalidades&&tipo>calidadConcreto[pos].getCalidadConcreto()) {
			pos++;
		}
		
		if(pos==numCalidades||tipo!=calidadConcreto[pos].getCalidadConcreto()) {
			res= -1;
		}
		else {
			res=calidadConcreto[pos].getUnFactor(meses, carga);
		}
		
		return res;
	}
	
	public String getUnaViga(int clave) {
		String res="No se encontro";
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busquedaSecuencialDesordenada(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].toString();
		}
		
		return res;
	}
	
	public int getCantVigas(int n) {
		int res=0;
		
		if(n>=0 &&n<ENTRAMADO_DE_VIGAS) {
			res=modulado[n];
		}
		
		return res;
	}
	
	public boolean bajaEstudio(int tipo, int mes) {
		boolean res;
		int pos=0;
		
		while(pos<numCalidades&&calidadConcreto[pos].getCalidadConcreto()<tipo) {
			pos++;
		}
		
		if(pos==numCalidades&&calidadConcreto[pos].getCalidadConcreto()!=tipo) {
			res=false;
		}
		else {
			res=calidadConcreto[pos].bajaFactor(mes);
		}
		
		return res;
	}
	
	public boolean bajaViga(int clave) {
		boolean res=false;
		int i=0;
		int cantVigas;
		
		ElementosLinealesCubiertas comp= new ElementosLinealesCubiertas(clave);
		
		while(i<ENTRAMADO_DE_VIGAS&&!res) {
			cantVigas=modulado[i];
			modulado[i]=ManejadorArregloGenerico.eliminaOrdenado(vigas[i], modulado[i], comp);
			
			if(cantVigas>modulado[i]) {
				res=true;
			}
			else {
				i++;
			}
		}
		return res;
	}

	//A traves de la obtencion de un factor, se altera la elasticidad de una viga, y por tanto la rigidez y demas valores
	public String vigaEnElTiempo(int clave, int mes, int carga) {
		String res= "No se encontro";
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		double factor;
		int tipo;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busquedaSecuencialDesordenada(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			tipo=vigas[i-1][pos].getCalidadConcreto();
			factor=this.getUnFactor(tipo, mes, carga);
			vigas[i-1][pos].setElasticidad(factor);
			res=vigas[i-1][pos].toString();
		}
		
		return res;
	}
	
	public String reemplazaViga(int clave) {
		String res="No se encontro";
		ElementosLinealesCubiertas comp= new ElementosLinealesCubiertas(clave);
		ElementosLinealesCubiertas nueva;
		int pos=-1;
		int i=0;
		double claro;
		double rigidez;

		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busquedaSecuencialDesordenada(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
	
			nueva = new ElementosLinealesCubiertas(vigas[i-1][pos].getTipoLosa(),vigas[i-1][pos].getCalidadConcreto(),vigas[i-1][pos].getBase(),vigas[i-1][pos].getRecubrimientos(),vigas[i-1][pos].getModulado());
      
			claro=vigas[i-1][pos].getClaros();
			rigidez=vigas[i-1][pos].getRigidez();
			
			nueva.setPeralte(claro, rigidez);
			
			vigas[i-1][pos]=nueva;
			
			res=vigas[i-1][pos].toString();
		}
		
		return res;		
	}
	
	public String setRigidez(int clave, double claro, double peralte) {
		String res= "No se encontro";
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			vigas[i-1][pos].setRigidez(claro, peralte);
			res=vigas[i-1][pos].toString()+ "\n Actualizada con exito";
		}
		
		return res;
	}
	
	public String setPeralte(int clave, double claro, double rigidez) {
		String res= "No se encontro";
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			vigas[i-1][pos].setPeralte(claro, rigidez);
                        res=vigas[i-1][pos].toString() + "\n Actualizada con exito";
		}
		
		return res;
	}
		
	public String setClaro(int clave, double peralte, double rigidez) {
		String res= "No se encontro";
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			vigas[i-1][pos].setClaro(rigidez, peralte);
                        res=vigas[i-1][pos].toString() + "\n Actualizada con exito";
		}
		
		return res;
	}
	
	public double inercia(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].inercia();
		}
		
		return res;
	}
	
	public double relacionModular(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].relacionModular();
		}
		
		return res;
	}
	
	public double areaDeAcero(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].areaDeAcero();
		}
		return res;
	}
	
	public double areaDeAceroTransformada(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].areaDeAceroTransformada();
		}
		
		return res;
	}
	
	public double ejeNeutro(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].ejeNeutro();
		}
		
		return res;
	}
	
	public double inerciaDeLaSeccionAgrietada(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].inerciaDeLaSeccionAgrietada();
		}
		
		return res;
	}
	
	public double moduloDeSeccion(int clave) {
		double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].moduloDeSeccion();
		}
		
		return res;
	}
        
        public void resetCodigo(){
            ElementosLinealesCubiertas n=new ElementosLinealesCubiertas(1);
            n.resetCodigo();
        }
        
        public double ModuloDeSeccionAgrietado(int clave){
                double res= -1;
		ElementosLinealesCubiertas comp = new ElementosLinealesCubiertas(clave);
		int pos=-1; 
		int i=0;
		
		while(i<ENTRAMADO_DE_VIGAS&&pos<0) {
			pos=ManejadorArregloGenerico.busSecOrd(vigas[i], modulado[i], comp);
			i++;
		}
		if(pos>=0) {
			res=vigas[i-1][pos].ModuloDeSeccionAgrietado();
		}
		
		return res;
        }
	
	//En los siguientes dos metodos se uso el -1 como una bandera que indica que dicho tipo no tiene ningun estudio,
	//esto con motivo de evitar errores donde intentara devolveler un valor inexistente
	public double getMayFactor() {
		double res=calidadConcreto[0].getMayFactor();
		double comp;
		
		for(int i=1; i<numCalidades; i++) {
			comp=calidadConcreto[i].getMayFactor();
			if(res<comp&&comp!=-1) {
				res=comp;
			}
		}
		
		return res;
	}
	
	public double gatMinFact() {
		double res= calidadConcreto[0].gatMinFactor();
		double comp;
		
		for(int i=1; i<numCalidades; i++) {
			comp=calidadConcreto[i].gatMinFactor();
			if(res>comp&&comp!=-1) {
				res=comp;
			}
		}
		
		return res;
	}
        
        public boolean guardar(String path){
            boolean res=false;
            
            try{
                FileWriter wr = new FileWriter(path+"datos.txt");
                //myWriter.write(5);
                try (BufferedWriter myWriter = new BufferedWriter(wr)) {
                    //myWriter.write(5);
                    myWriter.write(""+numCalidades); //num estudios
                    myWriter.newLine();
                    for(int i=0;i<numCalidades;i++){
                        myWriter.write(""+calidadConcreto[i].getCalidadConcreto());
                        myWriter.newLine();
                    }
                    for(int i=0;i<numCalidades;i++){
                        myWriter.write(""+calidadConcreto[i].getMesesRegistrados());
                        myWriter.newLine();
                        myWriter.write(""+calidadConcreto[i].getCalidadConcreto());
                        myWriter.newLine();
                        for(int j=0;j<calidadConcreto[i].getMesesRegistrados();j++){
                            myWriter.write(""+calidadConcreto[i].getIntervalosTiempo(j));
                            myWriter.newLine();
                            myWriter.write(""+calidadConcreto[i].getUnFactor(calidadConcreto[i].getIntervalosTiempo(j),7));
                            myWriter.newLine();
                            myWriter.write(""+calidadConcreto[i].getUnFactor(calidadConcreto[i].getIntervalosTiempo(j),14));
                            myWriter.newLine();
                            myWriter.write(""+calidadConcreto[i].getUnFactor(calidadConcreto[i].getIntervalosTiempo(j),28));
                            myWriter.newLine();
                        }
                    }
                    myWriter.write(""+modulado.length);
                    myWriter.newLine();
                    for(int i=0;i<modulado.length;i++){
                        myWriter.write(""+modulado[i]);
                        myWriter.newLine();

                        for(int j=0;j<modulado[i];j++){
                            myWriter.write(""+vigas[i][j].getTipoLosa());
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getCalidadConcreto());
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getBase());
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getRecubrimientos());
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getModulado());
                            myWriter.newLine();
                            myWriter.write(""+i);
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getClave());
                            System.out.println(vigas[i][j].getClave());
                            myWriter.newLine();
                            myWriter.write(""+(vigas[i][j].getPeralte()+vigas[i][j].getRecubrimientos()));
                            myWriter.newLine();
                            myWriter.write(""+vigas[i][j].getClaros());
                            myWriter.newLine();
                            
                            double factor=vigas[i][j].getFactor();
                            int k=0;
                            while(k<numCalidades){
                                if(calidadConcreto[k].getCalidadConcreto()==vigas[i][j].getCalidadConcreto())
                                    break;
                                k++;
                            }
                            int[] val=calidadConcreto[k].getInfoFactor(factor);
                            myWriter.write(""+val[0]);
                            myWriter.newLine();
                            myWriter.write(""+val[1]);
                            myWriter.newLine();
                        }
                    }
                } //num estudios
                res=true;
            } catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            return res;
        }
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("\nPatrimonio Historico: " + this.nomPatrimonioHistorico);
		cad.append("\nNumero de calidades de concreto registradas: " + numCalidades);
		
		for(int i=0; i<numCalidades; i++) {
			cad.append("\n" + calidadConcreto[i].toString());
		}
		
		for(int j=0; j<ENTRAMADO_DE_VIGAS; j++) {
			for(int k=0; k<modulado[j]; k++) {
				cad.append("\n" + vigas[j][k].toString());
			}
		}
		
		return cad.toString();
	}
	
	public int compareTo(CompatibilidadEnIntervencionesHistoricas otro) {
		return this.nomPatrimonioHistorico.compareTo(otro.nomPatrimonioHistorico);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomPatrimonioHistorico == null) ? 0 : nomPatrimonioHistorico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompatibilidadEnIntervencionesHistoricas other = (CompatibilidadEnIntervencionesHistoricas) obj;
		if (nomPatrimonioHistorico == null) {
			if (other.nomPatrimonioHistorico != null)
				return false;
		} else if (!nomPatrimonioHistorico.equals(other.nomPatrimonioHistorico))
			return false;
		return true;
	}
}
