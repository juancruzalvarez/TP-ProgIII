package sistema.simulacion;

import sistema.Sistema;
import sistema.tickets.Formulario;
import sistema.tickets.TicketSimplificado;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

public class SimulacionEmpleador implements Runnable{

    private String nombreDeUsuario;
    private ArrayList<String> empleadosAceptados;

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public ArrayList<String> getEmpleadosAceptados() {
        return empleadosAceptados;
    }

    private static final double tiempoEntreCreacionDeEmpleos = 5.6; //en segundos
    private static final int cantMaximaDeEmpleados = 3;

    @Override
    public void run() {

        while(empleadosAceptados.size()<cantMaximaDeEmpleados){
            try {
                Thread.sleep((long)(tiempoEntreCreacionDeEmpleos*1000));
                generarEmpleos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public SimulacionEmpleador(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.empleadosAceptados = new ArrayList<>();
    }

    public void generarEmpleos(){
        Sistema sis = Sistema.getInstancia();
        Random r = new Random();
        int empleosAGenerar = r.nextInt(3) +1;
        TicketSimplificado t;
        for(int i = 0; i < empleosAGenerar;i++){

            int locacionI = r.nextInt(Formulario.locaciones.size());
            int puestoI = r.nextInt(Formulario.puestos.size());

            t = new TicketSimplificado(Formulario.puestos.get(puestoI), Formulario.locaciones.get(locacionI), this);
            sis.agSimulAgregarEmpleo(t);
        }
    }

    public synchronized boolean propuestaEmpleado(String usuario, TicketSimplificado ticket, String locacionDeseada){
        if(ticket.getLocacion().equals(locacionDeseada) || ticket.getLocacion().equals("Indistinto") || locacionDeseada.equals("Indistinto")){
            empleadosAceptados.add(usuario);
            System.out.println("El empleador " + this.nombreDeUsuario + " acepto como empleado a " + usuario);
            return true;
        }
        return false;
    }
}
