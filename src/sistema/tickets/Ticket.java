package sistema.tickets;

import sistema.contratos.Contrato;
import sistema.contratos.Eleccion;
import sistema.usuarios.TipoUsuario;
import sistema.usuarios.Usuario;

import java.time.LocalDate;

public abstract class Ticket {
	private String nombreDeUsuario;
    private LocalDate fechaDeAlta;
    private EstadoTicket estado;
    private Formulario formulario;

    
    public Ticket(String nombreDeUsuario, Formulario formulario){
        this.fechaDeAlta = LocalDate.now();
        this.nombreDeUsuario = nombreDeUsuario;
        this.formulario = formulario;
        this.estado = EstadoTicket.ACTIVO;  //al crear el ticket arranca en activo.
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

    public String toString(){
        return "Duenio: "+ getNombreDeUsuario() + " Estado: "+getEstado() + " Formulario: "+getFormulario();
    }
    public abstract Contrato getContrato(Eleccion eleccionmutua);

   

}
