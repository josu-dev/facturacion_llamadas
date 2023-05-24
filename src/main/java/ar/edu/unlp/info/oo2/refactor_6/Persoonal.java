package ar.edu.unlp.info.oo2.refactor_6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		var.setSis(this);
		lista1.add(var);
		return var;
	}
	
	public boolean eliminarUsuario(Persoona p) {
		List<Persoona> l = p.getSis().lista1
            .stream()
            .filter(persona -> persona != p)
            .collect(Collectors.toList());
		boolean borre = false;
		if (l.size() < lista1.size()) {
			this.lista1 = l;
			this.lista3.agregarTelefono(p.getTel());
			borre = true;
		}
		return borre;
	}
	
	public Llamada registrarLlamada(Persoona q, Persoona q2, String t, int d) {
		Llamada x = new Llamada();
		x.tipoDeLlamada = t;
		x.setEmisor(q.getTel());
		x.setRemitente(q2.getTel());
		x.dur= d;
		q.getLista1().add(x);
		return x;
	}
	
	public double calcularMontoTotalLlamadas(Persoona p) {
		double c = 0;
		Persoona aux = null;
		for (Persoona pp : lista1) {
			if (pp.getTel() == p.getTel()) {
				aux = pp;
				break;
			}
		} if (aux == null) return c;
		if (aux != null) {
			for (Llamada l : aux.getLista1()) {
				double auxc = 0;
				if (l.tipoDeLlamada == "nacional") {
					auxc += l.dur *3 + (l.dur*3*0.21);
				} else if (l.tipoDeLlamada == "internacional") {
					auxc += l.dur *200 + (l.dur*200*0.21);
				}
				
				if (aux.getT() == "fisica") {
					auxc -= auxc*descuentoFis;
				} else if(aux.getT() == "juridica") {
					auxc -= auxc*descuentoJur;
				}
				c += auxc;
			}
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return lista1.size();
	}

	public boolean existeUsuario(Persoona persona) {
		return lista1.contains(persona);
	}
	
}
