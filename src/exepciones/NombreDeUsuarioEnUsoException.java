package exepciones;

public class NombreDeUsuarioEnUsoException extends Exception {
    private String nombreDeUsuario;

    public NombreDeUsuarioEnUsoException(String arg, String nombreDeUsuario) {
        super(arg);
        this.nombreDeUsuario = nombreDeUsuario;

    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
}

