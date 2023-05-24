package ar.edu.unlp.info.oo2.refactor_17;

import java.util.ArrayList;
import java.util.List;

public abstract class Persoona {

	private List<Llamada> lista1 = new ArrayList<Llamada>();
	private String nya;
	private String tel;

	public List<Llamada> getLista1() {
		return lista1;
	}
	public void setLista1(List<Llamada> lista1) {
		this.lista1 = lista1;
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

    public Persoona(String nombre, String tel) {
        this.nya = nombre;
        this.tel = tel;
    }

    public void agregarLlamada(Llamada nuevaLlamada) {
        this.lista1.add(nuevaLlamada);
    }

    protected abstract double getDescuento();

    private double computarMontoLlamada(Llamada llamada) {
        return llamada.calcularMontoLlamada() * (1 - this.getDescuento());
    }

    public double calcularMontoTotalLlamadas() {
        return this.lista1
            .stream()
            .mapToDouble(llamada -> this.computarMontoLlamada(llamada))
            .sum();
    }
}
