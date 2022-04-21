package systema.tickets;

import java.time.LocalDate;

public class TicketEmpleador extends Ticket{

    private int cantEmpleadosBuscados;
    private int cantEmpleadosConseguidos;

    public TicketEmpleador(Formulario formulario, int cantEmpleadosBuscados,String nombreDeUsuario){
        super(formulario,nombreDeUsuario);
        this.cantEmpleadosBuscados = cantEmpleadosBuscados;
        this.cantEmpleadosConseguidos = 0;
    }

}
