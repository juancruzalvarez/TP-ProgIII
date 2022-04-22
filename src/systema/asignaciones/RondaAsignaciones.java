package systema.asignaciones;

import systema.tickets.Ticket;
import systema.tickets.TicketEmpleadoPretenso;
import systema.tickets.TicketEmpleador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RondaAsignaciones {
    private LocalDate fechaDeGeneracion;
    private Map<Ticket, List<UsuarioPuntaje>> listasDeAsignacion;

    public RondaAsignaciones(List<TicketEmpleadoPretenso> ticketsEmpleados, List<TicketEmpleador> ticketsEmpleadores){
        fechaDeGeneracion = LocalDate.now();
        listasDeAsignacion = new HashMap<>();
        generarListas(ticketsEmpleados, ticketsEmpleadores);
    }


    //pensar si deberia tirar exepcion o retornar null.
    public List<UsuarioPuntaje> getListaDeAsignacion(Ticket ticket){
        if(!listasDeAsignacion.containsKey(ticket)){
            //no hay lista de asignacion para el ticket.
            return null;
        }else{
            return listasDeAsignacion.get(ticket);
        }
    }

    public LocalDate getFechaDeGeneracion(){
        return fechaDeGeneracion;
    }

    private void generarListas(List<TicketEmpleadoPretenso> ticketsEmpleados, List<TicketEmpleador> ticketsEmpleadores){
        CalculoCoincidencias calculadorPuntajes = new CalculoCoincidencias();
        ticketsEmpleados.forEach( (ticketEmpleado) -> {
            ticketsEmpleadores.forEach( (ticketEmpleador) -> {
                //por cada par de tickets, uno de cada tipo

                if(!listasDeAsignacion.containsKey(ticketEmpleado)){
                    listasDeAsignacion.put(ticketEmpleado, new ArrayList<>());
                }
                if(!listasDeAsignacion.containsKey(ticketEmpleador)) {
                    listasDeAsignacion.put(ticketEmpleador, new ArrayList<>());
                }
                double puntaje = calculadorPuntajes.calcularCoincidencia(ticketEmpleador, ticketEmpleado);
                listasDeAsignacion.get(ticketEmpleado).add(new UsuarioPuntaje(ticketEmpleador.getNombreDeUsuario(), puntaje));
                listasDeAsignacion.get(ticketEmpleador).add(new UsuarioPuntaje(ticketEmpleado.getNombreDeUsuario(), puntaje));
            });
        });

        //ordenar las listas
        listasDeAsignacion.forEach( (ticket, lista)-> {
            lista.sort( (a, b)-> (a.getPuntaje() > b.getPuntaje() ? -1 : 1) );
        });
    }


}
