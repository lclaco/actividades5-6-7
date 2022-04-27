package validaciones;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import catalogoProductos.*;

class DetalleTest {

	
	@Test
	void testCalcularSubTotal() {
		assertTrue(Detalle.calcularSubTotal(10));
		assertFalse(Detalle.calcularSubTotal("a"));
	}

}
