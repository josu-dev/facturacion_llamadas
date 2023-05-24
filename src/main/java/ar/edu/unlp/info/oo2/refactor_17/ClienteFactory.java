package ar.edu.unlp.info.oo2.refactor_17;

public class ClienteFactory {

    public static Persoona create(String tipo, String nombreYApellido, String telefono, String cuitODocumento) {
        switch (tipo) {
            case "fisica":
                return new ClientePersonaFisica(nombreYApellido, telefono, cuitODocumento);
            case "juridica":
                return new ClientePersonaJuridica(nombreYApellido, telefono, cuitODocumento);
            default:
                throw new IllegalArgumentException("'" + tipo +"' no es un tipo de cliente valido");
        }
    }
}
