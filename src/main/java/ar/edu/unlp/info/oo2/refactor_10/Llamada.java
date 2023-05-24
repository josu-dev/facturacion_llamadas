package ar.edu.unlp.info.oo2.refactor_10;

public abstract class Llamada {

    private static final double PORCENTAJE_IVA = 0.21;

    private final String emisor;
    private final String remitente;
    private final int dur;

    public Llamada(String p, String p2, int dur) {
        this.emisor = p;
        this.remitente = p2;
        this.dur = dur;
    }

    protected abstract double getPrecioPorMinuto();

    public double calcularMontoLlamada() {
        return this.dur * this.getPrecioPorMinuto() * (1 + Llamada.PORCENTAJE_IVA);
    }
}
