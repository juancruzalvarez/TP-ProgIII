package sistema.contratos;

import java.util.List;

import exepciones.TicketNoActivoException;
import sistema.tickets.EstadoTicket;
import sistema.tickets.Ticket;

public class Contrataciones {
    private RondaDeElecciones rondaDeElecciones;
    private RondaDeContratacion rondaDeContratacion;

    public Contrataciones(){
        rondaDeElecciones = null;
        rondaDeContratacion = null;
    }

    /**
     *  Da comienzo a una nueva ronda de elecciones, eliminando cualquier eleccion previa.
     */
    public void iniciarRondaDeElecciones(){
        rondaDeElecciones = new RondaDeElecciones();
    }

    /**
     *  En base a las elecciones realizadas por los usuarios en la ronda de elecciones, genera una lista de contratos.
     *
     */
    public void realizarRondaDeContratacion(){
        rondaDeContratacion = new RondaDeContratacion(rondaDeElecciones.getEleccionesMutuas());
    }

    /**
     *  Agrega una nueva eleccion a la ronda de elecciones.
     * @param elector Ticket perteneciente al usuario que esta realizando la eleccion
     * @param elegido Ticket elegido.
     * @throws TicketNoActivoException 
     */
    public void realizarEleccion(Ticket elector, Ticket elegido) throws TicketNoActivoException{
    	if(elector.getEstado()==EstadoTicket.ACTIVO ) {
            if (elegido.getEstado() == EstadoTicket.ACTIVO)
                rondaDeElecciones.agregarEleccion(elector, elegido);
            else
                throw new TicketNoActivoException("El ticket que se eligio para realizar un contrato ya no esta Activo");
        }else
    		throw new TicketNoActivoException("Su ticket no esta Activo");
        }

    /**
     *  Devuelve una lista con los contratos generados en la ronda de contratacion.
     * @return Lista de contratos generada.
     */
    public List<Contrato> getContratos(){
        return rondaDeContratacion.getContratos();
    }

}