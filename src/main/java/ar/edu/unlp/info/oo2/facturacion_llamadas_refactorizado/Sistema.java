package ar.edu.unlp.info.oo2.facturacion_llamadas_refactorizado;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sistema {

    private final List<Cliente> clientes = new ArrayList<Cliente>();
    private final SortedSet<String> telefonosDisponibles = new TreeSet<String>();

    public boolean agregarTelefono(String nuevoTelefono) {
        return this.telefonosDisponibles.add(nuevoTelefono);
    }

    private String obtenerNuevoTelefono() {
        String telefono = this.telefonosDisponibles.last();
        this.telefonosDisponibles.remove(telefono);
        return telefono;
    }

    public Cliente registrarCliente(String identificador, String nombreYApellido, String tipoCliente) {
        Cliente nuevoCliente = ClienteFactory.create(tipoCliente, nombreYApellido,
                this.obtenerNuevoTelefono(), identificador);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    public boolean eliminarCliente(Cliente cliente) {
        if (!this.existeCliente(cliente)) {
            return false;
        }

        this.clientes.remove(cliente);
        this.agregarTelefono(cliente.getTelefono());
        return true;
    }

    public Llamada registrarLlamada(Cliente emisor, Cliente receptor, String tipoLlamada, int duracion) {
        return emisor.registrarLlamada(receptor, tipoLlamada, duracion);
    }

    public double calcularMontoTotalLlamadas(Cliente cliente) {
        Cliente clienteEncontrado = this.clientes.stream()
                .filter(clienteActual -> clienteActual.tieneMismoTelefonoQue(cliente))
                .findFirst()
                .orElse(null);

        if (clienteEncontrado == null) {
            return 0;
        }

        return clienteEncontrado.calcularMontoTotalLlamadas();
    }

    public int cantidadDeClientes() {
        return this.clientes.size();
    }

    public boolean existeCliente(Cliente cliente) {
        return this.clientes.contains(cliente);
    }

}
