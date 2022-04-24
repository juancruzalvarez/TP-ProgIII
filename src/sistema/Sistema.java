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



    public List<Usuario> agGetUsuarios(){
        return Stream.concat(agGetUsuarios(TipoUsuario.EMPLEADOR).stream(), agGetUsuarios(TipoUsuario.EMPLEADO_PRETENSO).stream()).toList();
    }

    public List<Usuario> agGetUsuarios(TipoUsuario tipo){
        return usuarios.getUsuarios(tipo).values().stream().toList();
    }

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

    public void agRealizarRondaDeAsignaciones(){

        asignaciones.realizarRondaDeAsignaciones();
        contrataciones.iniciarRondaDeElecciones();
    }

    //dado las elecciones de los ususarios genera lista de systema.contratos.
    public void agRealizarRondaContrataciones(){
        contrataciones.realizarRondaDeContratacion();
    }

    public void usrRegistrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String contrasenia) throws NombreDeUsuarioEnUsoException {
        usuarios.registrarUsuario(tipo, nombreDeUsuario, contrasenia);
    }

    public void usrLogin(String nombreDeUsuario, String constrasenia) throws UsuarioInexistenteException, ContraseniaIncorrectaException{
        usuarios.login(nombreDeUsuario, constrasenia);
    }

    public void usrLogout(){
        usuarios.logout();
    }

    public void usrActualizarDatos(String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento){
        usuarios.actualizarDatosUsuario(nombre, apellido, nroDeTelefono, fechaDeNacimiento);
    }

    public void usrActualizarDatos(String nombre, TipoEmpleador tipo, RubroEmpleador rubro){
        usuarios.actualizarDatosUsuario(nombre, tipo, rubro);
    }

    public void usrCrearTicket(Formulario formulario){
        asignaciones.crearTicket(usuarios.getUsuarioActivo().getNombreDeUsuario(), formulario);
    }

    public void usrCrearTicket(Formulario formulario, int cantEmpleadosBuscados){
        asignaciones.crearTicket(usuarios.getUsuarioActivo().getNombreDeUsuario(), formulario, cantEmpleadosBuscados);
    }

    public List<Ticket> usrGetTickets(){
        return asignaciones.getTickets(usuarios.getUsuarioActivo().getNombreDeUsuario());
    }


    public Map<Ticket, List<TicketPuntaje>> usrGetListasDeAsignacion(){
        Map<Ticket, List<TicketPuntaje>> aux = new HashMap<>();
        asignaciones.getTickets(usuarios.getUsuarioActivo().getNombreDeUsuario())
                .forEach( ticket -> aux.put(ticket, asignaciones.getListaDeAsignaciones(ticket)) );
        return aux;
    }

    public void usrRealizarEleccion(Ticket elector, Ticket seleccion){
        contrataciones.realizarEleccion(elector, seleccion);
    }

}
