package ar.edu.unlp.info.oo2.refactor_3;

import java.util.TreeSet;
import java.util.SortedSet;

public class GuiaTelefonica {
	private SortedSet<String> guia = new TreeSet<String>();

    public boolean agregarTelefono(String str) {
    	boolean encontre = guia.contains(str);
    	if (!encontre) {
    		guia.add(str);
    		encontre= true;
    		return encontre;
    	}
    	else {
    		encontre= false;
    		return encontre;
    	}
    }

    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
}
