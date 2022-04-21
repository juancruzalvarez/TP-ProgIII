package Ticket;

import java.time.LocalDate;

public class TicketEmpleador extends Ticket {
private int empsolicitados; //cantidad de empleados solicitados
private int empobtenidos;  //cantidad de empleados obtenidos

	
	
	public TicketEmpleador(LocalDate fechadealta, EstadoTicket estado,int empsolicitados) {
		super(fechadealta, estado);
		this.empsolicitados=empsolicitados;
	}

}
