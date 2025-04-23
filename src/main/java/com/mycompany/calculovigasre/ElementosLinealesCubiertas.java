package com.mycompany.calculovigasre;

public class ElementosLinealesCubiertas implements Comparable <ElementosLinealesCubiertas>{
	private int calidadConcreto;
	private int base;
        private int tipoLosa; //1 normal 2 trabelosa
        private double moduloDeSeccion;
	private double peralte; //altura de la pieza
	private double rigidez;
	private double claros; //largo de la pieza
	private double recubrimientos;  
	private int clave;
	private double inercia;
	private double modulado; //Espaciado que se deja entre cada viga al construir
	private double elasticidad;
        private double alma;
        private double factor;
	private static int codigo=1;
	private final int CALIDAD_ACERO=4200;
	private final int ELASTICIDAD_ACERO=2100000;
	private final int ELASTICIDAD_CONCRETO_II=8000;
	private final int ELASTICIDAD_CONCRETO_I=14000;
        private final double PATIN=10;
        private final double AREADEACERO_PATIN=1.42;
	

	public ElementosLinealesCubiertas(int clave) {
		//Constructor realizado para facilitar las busquedas de un objeto
		this.clave=clave;
	}
	
	public ElementosLinealesCubiertas(int tipoLosa, int calidadConcreto, int base, double recubrimientos,double modulado) {
		//Mediante el constructor se crea el objeto, pero necesita de 2 atributos dados por los set (rigidez, inercia o peralte)
		//los cuales determinan al tercero
		this.clave=codigo;
                System.out.println(this.clave);
		codigo++;
		//Pose de un generador de claves para identificar a cada objeto
		this.calidadConcreto = calidadConcreto;
		this.base = base;
		this.recubrimientos = recubrimientos;
		this.modulado=modulado;
                this.tipoLosa=tipoLosa;
                    
		this.inercia=0;
		this.peralte=0;
		this.rigidez=0;
		this.claros=0;
		this.alma=0;
                this.factor=0;
                
		if(this.calidadConcreto<=200) {
			elasticidad=ELASTICIDAD_CONCRETO_II;
		}
		else {
			elasticidad=ELASTICIDAD_CONCRETO_I;
		}
		
	}

	public int getCalidadConcreto() {
		return calidadConcreto;
	}

        public int getTipoLosa(){
            return tipoLosa;
        }
        
	public int getBase() {
		return base;
	}

	public double getPeralte() {
		return peralte;
	}

	public double getRigidez() {
		return rigidez;
	}

	public double getClaros() {
		return claros;
	}
	
	public double getModulado() {
		return modulado;
	}
	
	public double getRecubrimientos() {
		return recubrimientos;
	}
	
	public int getClave() {
		return clave;
	}

	public int getCALIDAD_ACERO() {
		return CALIDAD_ACERO;
	}

	public int getELASTICIDAD_ACERO() {
		return ELASTICIDAD_ACERO;
	}
	
	public final int getELASTICIDAD_CONCRETO_II() {
		return ELASTICIDAD_CONCRETO_II;
	}

	public final int getELASTICIDAD_CONCRETO_I() {
		return ELASTICIDAD_CONCRETO_I;
	}

	public double getElasticidad() {
		return elasticidad;
	}
        
        public double getAnchoPatin(){
            return alma;
        }
        
        public double getFactor(){
            return factor;
        }
        
        public void resetCodigo(){
            codigo=1;
        }
	
	public void setElasticidad(double factor) {
		//Con motivos de que el usuario pueda probar con diferentes factores, se decidio repetir la misma comprobacion del constructor
                this.factor=factor;
		if(this.calidadConcreto<=200) {
			elasticidad=ELASTICIDAD_CONCRETO_II*factor;
		}
		else {
			elasticidad=ELASTICIDAD_CONCRETO_I*factor;
		}
		//Para alterar sus atributos se usa del set
		this.setRigidez(this.claros, this.peralte+this.recubrimientos);
	}
	
	//Los tres sets siguientes, como se menciono al inicio, es necesario usar de uno de ellos al inicio del programa para su funcionamiento
	//dependiendo de las necesidades del usuario, puede usar del primero para obtener la rigidez de una viga ya construida, 
	//y de los otros dos para decidir alguna de las dimensiones con las que se construyo 
	public boolean setRigidez(double claro, double peralte) {
		double r;
		boolean res=false;
		
		//En las normas de construccion, el peralte debe guardar una relacion de 1:1 o 3:1 con la base
		if(peralte<=3*base&&peralte>=base) {

			this.peralte=peralte-recubrimientos;
			this.claros=claro;
                        setAlma();
                        this.inercia=this.inerciaDeLaSeccionAgrietada();
			
			r=inerciaDeLaSeccionAgrietada()/this.claros;
			
			this.rigidez=r;
			res=true;

		}
		return res;
	}
	
	//Estos dos set, comprueban que sea la primera vez en asignar los valores, para el primero se decidio no incluirlo para aprovechar el metodo,
	//al momento de calcular el cambio en la rigidez con el tiempo
	public boolean setClaro(double rigidez, double peralte) {
		boolean res=false;
		double c;
		
		if(this.rigidez==0&&this.peralte==0&&peralte<=3*base&&peralte>=base) {
			this.rigidez=rigidez;
			this.peralte=peralte-recubrimientos;
                        setAlma();
			this.inercia=this.inerciaDeLaSeccionAgrietada();
			
			c=inerciaDeLaSeccionAgrietada()/rigidez;
			
			this.claros=c;
			res=true;

		}
		
		return res;
		
	}
	
	public boolean setPeralte(double claro, double rigidez) {
		boolean res=false;
		double p;
		double r;
		
		if(this.claros==0&&this.rigidez==0) {
			this.rigidez=rigidez;
			this.claros=claro;
			
			r=(12*rigidez*claros)/base;
			
			
			p=Math.cbrt(r);
			
			this.peralte=p-recubrimientos;
			setAlma();
                        
			this.inercia=this.inerciaDeLaSeccionAgrietada();
                        
			res=true;
		}
		
		return res;
	}
	
        private void setAlma(){
            alma=peralte+recubrimientos-PATIN;
        }
        
	//Este metodo para calcular la inercia tiene valor solo como comparativa con la de la seccion agrietada, pues no considera otros factores externos
	public double inercia() {
		double res=-1;
		
		if(peralte!=0) {
			res=(base*(Math.pow(peralte, 3)))/12;
		}
		
		return res;
	}
	
	public double relacionModular() {
		double n;
		
		n=ELASTICIDAD_ACERO/(elasticidad*Math.sqrt(calidadConcreto));
		
		return n;
	}
	
	public double areaDeAcero() {
		double res;
		double fc;
		
		fc=(calidadConcreto*0.80)*0.85;
		
		res=((double)fc/CALIDAD_ACERO)*(5100.0/(6000.0+CALIDAD_ACERO))*base*peralte*0.75;
                
		
		return res;
	}
	
	public double areaDeAceroTransformada() {
		double res;
		
		res=areaDeAcero()*relacionModular();
		
		return res;
	}
	
	public double ejeNeutro() {
		double b= (2.0*relacionModular()*areaDeAcero())/(double)base;
		double c= (2.0*relacionModular()*areaDeAcero()*peralte)/(double)base;
		double res1, res2;
		double d;
		double resF;
		
		d=Math.pow(b, 2);
		d+=4.0*c;
		d=Math.sqrt(d);
		res1=((-1.0*b)+d)/2.0;
		res2=((-1.0*b)-d)/2.0;
		
		if(res1<0&&res2<0) {
			resF=-1;
		}
		else {
			if(res1>0) {
				if(res2<0) {
					resF=res1;
				}
				else {
					if(res1>res2) {
						resF=res2;
					}
					else {
						resF=res1;
					}
				}
			}
			else {
				resF=res2;
			}
		}
		
		return resF;
	}
	
	public double inerciaDeLaSeccionAgrietada() {
		double res;
		
		res=(base*(Math.pow(ejeNeutro(), 3))/3)+relacionModular()*areaDeAcero()*(Math.pow((peralte-ejeNeutro()),2));
                if(tipoLosa==2){
                    res+=2*(alma*Math.pow(PATIN,3)/3+AREADEACERO_PATIN*relacionModular()*Math.pow((ejeNeutro()-5),2));
                }
                
		return res;
	}
	
	public double moduloDeSeccion() {
		double res;
		
		res=(base*Math.pow(peralte, 2))/6;
		
		return res;
	}
        
        public double ModuloDeSeccionAgrietado(){
            double res;
            
            res=2*inercia/(peralte+recubrimientos);
            
            return res;
        }
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("\nClave: " + clave);
		cad.append("\nCalidad de concreto: " + calidadConcreto);
		cad.append("\nBase: " + base);
		cad.append("\nPeralte: " + peralte);
		cad.append("\nRigidez: " + rigidez);
		cad.append("\nInercia agrietada: " + inercia);
		cad.append("\nClaro: " + claros);
		cad.append("\nElasticidad: " + elasticidad);
		cad.append("\nRecubrimientos: " + recubrimientos);
                cad.append("\nModulo agrietado: " + ModuloDeSeccionAgrietado());
                if(tipoLosa==1){
                    cad.append("\nTipo: Trabe normal");
                }
                else{
                    cad.append("\nTipo: Trabe losa");
                    cad.append("\nAncho patín: "+alma);
                }
		
		return cad.toString();
	}
	
	public int compareTo(ElementosLinealesCubiertas otro) {
		return this.clave-otro.clave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clave;
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
		ElementosLinealesCubiertas other = (ElementosLinealesCubiertas) obj;
		if (clave != other.clave)
			return false;
		return true;
	}
}
