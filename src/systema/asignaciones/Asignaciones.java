package systema.asignaciones;

import systema.tickets.Formulario;
import systema.tickets.Ticket;
import systema.tickets.TicketEmpleadoPretenso;
import systema.tickets.TicketEmpleador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Asignaciones {

    private static Asignaciones _instancia;
    private ArrayList<TicketEmpleador> ticketsEmpleadores;
    private ArrayList<TicketEmpleadoPretenso> ticketsEmpleados;

    private RondaAsignaciones rondaAsignaciones;

    private Asignaciones(){
        ticketsEmpleadores = new ArrayList<TicketEmpleador>();
        ticketsEmpleados = new ArrayList<TicketEmpleadoPretenso>();
        rondaAsignaciones = null;
    }

    public static Asignaciones getInstancia(){
        if(_instancia == null)
            _instancia = new Asignaciones();

        return _instancia;
    }

    public void crearTicket(String nombreDeUsuario, Formulario formulario){
        ticketsEmpleados.add(new TicketEmpleadoPretenso(nombreDeUsuario, formulario));
    }

    public void crearTicket(String nombreDeUsuario, Formulario formulario, int cantEmpleadosBuscados){
        ticketsEmpleadores.add(new TicketEmpleador(nombreDeUsuario, formulario, cantEmpleadosBuscados));
    }

    public List<Ticket> getTickets(String nombreDeUsuario){
        return Stream.concat(ticketsEmpleadores.stream(), ticketsEmpleados.stream()).filter(t -> t.getNombreDeUsuario() == nombreDeUsuario).toList();
    }

    public void realizarRondaDeAsignaciones(){
        rondaAsignaciones = new RondaAsignaciones(ticketsEmpleados, ticketsEmpleadores);
    }

    //pensar si excepcion o return null. Creo que excepcion
    public List<UsuarioPuntaje> getListaDeAsignaciones(Ticket ticket){
        if(rondaAsignaciones == null){
            //error
            return null;
        }else{
            return rondaAsignaciones.getListaDeAsignacion(ticket);
        }
    }


}
