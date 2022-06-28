package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import sistema.contratos.Contrato;
import sistema.tickets.Ticket;
import sistema.usuarios.Usuario;

public class VentanaAgencia extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_panelC;
	private DefaultListModel<Contrato> modeloListaCont;
	private JLabel lblNewLabel_3;
	private JButton btnActivarEL;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnActivarC;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JLabel lblUsuariosACobrar_1;
	private JLabel lblUsuariosACobrar_2;
	private JButton btnNewButton_2;
	private JList<Contrato> listContratos;
	private JButton btnNewButton;
	private JList<String> listDetalles;
	private DefaultListModel<String> modeloListaDetalles;
	private JPanel panelEmpleadores;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JList<Usuario> listEmpleadores;
	private JList<Ticket> listSolicitudes;
	private DefaultListModel<Usuario> modeloListaEmpleador;
	private DefaultListModel<Ticket> modeloListaSoli;
	private JPanel panelEmpleadosP;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JButton btnBuscar;
	private JButton btnSol;
	private JList<Usuario> listEmpeladosP;
	private DefaultListModel<Usuario> modeloListaEmpleadosE;
	private JList<Ticket> listSolicitudesE;
	private DefaultListModel<Ticket> modeloListaSoliE;
	private JButton btnsimu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgencia frame = new VentanaAgencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAgencia() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 560);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(0, 0, 603, 520);
		this.contentPane.add(this.tabbedPane);

		this.panel_panelC = new JPanel();
		this.tabbedPane.addTab("Panel de Control", null, this.panel_panelC, null);
		this.panel_panelC.setLayout(null);

		this.lblNewLabel_3 = new JLabel("Panel de Control de Administrador");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_3.setBounds(10, 24, 295, 14);
		this.panel_panelC.add(this.lblNewLabel_3);

		this.btnActivarEL = new JButton("ACTIVAR Listas");
		this.btnActivarEL.setBounds(225, 68, 123, 29);
		this.panel_panelC.add(this.btnActivarEL);

		this.lblNewLabel_4 = new JLabel("Ronda de Encuentros Laborales");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel_4.setBounds(10, 62, 205, 37);
		this.panel_panelC.add(this.lblNewLabel_4);

		this.lblNewLabel_5 = new JLabel("Ronda de Contrataci\u00F3n");
		this.lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel_5.setBounds(10, 120, 205, 37);
		this.panel_panelC.add(this.lblNewLabel_5);

		this.btnActivarC = new JButton("ACTIVAR Ronda");
		this.btnActivarC.setBounds(225, 126, 123, 31);
		this.panel_panelC.add(this.btnActivarC);
		
		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(358, 62, 230, 390);
		this.panel_panelC.add(this.scrollPane_2);
		
		this.listContratos = new JList<Contrato>();
		this.scrollPane_2.setViewportView(this.listContratos);
		
		this.scrollPane_3 = new JScrollPane();
		this.scrollPane_3.setBounds(10, 225, 335, 227);
		this.panel_panelC.add(this.scrollPane_3);
		
		this.listDetalles = new JList<String>();
		this.scrollPane_3.setViewportView(this.listDetalles);
		
		this.lblUsuariosACobrar_1 = new JLabel("Contratos Cerrados");
		this.lblUsuariosACobrar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblUsuariosACobrar_1.setBounds(358, 37, 223, 19);
		this.panel_panelC.add(this.lblUsuariosACobrar_1);
		
		this.lblUsuariosACobrar_2 = new JLabel("Detalles");
		this.lblUsuariosACobrar_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblUsuariosACobrar_2.setBounds(10, 203, 223, 19);
		this.panel_panelC.add(this.lblUsuariosACobrar_2);
		
		this.btnNewButton_2 = new JButton("Actualizar Contratos ");
		this.btnNewButton_2.setBounds(431, 463, 157, 23);
		this.panel_panelC.add(this.btnNewButton_2);
		
		this.btnNewButton = new JButton("Ver Comision");
		this.btnNewButton.setBounds(225, 183, 123, 31);
		this.panel_panelC.add(this.btnNewButton);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		//aca

		//aca
		this.panelEmpleadores = new JPanel();
		this.tabbedPane.addTab("Empleadores", null, this.panelEmpleadores, null);
		this.panelEmpleadores.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("Lista De Empleadores y Solicitudes");
		this.lblNewLabel_1.setBounds(10, 11, 223, 19);
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.panelEmpleadores.add(this.lblNewLabel_1);
		
		this.scrollPane_4 = new JScrollPane();
		this.scrollPane_4.setBounds(10, 46, 578, 195);
		this.panelEmpleadores.add(this.scrollPane_4);
		
		this.listEmpleadores = new JList<Usuario>();
		this.scrollPane_4.setViewportView(this.listEmpleadores);
		
		this.scrollPane_5 = new JScrollPane();
		this.scrollPane_5.setBounds(10, 286, 578, 195);
		this.panelEmpleadores.add(this.scrollPane_5);
		
		this.listSolicitudes = new JList<Ticket>();
		this.scrollPane_5.setViewportView(this.listSolicitudes);
		
		this.btnNewButton_1 = new JButton("Buscar Nuevos");
		this.btnNewButton_1.setBounds(124, 252, 133, 23);
		this.panelEmpleadores.add(this.btnNewButton_1);
		
		this.btnNewButton_3 = new JButton("Ver Solicitudes");
		this.btnNewButton_3.setBounds(302, 252, 139, 23);
		this.panelEmpleadores.add(this.btnNewButton_3);
		
		this.panelEmpleadosP = new JPanel();
		this.panelEmpleadosP.setLayout(null);
		this.tabbedPane.addTab("Empleados Pretensos", null, this.panelEmpleadosP, null);
		
		this.lblNewLabel_2 = new JLabel("Lista De Empleados y Solicitudes");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_2.setBounds(10, 11, 223, 19);
		this.panelEmpleadosP.add(this.lblNewLabel_2);
		
		this.scrollPane_6 = new JScrollPane();
		this.scrollPane_6.setBounds(10, 46, 578, 195);
		this.panelEmpleadosP.add(this.scrollPane_6);
		
		this.listEmpeladosP = new JList<Usuario>();
		this.scrollPane_6.setViewportView(this.listEmpeladosP);
		
		this.scrollPane_7 = new JScrollPane();
		this.scrollPane_7.setBounds(10, 286, 578, 195);
		this.panelEmpleadosP.add(this.scrollPane_7);
		
		this.listSolicitudesE = new JList<Ticket>();
		this.scrollPane_7.setViewportView(this.listSolicitudesE);
		
		this.btnBuscar = new JButton("Buscar  Nuevos");
		this.btnBuscar.setBounds(125, 252, 136, 23);
		this.panelEmpleadosP.add(this.btnBuscar);
		
		this.btnSol = new JButton("Ver  Solicitudes");
		this.btnSol.setBounds(302, 252, 128, 23);
		this.panelEmpleadosP.add(this.btnSol);
		
		this.btnActivarEL.addKeyListener(this);
		this.btnActivarC.addKeyListener(this);

		this.modeloListaCont = new DefaultListModel<Contrato>();
		this.listContratos.setModel(modeloListaCont);
		
		this.modeloListaDetalles = new DefaultListModel<String>();
		this.listDetalles.setModel(modeloListaDetalles);
		
		this.btnsimu = new JButton("Simulacion");
		this.btnsimu.setBounds(10, 168, 113, 23);
		this.panel_panelC.add(this.btnsimu);
		
		this.modeloListaEmpleador = new DefaultListModel<Usuario>();
		this.listEmpleadores.setModel(modeloListaEmpleador);
		
		this.modeloListaSoli = new DefaultListModel<Ticket>();
		this.listSolicitudes.setModel(modeloListaSoli);
		
		this.modeloListaEmpleadosE = new DefaultListModel<Usuario>();
		this.listEmpeladosP.setModel(modeloListaEmpleadosE);
		
		this.modeloListaSoliE = new DefaultListModel<Ticket>();
		this.listSolicitudesE.setModel(modeloListaSoliE);
	}
	public void actualizaDetalles(String comision) {
		this.modeloListaDetalles.clear();
		this.modeloListaDetalles.addElement(comision);

	}
	
	public void actualizaEmpleadores(List<Usuario> users) {
		this.modeloListaEmpleador.clear();
		Iterator<Usuario> it3 = users.iterator();
		while (it3.hasNext()) {
			this.modeloListaEmpleador.addElement(it3.next());

		}
	}
	
	public void agregaTicketEmpleador(List<Ticket> tickets) {
		this.modeloListaSoli.clear();
		Iterator<Ticket> it3 = tickets.iterator();
		while (it3.hasNext()) {
			this.modeloListaSoli.addElement(it3.next());

		}
	}
	
	public void actualizaEmpleados(List<Usuario> users) {
		this.modeloListaEmpleadosE.clear();
		Iterator<Usuario> it3 = users.iterator();
		while (it3.hasNext()) {
			this.modeloListaEmpleadosE.addElement(it3.next());

		}
	}
	
	public void agregaTicketEmpleados(List<Ticket> tickets) {
		this.modeloListaSoliE.clear();
		Iterator<Ticket> it3 = tickets.iterator();
		while (it3.hasNext()) {
			this.modeloListaSoliE.addElement(it3.next());

		}
	}
	
	public void actualizaContratos(List<Contrato> contratos) {
		this.modeloListaCont.clear();
		Iterator<Contrato> it3 = contratos.iterator();
		while (it3.hasNext()) {
			this.modeloListaCont.addElement(it3.next());

		}
	}
	public Usuario usuarioSeleccion() {
		return this.listEmpleadores.getSelectedValue();
	}
	public Usuario usuarioSeleccionE() {
		return this.listEmpeladosP.getSelectedValue();
	}

	public Contrato ContratoSeleccion() {
		return this.listContratos.getSelectedValue();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnActivarC.addActionListener(actionListener);
		this.btnActivarEL.addActionListener(actionListener);
		this.btnNewButton.addActionListener(actionListener);
		this.btnNewButton_2.addActionListener(actionListener);
		this.btnBuscar.addActionListener(actionListener);
		this.btnSol.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.btnNewButton_3.addActionListener(actionListener);
		this.btnsimu.addActionListener(actionListener);
	}

	@Override
	public void visible(boolean b) {
		this.setVisible(b);

	}

	@Override
	public void setWindowListener(WindowListener w) {
		this.addWindowListener(w);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
