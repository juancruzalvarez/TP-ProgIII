package sistema.asignaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import sistema.tickets.Formulario;
import sistema.tickets.Ticket;
import sistema.tickets.TicketEmpleadoPretenso;
import sistema.tickets.TicketEmpleador;

public class Asignaciones {

    private ArrayList<TicketEmpleador> ticketsEmpleadores;
    private ArrayList<TicketEmpleadoPretenso> ticketsEmpleados;

    private RondaAsignaciones rondaAsignaciones;

    public Asignaciones(){
        ticketsEmpleadores = new ArrayList<TicketEmpleador>();
        ticketsEmpleados = new ArrayList<TicketEmpleadoPretenso>();
        rondaAsignaciones = null;
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
    public List<TicketPuntaje> getListaDeAsignaciones(Ticket ticket){
        if(rondaAsignaciones == null){
            //error
            return null;
        }else{
            return rondaAsignaciones.getListaDeAsignacion(ticket);
        }
    }


}
