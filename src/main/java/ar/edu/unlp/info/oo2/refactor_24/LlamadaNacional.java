package ar.edu.unlp.info.oo2.refactor_24;

public class LlamadaNacional extends Llamada {

    private static final double PRECIO_POR_MINUTO = 3;

    public LlamadaNacional(String telefonoEmisor, String telefonoReceptor, int duracion) {
        super(telefonoEmisor, telefonoReceptor, duracion);
    }

    protected double getPrecioPorMinuto() {
        return LlamadaNacional.PRECIO_POR_MINUTO;
    }
}
