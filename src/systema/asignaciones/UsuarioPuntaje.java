package systema.asignaciones;

import systema.usuarios.Usuario;

public class UsuarioPuntaje {
    private String usuario;
    private double puntaje;

    public UsuarioPuntaje(String usuario, double puntaje) {
        this.usuario = usuario;
        this.puntaje = puntaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getPuntaje() {
        return puntaje;
    }


}
