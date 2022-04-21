package systema.tickets;

import java.time.LocalDate;

public abstract class Ticket {
	private String nombreDeUsuario;
    private LocalDate fechaDeAlta;
    private EstadoTicket estado;
    private Formulario formulario;

    public Ticket(Formulario formulario,String nombreDeUsuario){
        this.fechaDeAlta =LocalDate.now();
        this.formulario = formulario;
        this.estado = EstadoTicket.ACTIVO;  //al crear el ticket arranca en activo.
        this.nombreDeUsuario=nombreDeUsuario;
    }

    // fecha de alta no cambia en la vida del ticket. No se define setter.
    public LocalDate getFechaDeAlta(){
        return fechaDeAlta;
    }

    //formulario tampoco cambia, si se quiere cambiar el formulario se crea otro ticket. Tampoco se define setter.
    public Formulario getFormulario(){
        return formulario;
    }

    public EstadoTicket getEstado(){
        return estado;
    }

    public void setEstado(EstadoTicket estado){
        this.estado = estado;
    }

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
    

}
