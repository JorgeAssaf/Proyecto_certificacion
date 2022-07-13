import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DataClienteTest {

	@Test
	void testIngresarCliente() {
		// fail("Not yet implemented");
		DataCliente conexion = new DataCliente();
		Variables.id = "123";
		Variables.comname = "Apple";
		Variables.contacname = "apple";
		Variables.contactitle = "steve jobs";
		Variables.address = "california";
		Variables.city = "califonia";
		Variables.reg = "estados unidos";
		Variables.postalcode = "50800";
		Variables.country = "estados unidos";
		Variables.phone = "2134556";
		Variables.fax = "24223";
		boolean var = conexion.ingresarCliente();
		assertNotNull(var);

	}

	@Test
	void testConsultarCliente() {
		// fail("Not yet implemented");
		DataCliente conexion = new DataCliente();
		boolean var = conexion.consultarCliente();
		assertNotNull(var);
	}

	@Test
	void testEliminarCliente() {
		// fail("Not yet implemented");
		DataCliente conexion = new DataCliente();
		boolean var = conexion.eliminarCliente();
		assertNotNull(var);

	}

	@Test
	void testModificarCliente() {
		// fail("Not yet implemented");
	}

}
