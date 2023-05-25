package ar.edu.unlp.info.oo2.facturacion_llamadas_refactorizado;

public class LlamadaInternacional extends Llamada {
    
    private static final double PRECIO_POR_MINUTO = 200;

    public LlamadaInternacional(String telefonoEmisor, String telefonoReceptor, int duracion) {
        super(telefonoEmisor, telefonoReceptor, duracion);
    }

    protected double getPrecioPorMinuto() {
        return LlamadaInternacional.PRECIO_POR_MINUTO;
    }
}
