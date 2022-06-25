package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import exepciones.ContraseniaIncorrectaException;
import exepciones.NombreDeUsuarioEnUsoException;
import exepciones.UsuarioInexistenteException;
import interfaz.IVista;
import interfaz.Login;
import interfaz.Registro;
import interfaz.VentanaAgencia;
import interfaz.VentanaEmpleadoPretenso;
import interfaz.VentanaEmpleador;
import sistema.Sistema;
import sistema.tickets.FormularioEmpleador;
import sistema.usuarios.TipoUsuario;

public class Controlador implements ActionListener, WindowListener {

	IVista vista;

	public Controlador() {
		Sistema.getInstancia();
		vista = new Login();
		vista.setActionListener(this);
		vista.setWindowListener(this);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Registrarse")) {

			vista.visible(false);
			vista = new Registro();
			vista.setActionListener(this);
			vista.setWindowListener(this);

		} else if (e.getActionCommand().equals("Login")) {

			try {

				int tipo = Sistema.getInstancia().usrLogin(((Login) vista).getTextUsuario(),
						((Login) vista).getTextPass());

				if (tipo == 0) { // agencia
					vista.visible(false);
					vista = new VentanaAgencia();
					vista.setActionListener(this);
					vista.setWindowListener(this);
				} else if (tipo == 1) { // empleador
					vista.visible(false);
					vista = new VentanaEmpleador();
					vista.setActionListener(this);
					vista.setWindowListener(this);
				} else if (tipo == 2) { // empleado pretenso
					vista.visible(false);
					vista = new VentanaEmpleadoPretenso();
					vista.setActionListener(this);
					vista.setWindowListener(this);
				}

			} catch (UsuarioInexistenteException e1) {
				((Login) vista).usuarioInexistente();
				JOptionPane.showConfirmDialog(null, e1.getMessage(), "", JOptionPane.DEFAULT_OPTION);

			} catch (ContraseniaIncorrectaException e1) {
				((Login) vista).contraseniaMal();
				JOptionPane.showConfirmDialog(null, e1.getMessage(), "", JOptionPane.DEFAULT_OPTION);

			}

		} else if (e.getActionCommand().equals("Registrar empleado pretenso")) {

			try {
				Sistema.getInstancia().usrRegistrarUsuario(TipoUsuario.EMPLEADO_PRETENSO,
						((Registro) vista).getNombreUsuario(), ((Registro) vista).getPass());
			} catch (NombreDeUsuarioEnUsoException e1) {
				JOptionPane.showConfirmDialog(null, "Ya existe un usuario con ese nombre.", "",
						JOptionPane.DEFAULT_OPTION);
			}

			try {
				Sistema.getInstancia().usrLogin(((Registro) vista).getNombreUsuario(), ((Registro) vista).getPass());
			} catch (UsuarioInexistenteException e1) {
			} catch (ContraseniaIncorrectaException e1) {
			}

			Sistema.getInstancia().usrActualizarDatos(((Registro) vista).getNombre(), ((Registro) vista).getApellido(),
					((Registro) vista).getTelefono(), ((Registro) vista).getEdad());

			JOptionPane.showConfirmDialog(null, "registro exitoso", "", JOptionPane.DEFAULT_OPTION);

			vista.visible(false);
			vista = new VentanaEmpleadoPretenso();
			vista.setActionListener(this);
			vista.setWindowListener(this);

		} else if (e.getActionCommand().equals("Registrar empleador")) {

			try {
				Sistema.getInstancia().usrRegistrarUsuario(TipoUsuario.EMPLEADOR,
						((Registro) vista).getNombreUsuarioE(), ((Registro) vista).getPassE());
			} catch (NombreDeUsuarioEnUsoException e1) {
				JOptionPane.showConfirmDialog(null, "Ya existe un usuario con ese nombre.", "",
						JOptionPane.DEFAULT_OPTION);
			}

			try {
				Sistema.getInstancia().usrLogin(((Registro) vista).getNombreUsuarioE(), ((Registro) vista).getPassE());
			} catch (UsuarioInexistenteException e1) {
			} catch (ContraseniaIncorrectaException e1) {
			}

			Sistema.getInstancia().usrActualizarDatos(((Registro) vista).getNombreE(),
					((Registro) vista).getTipoPersona(), ((Registro) vista).getRubro());
			JOptionPane.showConfirmDialog(null, "registro exitoso", "", JOptionPane.DEFAULT_OPTION);

			vista.visible(false);
			vista = new VentanaEmpleador();
			vista.setActionListener(this);
			vista.setWindowListener(this);

		} else if (e.getActionCommand().equals("Crear Ticket")) {
			Sistema.getInstancia()
					.usrCrearTicket(new FormularioEmpleador(((VentanaEmpleador) vista).getLocacion(),
							((VentanaEmpleador) vista).getLocacionP(), ((VentanaEmpleador) vista).getRemuneracion(),
							((VentanaEmpleador) vista).getRemuneracionP(), ((VentanaEmpleador) vista).getCarga(),
							((VentanaEmpleador) vista).getCargaP(), ((VentanaEmpleador) vista).getPuesto(),
							((VentanaEmpleador) vista).getPuestoP(), ((VentanaEmpleador) vista).getRango(),
							((VentanaEmpleador) vista).getRangoP(), ((VentanaEmpleador) vista).getExp(),
							((VentanaEmpleador) vista).getExpP(), ((VentanaEmpleador) vista).getEstudios(),
							((VentanaEmpleador) vista).getEstudiosP()), ((VentanaEmpleador) vista).getCantEmpleados());
			((VentanaEmpleador) vista).agregarTicket(Sistema.getInstancia().usrGetTickets());
		} else if (e.getActionCommand().equals("Suspender")) {

			Sistema.getInstancia().usrSuspenderTicket(((VentanaEmpleador) vista).ticketSeleccionado());
			((VentanaEmpleador) vista).agregarTicket(Sistema.getInstancia().usrGetTickets());

		} else if (e.getActionCommand().equals("Activar")) {

			Sistema.getInstancia().usrActivarTicket(((VentanaEmpleador) vista).ticketSeleccionado());
			((VentanaEmpleador) vista).agregarTicket(Sistema.getInstancia().usrGetTickets());

		} else if (e.getActionCommand().equals("Eliminar")) {

			Sistema.getInstancia().usrFinalizarTicket(((VentanaEmpleador) vista).ticketSeleccionado());
			((VentanaEmpleador) vista).agregarTicket(Sistema.getInstancia().usrGetTickets());
		
		} else if (e.getActionCommand().equals("Actualizar")) {
			((VentanaEmpleador) vista).actualizaTicketsListaA(Sistema.getInstancia().usrGetTickets());
			
		

		} else if (e.getActionCommand().equals("ACTIVAR")) {
			Sistema.getInstancia().agRealizarRondaDeAsignaciones();
			JOptionPane.showConfirmDialog(null, "Ronda de Asignaciones Activada con Exito", "", JOptionPane.DEFAULT_OPTION);
			
		}
		else if (e.getActionCommand().equals("Seleccionar"))
			((VentanaEmpleador) vista).actualizaPosiblesE(Sistema.getInstancia().usrGetTicketPosiblesEmpleados(((VentanaEmpleador) vista).ticketActivoSeleccionado()));

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		vista = new Login();
		vista.setActionListener(this);
		vista.setWindowListener(this);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
