package sistema.tickets;

import java.util.Map;

import sistema.Sistema;
import sistema.contratos.Contrato;
import sistema.contratos.Eleccion;
import sistema.usuarios.Empleador;
import sistema.usuarios.TipoUsuario;
import sistema.usuarios.Usuario;

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

	public int getCantEmpleadosConseguidos() {
		return cantEmpleadosConseguidos;
	}

	public void contrataEmpleado() {
		this.cantEmpleadosConseguidos+=1;
	}

	public int getCantEmpleadosBuscados() {
		return cantEmpleadosBuscados;
	}
    
}
