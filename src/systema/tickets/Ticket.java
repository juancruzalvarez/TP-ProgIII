package systema.tickets;

import java.time.LocalDate;

public abstract class Ticket {
    private LocalDate fechaDeAlta;
    private EstadoTicket estado;
    private Formulario formulario;

    public Ticket(LocalDate fechaDeAlta, Formulario formulario){
        this.fechaDeAlta = fechaDeAlta;
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

}
