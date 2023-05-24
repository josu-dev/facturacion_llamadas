package ar.edu.unlp.info.oo2.refactor_4;

import java.util.TreeSet;
import java.util.SortedSet;

public class GuiaTelefonica {
	private SortedSet<String> guia = new TreeSet<String>();

    public boolean agregarTelefono(String str) {
    	return this.guia.add(str);
    }

    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
}
