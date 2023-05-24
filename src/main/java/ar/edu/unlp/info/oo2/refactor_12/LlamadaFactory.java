package ar.edu.unlp.info.oo2.refactor_12;

public class LlamadaFactory {

    public static Llamada create(String tipo, String telefonoEmisor, String telefonoReceptor, int duracion) {
        switch (tipo) {
            case "nacional":
                return new LlamadaNacional(telefonoEmisor, telefonoReceptor, duracion);
            case "internacional":
                return new LlamadaInternacional(telefonoEmisor, telefonoReceptor, duracion);
            default:
                throw new IllegalArgumentException("'" + tipo +"' no es un tipo de llamada valido");
        }
    }
}
