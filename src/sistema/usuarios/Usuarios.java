package sistema.usuarios;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import exepciones.ContraseniaIncorrectaException;
import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.UsuarioInexistenteException;

public class Usuarios {

   private Usuario usuarioActivo;
   private Map<String, Empleador> empleadores;
   private Map<String, EmpleadoPretenso> empleadosPretensos;
    
   public Usuarios(){
      usuarioActivo = null;
      empleadores = new HashMap<>();
      empleadosPretensos = new HashMap<>();
   }

   /**
   *  Inicia session en el sistema, verificando que exista el usuario y que coincidan las contraseñas.
   * @param nombreDeUsuario Nombre de usuario.
   * @param constrasenia Contraseña.
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
      usuarioActivo = usr;
   }

  /**
   * Actualiza los datos del usuario actual siendo este del tipo empleado pretenso.
   * @param nombre Nombre.
   * @param apellido Apellido.
   * @param nroDeTelefono  Numero de telefono.
   * @param fechaDeNacimiento Fecha de nacimiento.
   */
   public void actualizarDatosUsuario(String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento) {
      EmpleadoPretenso usr = (EmpleadoPretenso) usuarioActivo;
      usr.actualizarDatos(nombre,apellido,nroDeTelefono,fechaDeNacimiento);
   }

  /**
   * Actualiza los datos del usuario actual siendo este del tipo empleador.
   * @param nombre Nombre o razon social.
   * @param tipo  Tipo de empleador (Persona fisica o Persona juridica).
   * @param rubro Rubro al que se dedica el empleador (Salud, Comercio Internacional o Comercio Nacional).
   */
   public void actualizarDatosUsuario(String nombre, TipoEmpleador tipo, RubroEmpleador rubro) {
      Empleador usr = (Empleador) usuarioActivo;
      usr.actualizarDatos(nombre, tipo, rubro);
   }

   /**
   *  Cierra la session actual en el sistema.
   */
   public void logout() {
      usuarioActivo = null;
   }

   /**
   *  Crea un nuevo usuario del tipo indicado.
   * @param tipo
   * @param nombreDeUsuario
   * @param contraseña
   */
   public void registrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String contraseña) throws NombreDeUsuarioEnUsoException {
      if(empleadores.containsKey(nombreDeUsuario) || empleadosPretensos.containsKey(nombreDeUsuario)) {
         throw new NombreDeUsuarioEnUsoException("Nombre de usuario en uso", nombreDeUsuario);
      }
      Usuario usuarioNuevo = UsuarioFactory.getUsuario(tipo, nombreDeUsuario, contraseña);
      ((Map<String, Usuario>)(tipo == TipoUsuario.EMPLEADOR ? empleadores : empleadosPretensos)).put(nombreDeUsuario, usuarioNuevo);
   }

   public Map<String, Usuario> getUsuarios(TipoUsuario tipo){
      return (Map<String, Usuario>) (tipo == TipoUsuario.EMPLEADOR ? empleadores : empleadosPretensos);
   }

   public boolean existeUsuario(String nombreDeUsuario){
      return empleadores.containsKey(nombreDeUsuario) || empleadosPretensos.containsKey(nombreDeUsuario);
   }

   public Usuario getUsuarioActivo(){
      return usuarioActivo;
   }

}
