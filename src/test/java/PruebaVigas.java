
import com.mycompany.calculovigasre.ElementosLinealesCubiertas;



public class PruebaVigas {

	public static void main(String[] args) {
		ElementosLinealesCubiertas p1= new ElementosLinealesCubiertas(0,250,25,3.2,.4);
		
		System.out.println(p1.toString());
		//System.out.println(p1.setPeralte(250, 1080));
		
		p1.setRigidez(250, 56);
		
		//System.out.println(p1.setRigidez(21, 232));
		
		System.out.println(p1.areaDeAcero());
		
		System.out.println(p1.areaDeAceroTransformada());
		
		System.out.println(p1.ejeNeutro());
		
		System.out.println("inercia: " + p1.inercia());
		
		System.out.println(p1.inerciaDeLaSeccionAgrietada());
		
		System.out.println(p1.moduloDeSeccion());
		
		System.out.println(p1.relacionModular());
		
		System.out.println(p1.toString());

		p1.setElasticidad(.8);
		
		System.out.println(p1.toString());
	}

}
