package sistema.tickets;

import sistema.simulacion.SimulacionEmpleador;
import sistema.usuarios.Empleador;

public class TicketSimplificado {
    private String tipoDeTrabajo;
    private String locacion;
    private SimulacionEmpleador empleador;

    public TicketSimplificado(String tipoDeTrabajo, String locacion, SimulacionEmpleador empleador) {
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.locacion = locacion;
        this.empleador = empleador;
    }

    public String getTipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public String getLocacion() {
        return locacion;
    }

    public SimulacionEmpleador getEmpleador() {
        return empleador;
    }


}
