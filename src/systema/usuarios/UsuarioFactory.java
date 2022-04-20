package systema.usuarios;

public class UsuarioFactory {
    public static Usuario getUsuario(TipoUsuario tipo, String usuario, String constrenia){
        switch (tipo){
            case EMPLEADOR             -> { return new Empleador(usuario, constrenia); }
            case EMPLEADO_PRETENSO     -> { return new EmpleadoPretenso(usuario, constrenia); }
            default                    -> { return null; }
        }
    }
}
