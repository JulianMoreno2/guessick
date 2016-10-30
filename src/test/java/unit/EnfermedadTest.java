package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Enfermedad;
import domain.Sintoma;


public class EnfermedadTest {

	Enfermedad enfermedad;
	
	@Before
	public void doBefore(){
		enfermedad = new Enfermedad("1", "enfermedad");
	}
	
	@Test
	public void materiaSeCreaConIdYNombre(){		
		Assert.assertEquals("1", enfermedad.getId());
		Assert.assertEquals("enfermedad", enfermedad.getNombre());
	}
	
	@Test
	public void test(){
		//Dado
		Sintoma sintoma = new Sintoma("1", "sintoma");
		//Cuando
		enfermedad.agregarSintoma(sintoma);
		//Entonces
		Assert.assertEquals(Sintoma.class, enfermedad.getListaDeSintomas().get(0).getClass());
		
	}
}
