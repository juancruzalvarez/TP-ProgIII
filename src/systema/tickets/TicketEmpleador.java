package systema.tickets;

import java.time.LocalDate;

public class TicketEmpleador extends Ticket{

    private int cantEmpleadosBuscados;
    private int cantEmpleadosConseguidos;

    public TicketEmpleador(LocalDate fechaDeAlta, Formulario formulario, int cantEmpleadosBuscados){
        super(fechaDeAlta, formulario);
        this.cantEmpleadosBuscados = cantEmpleadosBuscados;
        this.cantEmpleadosConseguidos = 0;
    }

}
