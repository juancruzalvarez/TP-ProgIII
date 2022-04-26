package sistema.tickets;

import sistema.contratos.Contrato;
import sistema.contratos.Eleccion;
import sistema.usuarios.TipoUsuario;

public class TicketEmpleador extends Ticket{

    private int cantEmpleadosBuscados;
    private int cantEmpleadosConseguidos;

    public TicketEmpleador(String nombreDeUsuario, Formulario formulario, int cantEmpleadosBuscados){
        super(nombreDeUsuario, formulario);
        this.cantEmpleadosBuscados = cantEmpleadosBuscados;
        this.cantEmpleadosConseguidos = 0;
    }

    @Override
  //  public TipoUsuario getTipoDuenio() {
  //      return TipoUsuario.EMPLEADOR;
  //  }
    //si entro aca el elector es de tipo empleador
    public Contrato getContrato(Eleccion eleccionmutua) {
    	return new Contrato(eleccionmutua.getElegido(),eleccionmutua.getElector());
    }
}
