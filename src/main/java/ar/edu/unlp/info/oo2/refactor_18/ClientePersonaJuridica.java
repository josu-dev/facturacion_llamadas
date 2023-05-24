package ar.edu.unlp.info.oo2.refactor_18;

public class ClientePersonaJuridica extends Persoona {

    private static final double descuentoJur = 0.15;

    private final String cuit;

    public ClientePersonaJuridica(String nombreYApellido, String telefono, String cuit) {
        super(nombreYApellido, telefono);
        this.cuit = cuit;
    }

    protected double getDescuento() {
        return ClientePersonaJuridica.descuentoJur;
    }
}
