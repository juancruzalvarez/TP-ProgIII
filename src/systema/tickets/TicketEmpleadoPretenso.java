package systema.tickets;

import java.time.LocalDate;

public class TicketEmpleadoPretenso extends Ticket {
    private boolean exito;
    public TicketEmpleadoPretenso(LocalDate fechaDeAlta, Formulario formulario){
        super(fechaDeAlta, formulario);
        exito = false;
    }

    public boolean getExito(){
        return exito;
    }

    public void setExito(boolean exito){
        this.exito = exito;
    }
}
