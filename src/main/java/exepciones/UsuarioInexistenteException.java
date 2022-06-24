package exepciones;

public class UsuarioInexistenteException extends Exception{
    private String nombreDeUsuario;
    public UsuarioInexistenteException(String arg, String nombreDeUsuario){
        super(arg);
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreDeUsuario(){
        return nombreDeUsuario;
    }
}
