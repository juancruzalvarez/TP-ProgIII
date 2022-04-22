package prueba;

import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.UsuarioInexistenteException;
import exepciones.ContraseniaIncorrectaException;
import systema.Agencia;
import systema.asignaciones.Asignaciones;
import systema.tickets.Formulario;
import systema.usuarios.RubroEmpleador;
import systema.usuarios.TipoEmpleador;
import systema.usuarios.TipoUsuario;

import java.time.LocalDate;
import java.util.List;

/*Prueba*/

public class Main {

    public static void main(String args[]){
        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "contrasenia");
        pCargarDatosUsuario("marcos123", "contrasenia", "Marcos", "Alvarez", "+54 2233060784", LocalDate.of(2000, 8, 2));
        pCrearTicket("marcos123",
                "contrasenia",
                new Formulario("home", "v1av3", "parcial", "manager", "mayora200", "mucha", "secundarios")
        );
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador2", "contrasef");
        pCargarDatosUsuario("empleador2", "contraseni", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);    //no deberia cargarlos contraseña equivocada.
        pCargarDatosUsuario("empleador2", "contrasef", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);
        pCrearTicket("empleador2",
                "contrasef",
                new Formulario("homeOffice", "v1av2", "fullTime", "junior", "menor40", "No", "pocos"),
                5);
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador5", "g");
        pCargarDatosUsuario("empleador5", "g", "Google", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.SALUD);
        pCrearTicket("empleador5",
                "g",
                new Formulario("homeOffice", "v1av2", "fullTime", "junior", "menor40", "No", "pocos"),
                5);
        pCrearTicket("empleador5",
                "g",
                new Formulario("homeOffice", "mayorav2", "fullTime", "senior", "menor40", "No", "muchos"),
                2);

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "otra"); // No deberia registrarlo
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "marcos123", "otra2");        //Tampoco deberia registrarlo

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "juan", "juan2357");
        pCargarDatosUsuario("juan", "juan2357", "Juan", "Perez", "+54 2233320744", LocalDate.of(1984, 2, 9));
        pCrearTicket("juan",
                "juan2357",
                new Formulario("prcsencial", "v1av2", "fullTime", "senior", "mayora100", "inexistente", "zero")
        );

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "pedro", "contra");
        pCargarDatosUsuario("pedro", "contra", "Pedro", "Martinez", "+54 2236840789", LocalDate.of(1998, 11, 27));
        pCrearTicket("pedro",
                "contra",
                new Formulario("prcsencial", "v1av2", "fullTime", "senior", "mayora100", "inexistente", "zero")
        );


        Agencia.getInstancia().mostrarUsuarios();

        try {
            Agencia.getInstancia().mostrarTickets("empleador5");
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }
        try {
            Agencia.getInstancia().mostrarTickets("juan");
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }

        try {
            Agencia.getInstancia().mostrarTickets("pedro");
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }

        Asignaciones.getInstancia().realizarRondaDeAsignaciones();
        List<String> usuarios = List.of("pedro"," juan", "marcos123", "empleador2", "empleador5");
        usuarios.forEach( usuario->{
            System.out.println("Usuario: "+usuario);
            try {
                Agencia.getInstancia().getTickets(usuario).forEach(ticket -> {
                    System.out.println("    Ticket: " +ticket.toString());
                    Asignaciones.getInstancia().getListaDeAsignaciones(ticket).forEach((usuarioPuntaje -> {
                        System.out.println("        Usuario: "+ usuarioPuntaje.getUsuario() +" Puntaje: "+ usuarioPuntaje.getPuntaje());
                    }));
                });
            } catch (UsuarioInexistenteException e) {

            }

        });
    }

    private static void pRegistrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String constrasenia){
        try{
            Agencia.getInstancia().registrarUsuario(tipo, nombreDeUsuario, constrasenia);
            System.out.println("Usuario "+ nombreDeUsuario + " registrado correctamente.");
        }catch(NombreDeUsuarioEnUsoException e){
            System.out.println("No se pudo registrar usuario con nombre de usuario " + e.getNombreDeUsuario() + ", porque este ya esta en uso.");
        }
    }

    /**
     * Inicia session  y carga en el usuario los datos dados (Empleado).
     * @param nombreDeUsuario
     * @param contrasenia
     * @param nombre
     * @param apellido
     * @param nroDeTelefono
     * @param fechaDeNacimiento
     */
    private static void pCargarDatosUsuario(String nombreDeUsuario, String contrasenia, String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento){
        Agencia agencia = Agencia.getInstancia();
        try {
            agencia.login(nombreDeUsuario, contrasenia);
            agencia.actualizarDatosUsuario(nombre, apellido, nroDeTelefono, fechaDeNacimiento);
            agencia.logout();
            System.out.println("Se actualizaron correctamente los datos del usuario " + nombreDeUsuario + ".");
        }catch(UsuarioInexistenteException e){
            System.out.println("Error al iniciar session: No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("Error al iniciar session: El nombre de usuario y la constrasenia no coinciden");
        }

    }

    /**
     * Inicia session  y carga en el usuario los datos dados (Empleador).
     * @param nombreDeUsuario
     * @param contrasenia
     * @param nombre
     * @param tipo
     * @param rubro
     */
    private static void pCargarDatosUsuario(String nombreDeUsuario, String contrasenia, String nombre, TipoEmpleador tipo, RubroEmpleador rubro){
        Agencia agencia = Agencia.getInstancia();
        try {
            agencia.login(nombreDeUsuario, contrasenia);
            agencia.actualizarDatosUsuario(nombre, tipo, rubro);
            agencia.logout();
            System.out.println("Se actualizaron correctamente los datos del usuario " + nombreDeUsuario + ".");
        }catch(UsuarioInexistenteException e){
            System.out.println("Error al iniciar session: No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("Error al iniciar session: El nombre de usuario y la constrasenia no coinciden");
        }
    }

    private static void pCrearTicket(String nombreDeUsuario, String contrasenia, Formulario formulario){
        Agencia agencia = Agencia.getInstancia();
        try {
            agencia.login(nombreDeUsuario, contrasenia);
            agencia.crearTicket(formulario);
            agencia.logout();
            System.out.println("Se creo ticket correctamente de "+nombreDeUsuario);
        }catch(UsuarioInexistenteException e){
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }
    }

    private static void pCrearTicket(String nombreDeUsuario, String contrasenia, Formulario formulario, int cantEmpleadosBuscados){
        System.out.println("Se creo ticket correctamente de "+nombreDeUsuario);
        Agencia agencia = Agencia.getInstancia();
        try {
            agencia.login(nombreDeUsuario, contrasenia);
            agencia.crearTicket(formulario, cantEmpleadosBuscados);
            agencia.logout();
            System.out.println("Se creo ticket correctamente de "+nombreDeUsuario);
        }catch(UsuarioInexistenteException e){
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }
    }
}
