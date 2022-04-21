package Ticket;

import java.time.LocalDate;

public class TicketEmpleadoPretenso extends Ticket {
	private String resultado;
	
	public TicketEmpleadoPretenso(LocalDate fechadealta, EstadoTicket estado) {
		super(fechadealta, estado);
		
	}

}
