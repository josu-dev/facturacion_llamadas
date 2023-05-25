package ar.edu.unlp.info.oo2.facturacion_llamadas_refactorizado;

public class ClientePersonaFisica extends Cliente {

    private static final double DESCUENTO = 0;

    private final String documento;

    public ClientePersonaFisica(String nombreYApellido, String telefono, String documento) {
        super(nombreYApellido, telefono);
        this.documento = documento;
    }

    protected double getDescuento() {
        return ClientePersonaFisica.DESCUENTO;
    }
}
