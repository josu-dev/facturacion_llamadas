package ar.edu.unlp.info.oo2.refactor_8;

public class Llamada {
	protected final String tipoDeLlamada;
	private final String emisor;
	private final String remitente;
	public final int dur;

	public Llamada(String s, String p, String p2, int dur) {
		this.tipoDeLlamada = s;
		this.emisor= p;
		this.remitente= p2;
		this.dur = dur;
	}
    
    public double calcularMontoLlamada() {
        if (this.tipoDeLlamada == "nacional") {
            return this.dur * 3 + (this.dur * 3 * 0.21);
        } 
        else if (this.tipoDeLlamada == "internacional") {
            return this.dur * 200 + (this.dur * 200 * 0.21);
        }
        return 0;
    }
}
