package prueba;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;

import exepciones.ContraseniaIncorrectaException;
import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.TicketNoActivoException;
import exepciones.UsuarioInexistenteException;
import sistema.Sistema;
import sistema.asignaciones.Asignaciones;
import sistema.asignaciones.TicketPuntaje;
import sistema.tickets.Formulario;
import sistema.tickets.FormularioEmpleador;
import sistema.tickets.Ticket;
import sistema.usuarios.RubroEmpleador;
import sistema.usuarios.TipoEmpleador;
import sistema.usuarios.TipoUsuario;

/*Prueba*/

public class Main {

    public static void main(String args[]){
        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "1");
        pCargarDatosUsuario("marcos123", "1", "Marcos", "Alvarez", "+54 2233060784", LocalDate.of(2000, 8, 2));
        pCrearTicket("marcos123",
                "1",
                new Formulario("Home Office", "entre V1 y V2", "extendida", "managment", "40 a 50", "nada", "secundario")
        );
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador2", "2");
        pCargarDatosUsuario("empleador2", "contraseni", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);    //no deberia cargarlos contraseña equivocada.
        pCargarDatosUsuario("empleador2", "2", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);
        pCrearTicket("empleador2",
                "2",
                new FormularioEmpleador("Home Office",3, "entre V1 y V2",3, "extendida",3, "junior",3, "40 a 50",3, "nada",3, "secundario",3),
                5);
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador5", "3");
        pCargarDatosUsuario("empleador5", "3", "Google", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.SALUD);
        pCrearTicket("empleador5",
                "3",
                new FormularioEmpleador("Home Office",1, "entre V1 y V2",1, "extendida",1, "junior",1, "menos de 40",1, "nada",1, "secundario",1),
                5);
        pCrearTicket("empleador5",
                "3",
                new FormularioEmpleador("Home Office",4, "mas de V2",4, "extendida",4, "senior",4, "menos de 40",4, "nada",4, "terciario",4),
                2);

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "4"); // No deberia registrarlo
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "marcos123", "4");        //Tampoco deberia registrarlo

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "juan", "5");
        pCargarDatosUsuario("juan", "5", "Juan", "Perez", "+54 2233320744", LocalDate.of(1984, 2, 9));
        pCrearTicket("juan",
                "5",
                new Formulario("Presencial", "entre V1 y V2", "extendida", "senior", "menos de 40", "media", "terciario")
        );

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "pedro", "6");
        pCargarDatosUsuario("pedro", "6", "Pedro", "Martinez", "+54 2236840789", LocalDate.of(1998, 11, 27));
        pCrearTicket("pedro",
                "6",
                new Formulario("Presencial", "entre V1 y V2", "extendida", "senior", "menos de 40", "media", "terciario")
        );

        // mostrar usuarios
        Sistema.getInstancia().agGetUsuarios().forEach( u ->
                System.out.println(u)
        );

        try {
            Sistema.getInstancia().agGetTickets("empleador5").forEach(t -> System.out.println(t));
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }
        try {
            Sistema.getInstancia().agGetTickets("juan").forEach(t -> System.out.println(t));
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }

        try {
            Sistema.getInstancia().agGetTickets("pedro").forEach(t -> System.out.println(t));
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe el usuario " + e.getNombreDeUsuario());
        }

        Sistema.getInstancia().agRealizarRondaDeAsignaciones();
        pMostrarListasDeAsignacion("marcos123", "1");
        pMostrarListasDeAsignacion("empleador2", "2");
        pMostrarListasDeAsignacion("empleador5", "3");
        pMostrarListasDeAsignacion("juan", "5");
        pMostrarListasDeAsignacion("pedro", "6");

        pRealizarSeleccionAleatoria("marcos123", "1");
        pRealizarSeleccionAleatoria("empleador2", "2");
        pRealizarSeleccionAleatoria("empleador5", "3");
        pRealizarSeleccionAleatoria("juan", "5");
        pRealizarSeleccionAleatoria("pedro", "6");
        Sistema.getInstancia().agRealizarRondaContrataciones();
        Sistema.getInstancia().agGetContratos().forEach( c -> System.out.println(c));

        System.out.println("Puntajes luego de ronda de contratacion:");
        Sistema.getInstancia().agGetUsuarios().forEach( u -> System.out.println("Usuario: "+u.getNombreDeUsuario()+ " Puntaje: "+u.getPuntaje()));


    }

    private static void pRegistrarUsuario(TipoUsuario tipo, String nombreDeUsuario, String constrasenia){
        try{
            Sistema.getInstancia().usrRegistrarUsuario(tipo, nombreDeUsuario, constrasenia);
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
        Sistema sistema = Sistema.getInstancia();
        try {
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            sistema.usrActualizarDatos(nombre, apellido, nroDeTelefono, fechaDeNacimiento);
            sistema.usrLogout();
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
        Sistema sistema = Sistema.getInstancia();
        try {
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            sistema.usrActualizarDatos(nombre, tipo, rubro);
            sistema.usrLogout();
            System.out.println("Se actualizaron correctamente los datos del usuario " + nombreDeUsuario + ".");
        }catch(UsuarioInexistenteException e){
            System.out.println("Error al iniciar session: No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("Error al iniciar session: El nombre de usuario y la constrasenia no coinciden");
        }
    }

    private static void pCrearTicket(String nombreDeUsuario, String contrasenia, Formulario formulario){
        Sistema sistema = Sistema.getInstancia();
        try {
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            sistema.usrCrearTicket(formulario);
            sistema.usrLogout();
            System.out.println("Se creo ticket correctamente de "+nombreDeUsuario);
        }catch(UsuarioInexistenteException e){
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }
    }

    private static void pCrearTicket(String nombreDeUsuario, String contrasenia, Formulario formulario, int cantEmpleadosBuscados){
        Sistema sistema = Sistema.getInstancia();
        try {
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            sistema.usrCrearTicket(formulario, cantEmpleadosBuscados);
            sistema.usrLogout();
            System.out.println("Se creo ticket correctamente de "+nombreDeUsuario);
        }catch(UsuarioInexistenteException e){
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        }catch(ContraseniaIncorrectaException e){
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }
    }

    private static void pMostrarListasDeAsignacion(String nombreDeUsuario, String contrasenia){
        Sistema sistema = Sistema.getInstancia();
        try {
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            System.out.println("Listas de asignacion del usuario "+nombreDeUsuario +":");
            sistema.usrGetListasDeAsignacion()
                    .forEach( (ticket, lista) -> {
                        System.out.println("    Ticket: "+ticket);
                        lista.forEach(ticketPuntaje -> System.out.println("        Ticket: "+ ticketPuntaje.getTicket() + " Puntaje: "+ ticketPuntaje.getPuntaje()));
                    });
        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        } catch (ContraseniaIncorrectaException e) {
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }

    }

    private static void pRealizarSeleccionAleatoria(String nombreDeUsuario, String contrasenia){
        Sistema sistema = Sistema.getInstancia();
        Random r = new Random();

        try{
            sistema.usrLogin(nombreDeUsuario, contrasenia);
            Map<Ticket, List<TicketPuntaje>> listasDeAsignaciones = sistema.usrGetListasDeAsignacion();
            if(listasDeAsignaciones.isEmpty()){
                System.out.println("El usuario" + nombreDeUsuario + " no tiene listas de asignacion sobre las cuales seleccionar.");
                return;
            }
            listasDeAsignaciones.forEach( (ticket, lista) ->{
                Ticket seleccionado = lista.get(r.nextInt(lista.size()-1)).getTicket();
                System.out.println("Elector: " + ticket + "Eleccion :" + seleccionado);
                try {
                    sistema.usrRealizarEleccion(ticket, seleccionado);
                } catch (TicketNoActivoException e) {
                    System.out.println("Ticket no activo. "+ticket.toString());
                }
            });


        } catch (UsuarioInexistenteException e) {
            System.out.println("No existe ningun usuario cuyo nombre de usuario sea " + e.getNombreDeUsuario());
        } catch (ContraseniaIncorrectaException e) {
            System.out.println("El nombre de usuario y la constrasenia no coinciden");
        }
    }
}
