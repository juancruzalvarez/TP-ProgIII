package systema.asignaciones;

import systema.tickets.TicketEmpleadoPretenso;
import systema.tickets.TicketEmpleador;

import java.util.Random;

public class CalculoCoincidencias {

    public CalculoCoincidencias(){

    }

    public double calcularCoincidencia(TicketEmpleador empleador, TicketEmpleadoPretenso empleado){
        Random r = new Random();
        return r.nextDouble();
    }
}
