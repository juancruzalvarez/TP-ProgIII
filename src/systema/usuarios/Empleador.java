package systema.usuarios;

import systema.tickets.TicketEmpleador;

import java.util.ArrayList;
import java.util.List;

public class Empleador extends Usuario{
    private String nombre; // o razon social
    private TipoEmpleador tipo; //persona fisica o juridica
    private RubroEmpleador rubro; //salud, comercio local o comercio internacional
   // private List<TicketEmpleador> tickets;

    public Empleador(String nombreDeUsuario, String constrasenia){
        super(nombreDeUsuario, constrasenia);
        tickets = new ArrayList<>();
    }

    /**
     * Actualiza los datos del usuario con los argumentos que no sean null.
     * @param nombre    Nuevo nombre o null.
     * @param tipo  Nuevo apellido o null.
     * @param rubro Nuevo numero de telefono o null.
     */
    public void actualizarDatos(String nombre, TipoEmpleador tipo, RubroEmpleador rubro){
        if(nombre != null){
            setNombre(nombre);
        }
        if(tipo != null){
            setTipo(tipo);
        }
        if(rubro != null){
            setRubro(rubro);
        }

    }

    @Override
    public String toString() {
        return  "Usuario: " + nombreDeUsuario + '\n' +
                (nombre != null ? "Nombre: " + nombre + '\n' : "") +
                (tipo   != null ? "Tipo: "   + tipo   + '\n' : "") +
                (rubro  != null ? "Rubro: "  + rubro  + '\n' : "");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.EMPLEADOR;
    }

    public void AgregarTicket(TicketEmpleador ticket){
        tickets.add(ticket);
    }
    public List<TicketEmpleador> getTickets(){
        return tickets;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoEmpleador tipo) {
        this.tipo = tipo;
    }

    public RubroEmpleador getRubro() {
        return rubro;
    }

    public void setRubro(RubroEmpleador rubro) {
        this.rubro = rubro;
    }
}
