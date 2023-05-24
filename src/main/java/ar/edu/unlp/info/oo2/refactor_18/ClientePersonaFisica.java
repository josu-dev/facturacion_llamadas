package ar.edu.unlp.info.oo2.refactor_18;

public class ClientePersonaFisica extends Persoona {

    private static final double descuentoFis = 0;

    private final String doc;

    public ClientePersonaFisica(String nombreYApellido, String telefono, String documento) {
        super(nombreYApellido, telefono);
        this.doc = documento;
    }

    protected double getDescuento() {
        return ClientePersonaFisica.descuentoFis;
    }
}
