package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Enfermedad;
import domain.Sintoma;


public class SintomaTest {
	
	private Sintoma fiebre;
	private Enfermedad gripe;
	private Enfermedad ebola;
	
	@Before
	public void doBefore(){
		fiebre = new Sintoma("1","fiebre");
		gripe = new Enfermedad("1", "gripe"); 
		ebola = new Enfermedad("2", "ebola");
	}
	
	@Test
	public void sintomaSeCreaConIdYNombre(){
		
		String idEsperado = fiebre.getId();
		String nombreEsperado = fiebre.getNombre();
		
		Assert.assertEquals("1", idEsperado);
		Assert.assertEquals("fiebre", nombreEsperado);
	}
	
	@Test
	public void sintomaAgregaEnfermedadASuLista(){
		//Cuando
		fiebre.agregarEnfermedad(gripe);
		//Entonces
		Assert.assertEquals(Enfermedad.class, fiebre.getListaDeEnfermedades().get(0).getClass());
	}
	
	@Test
	public void sintomaAgregaEnfermedadYEnfermedadAgregaElMismoSintoma(){
		//Cuando
		fiebre.agregarEnfermedad(ebola);
		//Entonces
		Assert.assertEquals("fiebre", ebola.getListaDeSintomas().get(0).getNombre());
	}

}
