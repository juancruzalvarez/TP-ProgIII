package sistema;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import exepciones.ContraseniaIncorrectaException;
import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.UsuarioInexistenteException;
import sistema.asignaciones.Asignaciones;
import sistema.asignaciones.TicketPuntaje;
import sistema.contratos.Contrataciones;
import sistema.tickets.Formulario;
import sistema.tickets.Ticket;
import sistema.usuarios.RubroEmpleador;
import sistema.usuarios.TipoEmpleador;
import sistema.usuarios.TipoUsuario;
import sistema.usuarios.Usuario;
import sistema.usuarios.Usuarios;

public class Sistema {
    private static Sistema _instancia;
    private Asignaciones asignaciones;
    private Usuarios usuarios;
    private Contrataciones contrataciones;

    private Sistema(){
        usuarios = new Usuarios();
        asignaciones = new Asignaciones();
        contrataciones = new Contrataciones();
    }

    public static Sistema getInstancia(){
        if(_instancia == null)
            _instancia = new Sistema();

        return _instancia;
    }




    /*
    //tipo trabajo
    public void agIngresarDatosTickets(){

    }
    //rango laboral
    public void agIngresarDatosTickets(){

    }
    //tipo de puestos
    public void agIngresarDatosTickets(){

    }
    */


    /**
     * Devuelve una lista con todos los usuarios registrados en el sistema,
     * tanto empleados como empleadores.
     * @return Lista de usuarios
     */
    public List<Usuario> agGetUsuarios(){
        return Stream.concat(agGetUsuarios(TipoUsuario.EMPLEADOR).stream(), agGetUsuarios(TipoUsuario.EMPLEADO_PRETENSO).stream()).toList();
    }

    /**
     * Devuelve una lista con todos los usuarios registrados en el sistema,
     * que sean del tipo indicado.
     * @param tipo Tipo de usuario del que devolver la lista.
     * @return Lista de usuarios del tipo @tipo.
     */
    public List<Usuario> agGetUsuarios(TipoUsuario tipo){
        return usuarios.getUsuarios(tipo).values().stream().toList();
    }

    /**
     *  Dado un nombre de usuario, verifica si este esta registrado. Si esto se cumple devuelve
     *  una lista con los tickets de busqueda pertenecientes al usuario.
     * @param nombreDeUsuario   Nombre de usuario del usuario del que se quieren obtener los tickets.
     * @return  Lista con los tickets pertenecientes al usuario.
     * @throws UsuarioInexistenteException En el caso de que el nombre de usuario no este registrado en el sistema.
     */
    public List<Ticket> agGetTickets(String nombreDeUsuario) throws UsuarioInexistenteException{
        if(!usuarios.existeUsuario(nombreDeUsuario)){
            throw new UsuarioInexistenteException("No existe el usuario", nombreDeUsuario);
        }
        return asignaciones.getTickets(nombreDeUsuario);
    }

    /*
    public void agCalcularComision(Contrato contrato){

    }
     */

    /**
     *  Genera listas de asignacion para cada usuario, teniendo en cuenta los tickets activos en el sistema.
     *  Tambien da comienzo a la ronda de elecciones.
     */
    public void agRealizarRondaDeAsignaciones(){

        asignaciones.realizarRondaDeAsignaciones();
        contrataciones.iniciarRondaDeElecciones();
    }

    /**
     *  Basando en las elecciones de los usuarios, genera los contratos resultantes de la ronda de contrataciones.
     */
    public void agRealizarRondaContrataciones(){
        contrataciones.realizarRondaDeContratacion();
    }

    /**
     *  Registra un usuario en el sistema.
     * @param tipo  Tipo de usuario al que registrar (empleado o empleador).
     * @param nombreDeUsuario Nombre de usuario con el que registrar al usuario.
     * @param contrasenia Contraseña del usuario.
     * @throws NombreDeUsuarioEnUsoException En el caso de que el nombre de usuario ya este en uso.
     */
    public void usrRegistrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String contrasenia) throws NombreDeUsuarioEnUsoException {
        usuarios.registrarUsuario(tipo, nombreDeUsuario, contrasenia);
    }

    /**
     *  Inicia session en el sistema, verificando que los datos coincidan con un usuario registrado.
     * @param nombreDeUsuario Nombre de usuario con el que se esta intentando iniciar session
     * @param constrasenia Contraseña correspondiente al nombre de usuario.
     * @throws UsuarioInexistenteException En el caso de que el nombre de usuario no este registrado en el sistema.
     * @throws ContraseniaIncorrectaException En el caso de que el nombre de usuario si este registrado en el sistema, pero que la contraseña indicada no le corresponda.
     */
    public void usrLogin(String nombreDeUsuario, String constrasenia) throws UsuarioInexistenteException, ContraseniaIncorrectaException{
        usuarios.login(nombreDeUsuario, constrasenia);
    }

    /**
     *  Cierra la session actual en el sistema.
     */
    public void usrLogout(){
        usuarios.logout();
    }

    /**
     *  Actualiza los datos personales del usuario activo del sistema.
     *  PRE: Existe una session y el usuario activo es del tipo empleado pretenso.
     *  POST: Los datos del usuario son remplazados por los nuevos.
     * @param nombre   Nombre
     * @param apellido  Apellido
     * @param nroDeTelefono Numero de telefono
     * @param fechaDeNacimiento Fecha de nacimiento
     */
    public void usrActualizarDatos(String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento){
        usuarios.actualizarDatosUsuario(nombre, apellido, nroDeTelefono, fechaDeNacimiento);
    }

    /**
     *  Actualiza los datos personales del usuario activo del sistema.
     *  PRE: Existe una session y el usuario activo es del tipo empleador.
     *  POST: Los datos del usuario son remplazados por los nuevos.
     * @param nombre Nombre o razon social.
     * @param tipo Persona fisica o persona juridica
     * @param rubro Rubro al que se dedica el empleador.
     */
    public void usrActualizarDatos(String nombre, TipoEmpleador tipo, RubroEmpleador rubro){
        usuarios.actualizarDatosUsuario(nombre, tipo, rubro);
    }

    /**
     *  Crea un nuevo ticket del usuario activo del sistema.
     *  PRE: Existe una session.
     *  POST: Se añade un nuevo ticket de busqueda perteneciente al usuario activo.
     * @param formulario Formulario de busqueda que compone el nuevo ticket.
     */
    public void usrCrearTicket(Formulario formulario){
        asignaciones.crearTicket(usuarios.getUsuarioActivo().getNombreDeUsuario(), formulario);
    }

    /**
     *  Crea un nuevo ticket del usuario activo del sistema.
     *  PRE: Existe una session y el usuario activo es del tipo empleador.
     *  POST: Se añade un nuevo ticket de busqueda perteneciente al usuario activo.
     * @param formulario Formulario de busqueda que compone el nuevo ticket.
     * @param cantEmpleadosBuscados Cantidad de empleados que se se quiere contratar con este ticket de busqueda.
     */
    public void usrCrearTicket(Formulario formulario, int cantEmpleadosBuscados){
        asignaciones.crearTicket(usuarios.getUsuarioActivo().getNombreDeUsuario(), formulario, cantEmpleadosBuscados);
    }

    /**
     *  Devuelve una lista compuesta por los tickets de busqueda del usuario activo.
     * @return Lista de tickets corresponientes al usuario activo.
     */
    public List<Ticket> usrGetTickets(){
        return asignaciones.getTickets(usuarios.getUsuarioActivo().getNombreDeUsuario());
    }


    /**
     *  Devuelve, por cada ticket del usuario activo, una lista de asignacion, en la cual
     *  figuran los tickets del tipo opuesto (si el usuario es empleado figuraran tickets de empleador y alrevez)
     *  ordenados por un puntaje representativo de la coincidencia que hubo entre los tickets.
     * @return Map conteniendo por cada ticket una lista de tickets con sus respectivos puntajes.
     */
    public Map<Ticket, List<TicketPuntaje>> usrGetListasDeAsignacion(){
        Map<Ticket, List<TicketPuntaje>> aux = new HashMap<>();
        asignaciones.getTickets(usuarios.getUsuarioActivo().getNombreDeUsuario())
                .forEach( ticket -> aux.put(ticket, asignaciones.getListaDeAsignaciones(ticket)) );
        return aux;
    }

    /**
     *  Realiza la seleccion del usuario dueño del ticket @elector.
     * @param elector Ticket perteneciente al usuario que elige.
     * @param seleccion Ticket elegido.
     */
    public void usrRealizarEleccion(Ticket elector, Ticket seleccion){
        contrataciones.realizarEleccion(elector, seleccion);
    }

}