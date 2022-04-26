package sistema.asignaciones;

import sistemaPuntaje.Iopcion;
import sistemaPuntaje.OpcionFactory;
import sistema.tickets.Formulario;
import sistema.tickets.FormularioEmpleador;
import sistema.tickets.TicketEmpleadoPretenso;
import sistema.tickets.TicketEmpleador;

public class CalculoCoincidencias {


    public double calcularCoincidencia(TicketEmpleador empleador, TicketEmpleadoPretenso empleado){
    	double puntaje=0;
    	Formulario frmempleado=empleado.getFormulario();
    	FormularioEmpleador frmempleador=(FormularioEmpleador) empleador.getFormulario();
    	
    	puntaje+=frmempleador.getPesoLocacion()*comparaOpcion(OpcionFactory.getLocacion(frmempleador.getLocacion()),OpcionFactory.getLocacion(frmempleado.getLocacion()));
    	puntaje+=frmempleador.getPesoRemuneracion()*comparaOpcion(OpcionFactory.getRemuneracion(frmempleador.getRemuneracion()),OpcionFactory.getRemuneracion(frmempleado.getRemuneracion()));
    	puntaje+=frmempleador.getPesoCargaHoraria()*comparaOpcion(OpcionFactory.getCargaHoraria(frmempleador.getCargaHoraria()),OpcionFactory.getCargaHoraria(frmempleado.getCargaHoraria()));
    	puntaje+=frmempleador.getPesoPuestoLaboral()*comparaOpcion(OpcionFactory.getPuestoLaboral(frmempleador.getPuestoLaboral()),OpcionFactory.getPuestoLaboral(frmempleado.getPuestoLaboral()));
    	puntaje+=frmempleador.getPesoRangoEtario()*comparaOpcion(OpcionFactory.getRangoEtario(frmempleador.getRangoEtario()),OpcionFactory.getRangoEtario(frmempleado.getRangoEtario()));
    	puntaje+=frmempleador.getPesoExpPrevia()*comparaOpcion(OpcionFactory.getExpPrevia(frmempleador.getExpPrevia()),OpcionFactory.getExpPrevia(frmempleado.getExpPrevia()));
    	puntaje+=frmempleador.getPesoEstudios()*comparaOpcion(OpcionFactory.getEstudios(frmempleador.getEstudios()),OpcionFactory.getEstudios(frmempleado.getEstudios()));
    	
      return puntaje;
    }
    public double comparaOpcion(Iopcion empleador,Iopcion empleado) {
    	return empleador.PuntajeOp(empleado);
    }
    
}
