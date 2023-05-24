package ar.edu.unlp.info.oo2.refactor_17;

public class ClientePersonaJuridica extends Persoona {

    private static final double descuentoJur = 0.15;

    private String cuit;

    public ClientePersonaJuridica(String nombreYApellido, String telefono, String cuit) {
        super(nombreYApellido, telefono);
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    protected double getDescuento() {
        return ClientePersonaJuridica.descuentoJur;
    }
}
