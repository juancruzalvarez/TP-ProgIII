package sistema.tickets;

import java.util.Map;

import sistema.Sistema;
import sistema.contratos.Contrato;
import sistema.contratos.Eleccion;
import sistema.usuarios.EmpleadoPretenso;
import sistema.usuarios.TipoUsuario;
import sistema.usuarios.Usuario;

public class TicketEmpleadoPretenso extends Ticket {
    private boolean exito;
    public TicketEmpleadoPretenso(String nombreDeUsuario, Formulario formulario){
        super(nombreDeUsuario, formulario);
        exito = false;
    }

    public boolean getExito(){
        return exito;
    }

    public void setExito(boolean exito){
        this.exito = exito;
    }

    @Override
   // public TipoUsuario getTipoDuenio() {
   //     return TipoUsuario.EMPLEADO_PRETENSO;
  //  }
    
    //si entro aca el elector es empleado
    public Contrato getContrato(Eleccion eleccionmutua) {
    	return new Contrato(eleccionmutua.getElector(),eleccionmutua.getElegido());
    }

    public Usuario getDuenioTicket() {
    	Map<String, Usuario> aux=(Map<String, Usuario>) Sistema.getInstancia().agGetUsuarios(TipoUsuario.EMPLEADO_PRETENSO);
    	EmpleadoPretenso usraux=(EmpleadoPretenso) aux.get(getNombreDeUsuario());
    	return usraux;
    	
    }
}
