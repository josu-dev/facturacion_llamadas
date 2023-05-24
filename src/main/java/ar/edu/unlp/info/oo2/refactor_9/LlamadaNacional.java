package ar.edu.unlp.info.oo2.refactor_9;

public class LlamadaNacional extends Llamada {

    public LlamadaNacional(String telefonoEmisor, String telefonoReceptor, int duracion) {
        super(telefonoEmisor, telefonoReceptor, duracion);
    }

    public double calcularMontoLlamada() {
        return this.dur * 3 + (this.dur * 3 * 0.21);
    }
}
