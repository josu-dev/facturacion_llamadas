package ar.edu.unlp.info.oo2.refactor_17;

public class ClientePersonaFisica extends Persoona {

    private static final double descuentoFis = 0;

    private String doc;

    public ClientePersonaFisica(String nombreYApellido, String telefono, String documento) {
        super(nombreYApellido, telefono);
        this.doc = documento;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    protected double getDescuento() {
        return ClientePersonaFisica.descuentoFis;
    }
}
