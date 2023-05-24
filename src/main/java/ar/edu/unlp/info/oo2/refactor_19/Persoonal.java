package ar.edu.unlp.info.oo2.refactor_19;

import java.util.ArrayList;
import java.util.List;

public class Persoonal {

    List<Cliente> lista1 = new ArrayList<Cliente>();
    GuiaTelefonica lista3 = new GuiaTelefonica();

    public boolean agregarTelefono(String str) {
        return this.lista3.agregarTelefono(str);
    }

    public Cliente registrarUsuario(String data, String nombre, String t) {
        Cliente var = ClienteFactory.create(t, nombre, this.lista3.obtenerNuevoTelefono(), data);
        lista1.add(var);
        return var;
    }

    public boolean eliminarUsuario(Cliente p) {
        if (!this.existeUsuario(p)) {
            return false;
        }

        this.lista1.remove(p);
        this.lista3.agregarTelefono(p.getTelefono());
        return true;
    }

    public Llamada registrarLlamada(Cliente q, Cliente q2, String t, int d) {
        Llamada x = LlamadaFactory.create(t, q.getTelefono(), q2.getTelefono(), d);
        q.agregarLlamada(x);
        return x;
    }

    public double calcularMontoTotalLlamadas(Cliente p) {
        Cliente aux = this.lista1.stream()
                .filter(personaActual -> personaActual.getTelefono() == p.getTelefono())
                .findFirst()
                .orElse(null);

        if (aux == null) {
            return 0;
        }

        return aux.calcularMontoTotalLlamadas();
    }

    public int cantidadDeUsuarios() {
        return lista1.size();
    }

    public boolean existeUsuario(Cliente persona) {
        return lista1.contains(persona);
    }

}
