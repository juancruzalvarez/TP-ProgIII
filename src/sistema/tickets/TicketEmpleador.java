package sistema.tickets;

public class TicketEmpleador extends Ticket{

    private int cantEmpleadosBuscados;
    private int cantEmpleadosConseguidos;

    public TicketEmpleador(String nombreDeUsuario, Formulario formulario, int cantEmpleadosBuscados){
        super(nombreDeUsuario, formulario);
        this.cantEmpleadosBuscados = cantEmpleadosBuscados;
        this.cantEmpleadosConseguidos = 0;
    }

}
