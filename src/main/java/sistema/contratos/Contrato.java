package sistema.contratos;

import sistema.tickets.Ticket;

import java.io.Serializable;

public class Contrato implements Serializable {
    private Ticket ticketEmpleado;
    private Ticket ticketEmpleador;

    public Contrato(Ticket ticketEmpleado, Ticket ticketEmpleador){
        this.ticketEmpleado = ticketEmpleado;
        this.ticketEmpleador = ticketEmpleador;
    }

    public Ticket getTicketEmpleado(){
        return ticketEmpleado;
    }

    public Ticket getTicketEmpleador(){
         return ticketEmpleador;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "ticketEmpleado=" + ticketEmpleado +
                ", ticketEmpleador=" + ticketEmpleador +
                '}';
    }
}
