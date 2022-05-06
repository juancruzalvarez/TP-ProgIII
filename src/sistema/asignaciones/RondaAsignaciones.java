package sistema.asignaciones;

import sistema.Sistema;
import sistema.tickets.*;
import sistemaPuntaje.Iopcion;
import sistemaPuntaje.OpcionFactory;

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
                double puntaje = calcularCoincidencia(ticketEmpleador, ticketEmpleado);
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
        
        Sistema agencia = Sistema.getInstancia();
        listasDeAsignacion.forEach( (ticket, lista)-> {
        	
            agencia.getDuenioTicket(lista.get(0).getTicket()).sumaPuntajePrimeroLista(); //suma puntaje por salir primero en la lista ya sea de empleadores o empleados
            agencia.getDuenioTicket(lista.get(lista.size()-1).getTicket()).restaPuntajeUltimoLista(); ////resta puntaje por salir ultimo en la lista
        });
    }

    private double calcularCoincidencia(TicketEmpleador empleador, TicketEmpleadoPretenso empleado){
        double puntaje=0;
        Formulario frmempleado=empleado.getFormulario();
        FormularioEmpleador frmempleador=(FormularioEmpleador) empleador.getFormulario();

        puntaje+=frmempleador.getPesoLocacion()*comparaOpcion(OpcionFactory.getLocacion(frmempleador.getLocacion()),OpcionFactory.getLocacion(frmempleado.getLocacion()));
        puntaje+=frmempleador.getPesoRemuneracion()*comparaOpcion(OpcionFactory.getRemuneracion(frmempleador.getRemuneracion()),OpcionFactory.getRemuneracion(frmempleado.getRemuneracion()));
        puntaje+=frmempleador.getPesoCargaHoraria()*comparaOpcion(OpcionFactory.getCargaHoraria(frmempleador.getCargaHoraria()),OpcionFactory.getCargaHoraria(frmempleado.getCargaHoraria()));
        puntaje+=frmempleador.getPesoPuestoLaboral()*comparaOpcion(OpcionFactory.getPuestoLaboral(frmempleador.getPuestoLaboral()),OpcionFactory.getPuestoLaboral(frmempleado.getPuestoLaboral()));
        puntaje+=frmempleador.getPesoRangoEtario()*comparaOpcion(OpcionFactory.getRangoEtario(frmempleador.getRangoEtario()),OpcionFactory.getRangoEtario(frmempleado.getRangoEtario()));
        puntaje+=frmempleador.getPesoExpPrevia()*comparaOpcion(OpcionFactory.getExpPrevia(frmempleador.getExpPrevia()),OpcionFactory.getExpPrevia(frmempleado.getExpPrevia()));
        puntaje+=frmempleador.getPesoEstudios()*comparaOpcion(OpcionFactory.getEstudios(frmempleador.getEstudios()),OpcionFactory.getEstudios(frmempleado.getEstudios()));

        return puntaje;
    }
    private double comparaOpcion(Iopcion empleador, Iopcion empleado) {
        return empleador.PuntajeOp(empleado);
    }


}
