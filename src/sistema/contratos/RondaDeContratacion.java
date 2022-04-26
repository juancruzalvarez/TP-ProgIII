package sistema.contratos;

import java.util.ArrayList;
import java.util.List;

import sistema.Sistema;
import sistema.tickets.EstadoTicket;
import sistema.tickets.TicketEmpleadoPretenso;
import sistema.tickets.TicketEmpleador;

public class RondaDeContratacion {


    private List<Contrato> contratos;

    public RondaDeContratacion(List<Eleccion> eleccionesMutuas){
        contratos = new ArrayList<Contrato>();
        generarContratos(eleccionesMutuas);
    }

    private void generarContratos(List<Eleccion> eleccionesMutuas){
        eleccionesMutuas.forEach(e -> {
        	Contrato aux=e.getElector().getContrato(e);
            contratos.add(aux);
            finalizaTicket(aux);
        });
    }

    public List<Contrato> getContratos(){
        return contratos;
    }
    public void finalizaTicket(Contrato contrato) {
    	
    	TicketEmpleador auxempleador=(TicketEmpleador) contrato.getTicketEmpleador();
    	TicketEmpleadoPretenso auxempleado=(TicketEmpleadoPretenso) contrato.getTicketEmpleado(); 
    	contrato.getTicketEmpleado().setEstado(EstadoTicket.FINALIZADO);
    	auxempleador.contrataEmpleado();
    	if(auxempleador.getCantEmpleadosBuscados()==auxempleador.getCantEmpleadosConseguidos())
    		auxempleador.setEstado(EstadoTicket.FINALIZADO);
    	Sistema.getInstancia().agFinalizaTicket(auxempleador, auxempleado);
    }
}
