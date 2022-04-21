package systema.tickets;

import java.time.LocalDate;

public class TicketEmpleadoPretenso extends Ticket {
    private boolean exito;
    public TicketEmpleadoPretenso(Formulario formulario,String nombreDeUsuario){
        super(formulario,nombreDeUsuario);
        exito = false;
    }

    public boolean getExito(){
        return exito;
    }

    public void setExito(boolean exito){
        this.exito = exito;
    }
}
