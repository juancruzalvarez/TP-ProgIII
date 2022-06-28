package sistema.simulacion;

import controlador.Controlador;
import sistema.Sistema;

public class SimulacionEmpleado implements Runnable{
    /*
    *
    *
    * */

    private String locacionDeseada;
    private String puestoDeseado;
    private String nombreDeUsuario;
    private Controlador controladorsim;

    public String getLocacionDeseada() {
        return locacionDeseada;
    }

    public String getPuestoDeseado() {
        return puestoDeseado;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public SimulacionEmpleado(String nombreDeUsuario, String locacionDeseada, String puestoDeseado,Controlador cs) {
        this.locacionDeseada = locacionDeseada;
        this.puestoDeseado = puestoDeseado;
        this.nombreDeUsuario = nombreDeUsuario;
        this.controladorsim=cs;
    }

    @Override
    public void run() {
        Sistema sis = Sistema.getInstancia();
        sis.agSimulBuscarEmpleo(nombreDeUsuario, locacionDeseada, puestoDeseado,controladorsim);
    }
}
