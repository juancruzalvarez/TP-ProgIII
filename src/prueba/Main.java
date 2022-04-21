package prueba;

import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.UsuarioInexistenteException;
import exepciones.ContraseniaIncorrectaException;
import systema.Agencia;
import systema.usuarios.RubroEmpleador;
import systema.usuarios.TipoEmpleador;
import systema.usuarios.TipoUsuario;

import java.time.LocalDate;

public class Main {

    public static void main(String args[]){
        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "contrasenia");
        pCargarDatosUsuario("marcos123", "contrasenia", "Marcos", "Alvarez", "+54 2233060784", LocalDate.of(2000, 8, 2));

        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador2", "contrasef");
        pCargarDatosUsuario("empleador2", "contraseni", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);    //no deberia cargarlos contraseña equivocada.
        pCargarDatosUsuario("empleador2", "contrasef", "MC DONALS", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.COMERCIO_INTERNACIONAL);

        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "empleador5", "g");
        pCargarDatosUsuario("empleador5", "g", "Google", TipoEmpleador.PERSONA_JURIDICA, RubroEmpleador.SALUD);

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "marcos123", "otra"); // No deberia registrarlo
        pRegistrarUsuario(TipoUsuario.EMPLEADOR, "marcos123", "otra2");        //Tampoco deberia registrarlo

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "juan", "juan2357");
        pCargarDatosUsuario("juan", "juan2357", "Juan", "Perez", "+54 2233320744", LocalDate.of(1984, 2, 9));

        pRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO, "pedro", "contra");
        pCargarDatosUsuario("pedro", "contra", "Pedro", "Martinez", "+54 2236840789", LocalDate.of(1998, 11, 27));

        Agencia.getInstancia().mostrarUsuarios();
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
        pruaa
    }
}
