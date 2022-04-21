package Ticket;

import java.time.LocalDate;

public abstract class Ticket {
	private LocalDate fechadealta;
	private EstadoTicket estado;
	private Formulario formulario;
	
	
	public Ticket(LocalDate fechadealta, EstadoTicket estado) {
		super();
		this.fechadealta = fechadealta;
		this.estado = estado;
	}
	public EstadoTicket getEstado() {
		return estado;
	}
	public void setEstado(EstadoTicket estado) {
		this.estado = estado;
	}
	public LocalDate getFechadealta() {
		return fechadealta;
	}
	
	
}
