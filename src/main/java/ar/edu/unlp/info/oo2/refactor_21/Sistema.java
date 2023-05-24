package ar.edu.unlp.info.oo2.refactor_21;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    List<Cliente> clientes = new ArrayList<Cliente>();
    GuiaTelefonica telefonosDisponibles = new GuiaTelefonica();

    public boolean agregarTelefono(String nuevoTelefono) {
        return this.telefonosDisponibles.agregarTelefono(nuevoTelefono);
    }

    public Cliente registrarCliente(String identificador, String nombreYApellido, String tipoCliente) {
        Cliente nuevoCliente = ClienteFactory.create(tipoCliente, nombreYApellido,
                this.telefonosDisponibles.obtenerNuevoTelefono(), identificador);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    public boolean eliminarCliente(Cliente cliente) {
        if (!this.existeCliente(cliente)) {
            return false;
        }

        this.clientes.remove(cliente);
        this.telefonosDisponibles.agregarTelefono(cliente.getTelefono());
        return true;
    }

    public Llamada registrarLlamada(Cliente emisor, Cliente receptor, String tipoLlamada, int duracion) {
        Llamada nuevaLlamada = LlamadaFactory.create(tipoLlamada, emisor.getTelefono(), receptor.getTelefono(),
                duracion);
        emisor.agregarLlamada(nuevaLlamada);
        return nuevaLlamada;
    }

    public double calcularMontoTotalLlamadas(Cliente cliente) {
        Cliente clienteEncontrado = this.clientes.stream()
                .filter(clienteActual -> clienteActual.getTelefono() == cliente.getTelefono())
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
