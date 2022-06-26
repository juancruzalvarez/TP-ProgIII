package sistema;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import exepciones.ContraseniaIncorrectaException;
import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.TicketNoActivoException;
import exepciones.UsuarioInexistenteException;
import sistema.asignaciones.Asignaciones;
import sistema.asignaciones.TicketPuntaje;
import sistema.contratos.Contrataciones;
import sistema.contratos.Contrato;
import sistema.simulacion.SimulacionEmpleado;
import sistema.simulacion.SimulacionEmpleador;
import sistema.tickets.EstadoTicket;
import sistema.tickets.Formulario;
import sistema.tickets.Ticket;
import sistema.tickets.TicketEmpleadoPretenso;
import sistema.tickets.TicketEmpleador;
import sistema.tickets.TicketSimplificado;
import sistema.usuarios.EmpleadoPretenso;
import sistema.usuarios.Empleador;
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

    private List<TicketSimplificado> bolsaDeTrabajo;
    private List<Thread> threadsSimulacion;
    private Sistema(){
        usuarios = new Usuarios();
        asignaciones = new Asignaciones();
        contrataciones = new Contrataciones();
        bolsaDeTrabajo = new ArrayList<>();
        threadsSimulacion = new ArrayList<>();
    }

    public static Sistema getInstancia(){
        if(_instancia == null)
            _instancia = new Sistema();

        return _instancia;
    }

    //Metodos para persistencia

    public void write(){
        try {
            asignaciones.write();
            usuarios.write();
            contrataciones.write();
        } catch (IOException e) {
            System.out.println("No fue posible crear los archivos de persistencia.");
            throw new RuntimeException(e);
        }
    }

    public void read() {

        try {
            asignaciones.read();
            usuarios.read();
            contrataciones.read();
        } catch (IOException e) {
            System.out.println("No fue posible abrir los archivos de persicencia.");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void agComenzarSimulacion(){
        bolsaDeTrabajo.clear();
        Random r = new Random();
        List<SimulacionEmpleador> empleadoresSimulados =
                        usuarios.getUsuarios(TipoUsuario.EMPLEADOR)
                        .values()
                        .stream()
                        .map(u ->{
                            return new SimulacionEmpleador(u.getNombreDeUsuario());
                        }
                        ).toList();

        List<SimulacionEmpleado> empleadosSimulados =
                        usuarios.getUsuarios(TipoUsuario.EMPLEADO_PRETENSO)
                        .values()
                        .stream()
                        .map(u ->{
                            return new SimulacionEmpleado(
                                u.getNombreDeUsuario(),
                                Formulario.locaciones.get(r.nextInt(Formulario.locaciones.size())),
                                Formulario.puestos.get(r.nextInt(Formulario.puestos.size()))
                            );
                        }
                        ).toList();
        threadsSimulacion.addAll(empleadosSimulados.stream().map(e -> new Thread(e)).toList());
        threadsSimulacion.addAll(empleadoresSimulados.stream().map(e -> new Thread(e)).toList());
        threadsSimulacion.forEach(t -> t.start());
        System.out.println("Simulacion comenzada:" + threadsSimulacion.size());
    }

    public void agSimulAgregarEmpleo(TicketSimplificado ticket){

        synchronized(bolsaDeTrabajo) {
            bolsaDeTrabajo.add(ticket);
            bolsaDeTrabajo.notifyAll();
        }
    }

    public void agSimulBuscarEmpleo(String usuario, String locacionDeseada, String puestoDeseado){
        synchronized(bolsaDeTrabajo) {
            int cantEmpleos = bolsaDeTrabajo.size();
            boolean encontrado = false;
            int solicitudes = 0;
            while (!encontrado && solicitudes < 10) {
                TicketSimplificado t = bolsaDeTrabajo.stream().filter(ti -> ti.getTipoDeTrabajo().equals(puestoDeseado)).findFirst().orElse(null);
                if (t != null) {
                    solicitudes++;
                    if(t.getEmpleador().propuestaEmpleado(usuario, t, locacionDeseada)){
                        bolsaDeTrabajo.remove(t);
                        encontrado = true;
                        System.out.println("Usuario "+usuario+"encontro empleo. Empleador:" +t.getEmpleador().getNombreDeUsuario());
                    }
                }
                while (cantEmpleos == bolsaDeTrabajo.size()) {
                    try {
                        bolsaDeTrabajo.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("El usuario "+ usuario + "abandono la busqueda de empleo.");
        }
    }

    public void agFinalizarSimulacion(){
        //noinspection removal
        threadsSimulacion.forEach(t -> t.stop());
    }

    public void agFinalizaTicket(TicketEmpleador tEmpleador, TicketEmpleadoPretenso tEmpleado) {
        Empleador usrempleador =(Empleador) getDuenioTicket(tEmpleador);
    	EmpleadoPretenso usrempleado=(EmpleadoPretenso) getDuenioTicket(tEmpleado);
    	usrempleador.sumaPuntaje(10);
    	usrempleado.sumaPuntaje(50);

    }

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
    
    public String agCalcularComision(Contrato contrato){
        double comisionempleador=0,comisionempleado=0;

        Formulario frmempleado=contrato.getTicketEmpleado().getFormulario();
        Empleador usrempleador=(Empleador) getDuenioTicket(contrato.getTicketEmpleador());
        EmpleadoPretenso usrempleado=(EmpleadoPretenso) getDuenioTicket(contrato.getTicketEmpleado());

        switch(usrempleador.getRubro()) {
        case SALUD: comisionempleador=0.6;break;
        case COMERCIO_LOCAL: comisionempleador=0.7;break;
        case COMERCIO_INTERNACIONAL:comisionempleador=0.8;break;
        }
        if(usrempleador.getTipoEmpleador()==TipoEmpleador.PERSONA_JURIDICA)
            comisionempleador+=0.2;
        comisionempleador-=usrempleador.getPuntaje()/100;

        switch(frmempleado.getPuesto()) {
        case "Junior": comisionempleado=0.8;break;
        case "Senior": comisionempleado=0.9;break;
        case "Gerencial":comisionempleado=1;break;
        }
        comisionempleado-=usrempleado.getPuntaje()/100;

        return ("La comsion que se le cobrara al empleador "+ usrempleador.getNombre() +" es de: "+comisionempleador*100+"% del sueldo\n"
        		+ " pretendido, por contratar al empleado "
                + usrempleado.getNombre()+ ", al cual se le cobrara una comsion de "+comisionempleado*100+"% del sueldo pretendido.\n");
    }

    public List<Contrato> agGetContratos(){
        return contrataciones.getContratos();
    }
    public String agGetUsernameActivo(){
    	return this.usuarios.getUsuarioActivo().getNombreDeUsuario();
    }

    public void agRealizarRondaDeAsignaciones(){

        asignaciones.realizarRondaDeAsignaciones();
        contrataciones.iniciarRondaDeElecciones();
    }

    //dado las elecciones de los usuarios genera lista de systema.contratos.
    public void agRealizarRondaContrataciones(){
        contrataciones.realizarRondaDeContratacion();
    }
    public void usrSuspenderTicket(Ticket ticket) {
    	if(ticket.getNombreDeUsuario().equals(usuarios.getUsuarioActivo().getNombreDeUsuario())&&ticket.getEstado()!=EstadoTicket.CANCELADO && ticket.getEstado()!=EstadoTicket.FINALIZADO) {
    		ticket.setEstado(EstadoTicket.SUSPENDIDO);
    	}	
    }
    
    
    public void usrFinalizarTicket(Ticket ticket) {
    	if(ticket.getNombreDeUsuario().equals(usuarios.getUsuarioActivo().getNombreDeUsuario())&&ticket.getEstado()!=EstadoTicket.FINALIZADO) {
    		ticket.setEstado(EstadoTicket.CANCELADO);
    		Usuario usraux = getDuenioTicket(ticket);
    		usraux.restaPuntaje(1);
    	//tirar Exception?
    		//agregar pre para mi.
    	}	
    }
    public void usrActivarTicket(Ticket ticket) {
    	if(ticket.getNombreDeUsuario().equals(usuarios.getUsuarioActivo().getNombreDeUsuario()) &&ticket.getEstado()!=EstadoTicket.CANCELADO &&ticket.getEstado()!=EstadoTicket.FINALIZADO) {
    		ticket.setEstado(EstadoTicket.ACTIVO);
    
    	}
    }
    public void usrRegistrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String contrasenia) throws NombreDeUsuarioEnUsoException {
        usuarios.registrarUsuario(tipo, nombreDeUsuario, contrasenia);
    }

    public int usrLogin(String nombreDeUsuario, String constrasenia) throws UsuarioInexistenteException, ContraseniaIncorrectaException{
        return usuarios.login(nombreDeUsuario, constrasenia);
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
    public List<TicketPuntaje> usrGetTicketPosiblesEmpleados(Ticket ticket){
    	return asignaciones.getListaDeAsignaciones(ticket);
    }

    public void usrRealizarEleccion(Ticket elector, Ticket seleccion) throws TicketNoActivoException{
        contrataciones.realizarEleccion(elector, seleccion);
    }


    public Usuario getDuenioTicket(Ticket t) {
        return usuarios.getUsuario(t.getNombreDeUsuario());
    }

}
