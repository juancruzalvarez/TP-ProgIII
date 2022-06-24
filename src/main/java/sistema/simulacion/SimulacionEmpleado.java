package sistema.simulacion;

import sistema.Sistema;

public class SimulacionEmpleado implements Runnable{
    /*
    *
    *
    * */

    private String locacionDeseada;
    private String puestoDeseado;
    private String nombreDeUsuario;

    public String getLocacionDeseada() {
        return locacionDeseada;
    }

    public String getPuestoDeseado() {
        return puestoDeseado;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public SimulacionEmpleado(String nombreDeUsuario, String locacionDeseada, String puestoDeseado) {
        this.locacionDeseada = locacionDeseada;
        this.puestoDeseado = puestoDeseado;
        this.nombreDeUsuario = nombreDeUsuario;
    }

    @Override
    public void run() {
        Sistema sis = Sistema.getInstancia();
        sis.agSimulBuscarEmpleo(nombreDeUsuario, locacionDeseada, puestoDeseado);
    }
}
