package systema;

import exepciones.*;
import systema.usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Agencia {
    private static Agencia _instancia;
    private Usuario usuario_activo;
    private Map<String, Empleador> empleadores;
    private Map<String, EmpleadoPretenso> empleadosPretensos;

    private Agencia(){
        usuario_activo = null;
        empleadores = new HashMap<>();
        empleadosPretensos = new HashMap<>();
    }

    /**
     * Devuelve la instancia unica de la clase systema.Agencia.
     * Si la instancia no existe, crea una.
     * @return
     */
    public static Agencia getInstancia(){
        if(_instancia == null)
            _instancia = new Agencia();
        return _instancia;
    }

    /**
     *  Inicia session en el sistema, verificando que exista el usuario y que coincidan las contraseñas.
     * @param nombreDeUsuario
     * @param constrasenia
     */
    public void login(String nombreDeUsuario, String constrasenia) throws UsuarioInexistenteException, ContraseniaIncorrectaException {
        Usuario usr = null;
        if(empleadores.containsKey(nombreDeUsuario)){
            usr = empleadores.get(nombreDeUsuario);
        }else if(empleadosPretensos.containsKey(nombreDeUsuario)){
            usr = empleadosPretensos.get(nombreDeUsuario);
        }

        if(usr == null){
            throw new UsuarioInexistenteException("No existe ningun usuario con ese nombre de usuario.", nombreDeUsuario);
        }else if(!usr.getconstrasenia().equals(constrasenia)){
            throw new ContraseniaIncorrectaException("La constrasenia no corresponde con el nombre de usuario.");
        }
        usuario_activo = usr;
    }

    /**
     * Actualiza los datos del usuario actual siendo este del tipo empleado pretenso.
     * @param nombre
     * @param apellido
     * @param nroDeTelefono
     * @param fechaDeNacimiento
     */
    public void actualizarDatosUsuario(String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento) {
        EmpleadoPretenso usr = (EmpleadoPretenso) usuario_activo;
        usr.actualizarDatos(nombre,apellido,nroDeTelefono,fechaDeNacimiento);
    }

    /**
     * Actualiza los datos del usuario actual siendo este del tipo empleador.
     * @param nombre
     * @param tipo
     * @param rubro
     */
    public void actualizarDatosUsuario(String nombre, TipoEmpleador tipo, RubroEmpleador rubro) {
        Empleador usr = (Empleador) usuario_activo;
        usr.actualizarDatos(nombre, tipo, rubro);
    }

    /**
     *  Cierra la session actual en el sistema.
     */
    public void logout() {
        usuario_activo = null;
    }

    /**
     *  Crea un nuevo usuario del tipo indicado.
     * @param tipo
     * @param nombreDeUsuario
     * @param contraseña
     */
    public void registrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String contraseña) throws NombreDeUsuarioEnUsoException {
        if(empleadores.containsKey(nombreDeUsuario) || empleadosPretensos.containsKey(nombreDeUsuario)){
            throw new NombreDeUsuarioEnUsoException("Nombre de usuario en uso", nombreDeUsuario);
        }

        Usuario usuarioNuevo = UsuarioFactory.getUsuario(tipo, nombreDeUsuario, contraseña);
        Map map = null;
        switch(tipo) {
            case EMPLEADOR -> {
                map = empleadores;
            }
            case EMPLEADO_PRETENSO -> {
                map = empleadosPretensos;
            }
        }
        map.put(nombreDeUsuario, usuarioNuevo);

    }

    /**
     *  Muestra la lista de usuarios del tipo indicado.
     * @param tipo
     */
    public void mostrarUsuarios(TipoUsuario tipo){
        Map map = null;
        System.out.println("----------------------------------------------");
        switch (tipo){
            case EMPLEADO_PRETENSO -> {
                System.out.println("Empleados Pretensos:");
                map = empleadosPretensos;
            }
            case EMPLEADOR -> {
                System.out.println("Empleadores:");
                map = empleadores;
            }
        }
        map.forEach((key, value)-> System.out.println(value.toString()));
        System.out.println("----------------------------------------------");
    }

    /**
     *  Muestra todas las listas de usuarios.
     */
    public void mostrarUsuarios(){
        mostrarUsuarios(TipoUsuario.EMPLEADOR);
        mostrarUsuarios(TipoUsuario.EMPLEADO_PRETENSO);
    }

}
