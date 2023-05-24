package ar.edu.unlp.info.oo2.refactor_9;

public abstract class Llamada {

    private final String emisor;
    private final String remitente;
    public final int dur;

    public Llamada(String p, String p2, int dur) {
        this.emisor = p;
        this.remitente = p2;
        this.dur = dur;
    }

    public abstract double calcularMontoLlamada();
}
