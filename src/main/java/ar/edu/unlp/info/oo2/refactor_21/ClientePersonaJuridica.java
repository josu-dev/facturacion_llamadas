package ar.edu.unlp.info.oo2.refactor_21;

public class ClientePersonaJuridica extends Cliente {

    private static final double DESCUENTO = 0.15;

    private final String cuit;

    public ClientePersonaJuridica(String nombreYApellido, String telefono, String cuit) {
        super(nombreYApellido, telefono);
        this.cuit = cuit;
    }

    protected double getDescuento() {
        return ClientePersonaJuridica.DESCUENTO;
    }
}
