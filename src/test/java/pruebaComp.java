
import com.mycompany.calculovigasre.CompatibilidadEnIntervencionesHistoricas;



public class pruebaComp {

	public static void main(String[] args) {
		CompatibilidadEnIntervencionesHistoricas c = new CompatibilidadEnIntervencionesHistoricas("Molinos");
		
		System.out.println(c.altaCalidad(250));
		
		System.out.println(c.altaEstudio(300, 1, .6, .77, .94));
		
		System.out.println(c.altaCalidad(280));
		
		System.out.println(c.altaEstudio(280, 12, .6, .69, .42));

		System.out.println(c.altaEstudio(250, 12, .3, .38, .49));
		
		System.out.println(c.altaViga(0,250, 25, 3.2, 40, 1));
		
		System.out.println(c.altaViga(0,250, 25, 3.2, .40, 1));
		
		System.out.println(c.altaViga(0,250, 30, 3.5, 50, 2));
		
		System.out.println(c.setRigidez(1, 250, 56));
		
		System.out.println(c.toString());
		
		System.out.println(c.getUnaViga(1));
		
		System.out.println(c.getUnFactor(250, 1, 14));
		
		System.out.println(c.areaDeAcero(1));
		
		System.out.println(c.areaDeAceroTransformada(1));
	
		
		System.out.println(c.vigaEnElTiempo(1, 1, 14));

		System.out.println(c.vigaEnElTiempo(1, 12, 14));
		
		System.out.println(c.bajaEstudio(280, 12));
		
		System.out.println(c.bajaViga(3));
	
		
		System.out.println(c.toString());
		
		System.out.println(c.altaViga(0,250, 25, 3.2, .2, 3));
		
		System.out.println(c.setRigidez(4, 250, 65));
		
		System.out.println(c.getUnaViga(4));
		
		//System.out.println(c.vigaEnElTiempo(4, 250, 12, 7));
		
		//System.out.println(c.areaDeAceroTransformada(4));
		
		System.out.println(c.vigaEnElTiempo(4, 12, 14));
		
		System.out.println(c.areaDeAceroTransformada(4));
		

		//System.out.println(c.reemplazaViga(4, 12, 14));

		System.out.println(c.getMayFactor());
		
		System.out.println(c.gatMinFact());
		
		System.out.println(c.altaCalidad(350));
		
		System.out.println(c.toString());
		
		System.out.println(c.getCantVigas(1));
		
	}
		
}
