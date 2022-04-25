package sistema.usuarios;

public abstract class Usuario {
    protected String nombreDeUsuario;
    protected String constrasenia;
    protected int puntaje;
   
    

    public Usuario(String nombreDeUsuario, String constrasenia){
        this.nombreDeUsuario = nombreDeUsuario;
        this.constrasenia = constrasenia;
        puntaje = 0;
    }

    public abstract TipoUsuario getTipo();

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getconstrasenia() {
        return constrasenia;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

}