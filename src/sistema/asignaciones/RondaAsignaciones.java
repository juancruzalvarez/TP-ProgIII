package sistema.asignaciones;

import sistema.tickets.EstadoTicket;
import sistema.tickets.Ticket;
import sistema.tickets.TicketEmpleadoPretenso;
import sistema.tickets.TicketEmpleador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RondaAsignaciones {
    private LocalDate fechaDeGeneracion;
    private Map<Ticket, List<TicketPuntaje>> listasDeAsignacion;

    public RondaAsignaciones(List<TicketEmpleadoPretenso> ticketsEmpleados, List<TicketEmpleador> ticketsEmpleadores){
        fechaDeGeneracion = LocalDate.now();
        listasDeAsignacion = new HashMap<>();
        generarListas(ticketsEmpleados, ticketsEmpleadores);
    }


    //pensar si deberia tirar exepcion o retornar null.
    public List<TicketPuntaje> getListaDeAsignacion(Ticket ticket){
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
           if(ticketEmpleado.getEstado()==EstadoTicket.ACTIVO) {
            ticketsEmpleadores.forEach( (ticketEmpleador) -> {
                //por cada par de tickets, uno de cada tipo
               if(ticketEmpleador.getEstado()==EstadoTicket.ACTIVO) {
                if(!listasDeAsignacion.containsKey(ticketEmpleado)){
                    listasDeAsignacion.put(ticketEmpleado, new ArrayList<>());
                }
                if(!listasDeAsignacion.containsKey(ticketEmpleador)) {
                    listasDeAsignacion.put(ticketEmpleador, new ArrayList<>());
                }
                double puntaje = calculadorPuntajes.calcularCoincidencia(ticketEmpleador, ticketEmpleado);
                listasDeAsignacion.get(ticketEmpleado).add(new TicketPuntaje(ticketEmpleador, puntaje));
                listasDeAsignacion.get(ticketEmpleador).add(new TicketPuntaje(ticketEmpleado, puntaje));
             }
            });
        }
        });

        //ordenar las listas
        listasDeAsignacion.forEach( (ticket, lista)-> {
            lista.sort( (a, b)-> (a.getPuntaje() > b.getPuntaje() ? -1 : 1) );
        });
        
        listasDeAsignacion.forEach( (ticket, lista)-> {
            lista.get(0).getTicket().getDuenioTicket().sumaPuntajePrimeroLista(); //suma puntaje por salir primero en la lista ya sea de empleadores o empleados
            lista.get(lista.size()).getTicket().getDuenioTicket().restaPuntajeUltimoLista(); ////resta puntaje por salir ultimo en la lista
        });
    }


}
