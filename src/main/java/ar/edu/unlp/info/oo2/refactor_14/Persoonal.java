package ar.edu.unlp.info.oo2.refactor_14;

import java.util.ArrayList;
import java.util.List;

public class Persoonal {
	List<Persoona> lista1 = new ArrayList<Persoona>();
	GuiaTelefonica lista3 = new GuiaTelefonica();
	static double descuentoJur = 0.15;
	static double descuentoFis = 0;


    public boolean agregarTelefono(String str) {
		return this.lista3.agregarTelefono(str);
	}

	public Persoona registrarUsuario(String data, String nombre, String t) {
		Persoona var = new Persoona();
		if (t.equals("fisica")) {
			var.setNya(nombre);
			String tel = this.lista3.obtenerNuevoTelefono();
			var.setT(t);
			var.setTel(tel);
			var.setDoc(data);
		}
		else if (t.equals("juridica")) {
			String tel = this.lista3.obtenerNuevoTelefono();
			var.setNya(nombre);
			var.setT(t);
			var.setTel(tel);
			var.setCuit(data);
		}
		lista1.add(var);
		return var;
	}
	
	public boolean eliminarUsuario(Persoona p) {
        if (!this.existeUsuario(p)) {
            return false;
        }

        this.lista1.remove(p);
        this.lista3.agregarTelefono(p.getTel());
        return true;
	}
	
	public Llamada registrarLlamada(Persoona q, Persoona q2, String t, int d) {
		Llamada x = LlamadaFactory.create(t, q.getTel(), q2.getTel(), d);
		q.getLista1().add(x);
		return x;
	}
	
    public double calcularMontoTotalLlamadas(Persoona p) {
        Persoona aux = this.lista1.stream()
            .filter(personaActual -> personaActual.getTel() == p.getTel())
            .findFirst()
            .orElse(null);
        
        if (aux == null) { return 0; }

        return aux.getLista1().stream()
            .mapToDouble(llamada -> {
                double auxc = llamada.calcularMontoLlamada();

				if (aux.getT() == "fisica") {
					auxc -= auxc * descuentoFis;
				} else if(aux.getT() == "juridica") {
					auxc -= auxc * descuentoJur;
				}
                return auxc;
            })
            .sum();
	}

	public int cantidadDeUsuarios() {
		return lista1.size();
	}

	public boolean existeUsuario(Persoona persona) {
		return lista1.contains(persona);
	}
	
}
