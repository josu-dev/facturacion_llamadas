package ar.edu.unlp.info.oo2.refactor_9;

import java.util.TreeSet;
import java.util.SortedSet;

public class GuiaTelefonica {
	private SortedSet<String> telefonosDisponibles = new TreeSet<String>();

    public boolean agregarTelefono(String telefono) {
    	return this.telefonosDisponibles.add(telefono);
    }

    public String obtenerNuevoTelefono() {
        String telefono = this.telefonosDisponibles.last();
        this.telefonosDisponibles.remove(telefono);
        return telefono;
    }
}
