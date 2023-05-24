package ar.edu.unlp.info.oo2.refactor_21;

public class LlamadaInternacional extends Llamada {
    
    private static final double PRECIO_POR_MINUTO = 200;

    public LlamadaInternacional(String telefonoEmisor, String telefonoReceptor, int duracion) {
        super(telefonoEmisor, telefonoReceptor, duracion);
    }

    protected double getPrecioPorMinuto() {
        return LlamadaInternacional.PRECIO_POR_MINUTO;
    }
}
