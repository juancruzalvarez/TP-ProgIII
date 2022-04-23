package systema.asignaciones;

import sistemaPuntaje.Iopcion;
import systema.tickets.Formulario;
import systema.tickets.FormularioEmpleador;
import systema.tickets.TicketEmpleadoPretenso;
import systema.tickets.TicketEmpleador;

public class CalculoCoincidencias {


    public double calcularCoincidencia(TicketEmpleador empleador, TicketEmpleadoPretenso empleado){
    	double puntaje=0;
    	Formulario frmempleado=empleado.getFormulario();
    	FormularioEmpleador frmempleador=(FormularioEmpleador) empleador.getFormulario();
    	
    	puntaje+=frmempleador.getPesoLocacion()*comparaOpcion(frmempleador.getLocacion(),frmempleado.getLocacion());
    	puntaje+=frmempleador.getPesoRemuneracion()*comparaOpcion(frmempleador.getRemuneracion(),frmempleado.getRemuneracion());
    	puntaje+=frmempleador.getPesoCargaHoraria()*comparaOpcion(frmempleador.getCargaHoraria(),frmempleado.getCargaHoraria());
    	puntaje+=frmempleador.getPesoPuestoLaboral()*comparaOpcion(frmempleador.getPuestoLaboral(),frmempleado.getPuestoLaboral());
    	puntaje+=frmempleador.getPesoRangoEtario()*comparaOpcion(frmempleador.getRangoEtario(),frmempleado.getRangoEtario());
    	puntaje+=frmempleador.getPesoExpPrevia()*comparaOpcion(frmempleador.getExpPrevia(),frmempleado.getExpPrevia());
    	puntaje+=frmempleador.getPesoEstudios()*comparaOpcion(frmempleador.getEstudios(),frmempleado.getEstudios());
    	
      return puntaje;
    }
    public double comparaOpcion(Iopcion empleador,Iopcion empleado) {
    	return empleador.PuntajeOp(empleado);
    }
    
}
