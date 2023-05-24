package ar.edu.unlp.info.oo2.refactor_18;

import java.util.ArrayList;
import java.util.List;

public abstract class Persoona {

	private final List<Llamada> lista1 = new ArrayList<Llamada>();
	private final String nya;
	private final String tel;

	public String getTel() {
		return tel;
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
