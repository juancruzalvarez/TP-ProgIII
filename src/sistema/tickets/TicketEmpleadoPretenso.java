package sistema.tickets;

import sistema.contratos.Contrato;
import sistema.contratos.Eleccion;
import sistema.usuarios.TipoUsuario;

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

}
