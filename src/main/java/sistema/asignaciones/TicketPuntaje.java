package sistema.asignaciones;

import sistema.tickets.Ticket;

import java.io.Serializable;

public class TicketPuntaje implements Serializable {
    private Ticket ticket;
    private double puntaje;

    public TicketPuntaje(Ticket ticket, double puntaje) {
        this.ticket = ticket;
        this.puntaje = puntaje;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getPuntaje() {
        return puntaje;
    }

	@Override
	public String toString() {
		return " [Ticket=" + ticket + ", Puntaje=" + puntaje + "]";
	}


}
