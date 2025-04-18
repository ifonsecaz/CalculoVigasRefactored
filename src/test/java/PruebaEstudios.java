
import com.mycompany.calculovigasre.Estudios;




public class PruebaEstudios {

	public static void main(String[] args) {
		Estudios e1;
		
		e1= new Estudios(210);
		
		e1.altaFactor(3, .45, .56, .7);
		e1.altaFactor(1, .60, .75, .91);
		e1.altaFactor(36, .24, .31, .39);
		e1.altaFactor(12, .3, .38, .48);
		e1.altaFactor(3, .45, .56, .7);
		
		System.out.println(e1.getUnFactor(12, 14));
		
		System.out.println(e1.getUnFactor(3, 28));
		
		System.out.println(e1.toString());

	}

}
