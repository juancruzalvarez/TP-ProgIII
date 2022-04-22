package systema.tickets;

import java.time.LocalDate;

public class TicketEmpleadoPretenso extends Ticket {
    private boolean exito;
    public TicketEmpleadoPretenso(String nombreDeUsuario, Formulario formulario){
        super(nombreDeUsuario, formulario);
        exito = false;
    }

    public boolean getExito(){
        return exito;
    }

    public void setExito(boolean exito){
        this.exito = exito;
    }
}
