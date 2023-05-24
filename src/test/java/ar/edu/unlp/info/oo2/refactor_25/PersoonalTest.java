package ar.edu.unlp.info.oo2.refactor_25;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersoonalTest {

    private static final double TOLERANCIA_MONTO_TOTAL_LLAMADAS = 0.000001;

    Sistema sistema;
    Cliente emisorPersonaFisca, remitentePersonaFisica, emisorPersonaJuridica, remitentePersonaJuridica;

    @BeforeEach
    public void setUp() {
        this.sistema = new Sistema();
        this.sistema.agregarTelefono("2214444554");
        this.sistema.agregarTelefono("2214444555");
        this.sistema.agregarTelefono("2214444556");
        this.sistema.agregarTelefono("2214444557");

        this.emisorPersonaFisca = sistema.registrarCliente("11555666", "Marcelo Tinelli", "fisica");
        this.remitentePersonaFisica = sistema.registrarCliente("00000001", "Mirtha Legrand", "fisica");
        this.emisorPersonaJuridica = sistema.registrarCliente("17555222", "Felfort", "juridica");
        this.remitentePersonaJuridica = sistema.registrarCliente("25765432", "Moovistar", "juridica");

        this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, "nacional", 10);
        this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, "internacional", 8);
        this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, "nacional", 5);
        this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, "internacional", 7);
        this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, "nacional", 15);
        this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, "internacional", 45);
        this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, "nacional", 13);
        this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, "internacional", 17);

    }

    @Test
    void testcalcularMontoTotalLlamadas() {
        assertEquals(
                this.sistema.calcularMontoTotalLlamadas(emisorPersonaFisca),
                15105.640000000001, PersoonalTest.TOLERANCIA_MONTO_TOTAL_LLAMADAS);
        assertEquals(this.sistema.calcularMontoTotalLlamadas(emisorPersonaJuridica),
                3131.7825000000003, PersoonalTest.TOLERANCIA_MONTO_TOTAL_LLAMADAS);
        assertEquals(this.sistema.calcularMontoTotalLlamadas(remitentePersonaFisica), 0);
        assertEquals(this.sistema.calcularMontoTotalLlamadas(remitentePersonaJuridica), 0);
    }

    @Test
    void testAgregarUsuario() {
        assertEquals(this.sistema.cantidadDeClientes(), 4);
        this.sistema.agregarTelefono("2214444558");
        Cliente nuevaPersona = this.sistema.registrarCliente("2444555", "Chiche Gelblung", "fisica");

        assertEquals(this.sistema.cantidadDeClientes(), 5);
        assertTrue(this.sistema.existeCliente(nuevaPersona));

    }

    @Test
    void testEliminarUsuario() {
        assertEquals(this.sistema.cantidadDeClientes(), 4);
        assertTrue(this.sistema.existeCliente(emisorPersonaFisca));
        this.sistema.eliminarCliente(emisorPersonaFisca);
        assertEquals(this.sistema.cantidadDeClientes(), 3);
        assertFalse(this.sistema.existeCliente(emisorPersonaFisca));
    }

}
