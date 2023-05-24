package ar.edu.unlp.info.oo2.refactor_9;

public class LlamadaInternacional extends Llamada {

    public LlamadaInternacional(String telefonoEmisor, String telefonoReceptor, int duracion) {
        super(telefonoEmisor, telefonoReceptor, duracion);
    }

    public double calcularMontoLlamada() {
        return this.dur * 200 + (this.dur * 200 * 0.21);
    }
}
