package ar.edu.unlp.info.oo2.refactor_15;

import java.util.ArrayList;
import java.util.List;

public class Persoona {

    static final double descuentoJur = 0.15;
    static final double descuentoFis = 0;

	private List<Llamada> lista1 = new ArrayList<Llamada>();
	private String t;
	private String nya;
	private String tel;
	private String cuit;
	private String doc;

	public List<Llamada> getLista1() {
		return lista1;
	}
	public void setLista1(List<Llamada> lista1) {
		this.lista1 = lista1;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getNya() {
		return nya;
	}
	public void setNya(String nya) {
		this.nya = nya;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}

    public Persoona(String data, String nombre, String tel, String t) {
        if (t.equals("fisica")) {
			this.setNya(nombre);
			this.setT(t);
			this.setTel(tel);
			this.setDoc(data);
		}
		else if (t.equals("juridica")) {
			this.setNya(nombre);
			this.setT(t);
			this.setTel(tel);
			this.setCuit(data);
		}
    }

    public void agregarLlamada(Llamada nuevaLlamada) {
        this.lista1.add(nuevaLlamada);
    }

    public double calcularMontoTotalLlamadas() {
        return this.lista1
            .stream()
            .mapToDouble(llamada -> {
                double auxc = llamada.calcularMontoLlamada();

                if (this.getT() == "fisica") {
                    auxc -= auxc * descuentoFis;
                } else if(this.getT() == "juridica") {
                    auxc -= auxc * descuentoJur;
                }
                return auxc;
            })
            .sum();
    }
}
