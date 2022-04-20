package systema.usuarios;

import java.time.LocalDate;
import java.time.Period;

public class EmpleadoPretenso extends Usuario{
    private String nombre;
    private String apellido;
    private String nroDeTelefono;
    private LocalDate fechaDeNacimiento; // mejor que usar edad.

    public EmpleadoPretenso(String nombreDeUsuario, String constrasenia){
        super(nombreDeUsuario, constrasenia);
    }

    /**
     * Actualiza los datos del usuario con los argumentos que no sean null.
     * @param nombre    Nuevo nombre o null.
     * @param apellido  Nuevo apellido o null.
     * @param nroDeTelefono Nuevo numero de telefono o null.
     * @param fechaDeNacimiento Nueva fecha de nacimiento o null.
     */
    public void actualizarDatos(String nombre, String apellido, String nroDeTelefono, LocalDate fechaDeNacimiento){
        if(nombre != null){
            setNombre(nombre);
        }
        if(apellido != null){
            setApellido(apellido);
        }
        if(nroDeTelefono != null){
            setNroDeTelefono(nroDeTelefono);
        }
        if(fechaDeNacimiento != null){
            setFechaDeNacimiento(fechaDeNacimiento);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNroDeTelefono() {
        return nroDeTelefono;
    }

    public void setNroDeTelefono(String nro_telefono) {
        this.nroDeTelefono = nro_telefono;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento){
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad(){
        if(fechaDeNacimiento == null)
            return -1;
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return  "Usuario: " + nombreDeUsuario + '\n' +
                (nombre        != null ? "Nombre: "             + nombre        + '\n' : "") +
                (apellido      != null ? "Apellido: "           + apellido      + '\n' : "") +
                (nroDeTelefono != null ? "Numero de Telefono: " + nroDeTelefono + '\n' : "") +
                (getEdad()     >= 0    ? "Edad: "               + getEdad()     + '\n' : "");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.EMPLEADO_PRETENSO;
    }
}
