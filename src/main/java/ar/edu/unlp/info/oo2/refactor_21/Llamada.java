package ar.edu.unlp.info.oo2.refactor_21;

public abstract class Llamada {

    private static final double PORCENTAJE_IVA = 0.21;

    private final String telefonoEmisor;
    private final String telefonoReceptor;
    private final int duracion;

    public Llamada(String telefonoEmisor, String telefonoReceptor, int duracion) {
        this.telefonoEmisor = telefonoEmisor;
        this.telefonoReceptor = telefonoReceptor;
        this.duracion = duracion;
    }

    protected abstract double getPrecioPorMinuto();

    public double calcularMontoLlamada() {
        return this.duracion * this.getPrecioPorMinuto() * (1 + Llamada.PORCENTAJE_IVA);
    }
}
