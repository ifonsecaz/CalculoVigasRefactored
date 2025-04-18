package com.mycompany.calculovigasre;

public class Estudios implements Comparable <Estudios>{
	//En esta clase se registran estudios hechos sobre el concreto y como su elasticidad disminuye con el tiempo, y varia de acuerdo
	//al tiempo que se dejo antes de poner las cargas
	private int calidadConcreto; 
	private Double[][] modulosElasticidad;
	private int[] intervalosCarga; //Tiempo de espera antes de poner cargas sobre las vigas, el reglamento establece 7, 14 o 28 dias
	private int[] intervalosTiempo; //Tiempo tarnscurrido tras poner las cargas, al transcurrir este, la elasticidad va disminuyendo,
	//hasta llegado a cierto punto donde es casi estable
	private int mesesRegistrados;
	private final int RENGLONES=10;
	private final int COLUMNAS=3;
	
	public Estudios(int calidadConcreto) {
		this.calidadConcreto=calidadConcreto;
		modulosElasticidad= new Double[RENGLONES][COLUMNAS];
		intervalosTiempo= new int[RENGLONES];
		intervalosCarga= new int[COLUMNAS];
		mesesRegistrados=0;
		
		//Las columnas siempre seran tres, cada factor debe guardar relacion con su intervalo de carga
		intervalosCarga[0]=7;
		intervalosCarga[1]=14;
		intervalosCarga[2]=28;
		
		for(int i=0; i<RENGLONES; i++) {
			intervalosTiempo[i]=0;
		}
	}

	public int getCalidadConcreto() {
		return calidadConcreto;
	}
	
	public int getMesesRegistrados() {
		return mesesRegistrados;
	}
	
	//Para obtener un factor se realizan dos busquedas ordenadas en los arreglos de intervalos de tiempo y cargas, obteniendo de estos
	//una especie de coordenadas
	public double getUnFactor(int meses, int carga) {
		double res;
		int i=0;
		int pos=0;
		
		while(i<mesesRegistrados&&meses>intervalosTiempo[i]) {
			i++;
		}
		
		if(i==mesesRegistrados||meses!=intervalosTiempo[i]) {
			res=-1;
		}
		else {
			while(pos<COLUMNAS&&carga>intervalosCarga[pos]) {
				pos++;
			}
			if(pos==COLUMNAS||carga!=intervalosCarga[pos]) {
				res=-1;
			}
			else {
				res=modulosElasticidad[i][pos];
			}
			
		}
		return res;
	}
	
	//Para dar de alta los resultados de un estudio, el usuario debe dar los tres factores y a que intervalo de tiempo representan
	public boolean altaFactor(int mes, double factor1, double factor2, double factor3) {
		boolean res=false;
		int pos=0;
		int ind1=mesesRegistrados;
		int ind2=mesesRegistrados-1;
		
		if(mesesRegistrados<RENGLONES) {
			while(pos<mesesRegistrados&&mes>intervalosTiempo[pos]) {
				pos++;
			}
			//De acuerdo al intervalo de tiempo, tanto los factores como el arreglo de meses se ordena
			if(pos==mesesRegistrados||mes!=intervalosTiempo[pos]) {
				for(int i=pos; i<mesesRegistrados; i++) {
					intervalosTiempo[ind1]=intervalosTiempo[ind2];
					
					for(int j=0; j<COLUMNAS; j++) {
						modulosElasticidad[ind1][j]=modulosElasticidad[ind2][j];
					}
					
					ind1--;
					ind2--;
				}
				mesesRegistrados++;
				intervalosTiempo[pos]=mes;
				modulosElasticidad[pos][0]=factor1;
				modulosElasticidad[pos][1]=factor2;
				modulosElasticidad[pos][2]=factor3;
				res=true;
			}
		}
		return res;
	}
	
	public boolean bajaFactor(int mes) {
		boolean res;
		int pos=0;
		
		while(pos<mesesRegistrados&&intervalosTiempo[pos]<mes) {
			pos++;
		}
		
		if(pos==mesesRegistrados||intervalosTiempo[pos]!=mes) {
			res=false;
		}
		else {
			//Los valores se recorren
			for(int i=pos; i<mesesRegistrados;i++) {
				intervalosTiempo[i]=intervalosTiempo[i+1];
				
				for(int j=0; j<COLUMNAS; j++) {
					modulosElasticidad[i][j]=modulosElasticidad[i+1][j];
				}
			}
			
			mesesRegistrados--;
			
			intervalosTiempo[mesesRegistrados]=0;
			
			for(int k=0; k<COLUMNAS; k++) {
				modulosElasticidad[mesesRegistrados][k]=0.0;
			}
			res=true;
		}
		return res;
	}
	
	public double getMayFactor() {
		int[] pos;
		double res=-1;
				
		if(mesesRegistrados>0) {
				pos=ManejadorMatricesGenerico.posMayor(modulosElasticidad, mesesRegistrados, COLUMNAS);
				res=modulosElasticidad[pos[0]][pos[1]];
		}
		return res;
	}
	
	public double gatMinFactor() {
		int[] pos;
		double res=-1;
		
		if(mesesRegistrados>0) {
			pos=ManejadorMatricesGenerico.posMenor(modulosElasticidad, mesesRegistrados, COLUMNAS);
			res=modulosElasticidad[pos[0]][pos[1]];
		}
		
		return res;
	}
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("\nTipo: " + calidadConcreto);
		cad.append("\nMeses Registrados: " + mesesRegistrados);
		cad.append("\n");
		cad.append("\t");
		
		for(int i=0; i<COLUMNAS; i++) {
			cad.append("\t" + intervalosCarga[i]);
		}
		cad.append("\n");
		
		for(int j=0; j<mesesRegistrados; j++) {
			cad.append("\t" + intervalosTiempo[j]);
			for(int k=0; k<COLUMNAS; k++) {
				cad.append("\t" + modulosElasticidad[j][k]);
			}
			cad.append("\n");
		}
		
		return cad.toString();
	}
	
	public int compareTo(Estudios otro) {
		return this.calidadConcreto-otro.calidadConcreto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calidadConcreto;
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
		Estudios other = (Estudios) obj;
		if (calidadConcreto != other.calidadConcreto)
			return false;
		return true;
	}
}
