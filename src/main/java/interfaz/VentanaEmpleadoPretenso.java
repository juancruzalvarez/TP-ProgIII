package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import sistema.asignaciones.TicketPuntaje;
import sistema.contratos.Contrato;
import sistema.tickets.EstadoTicket;
import sistema.tickets.Formulario;
import sistema.tickets.Ticket;

public class VentanaEmpleadoPretenso extends JFrame implements IVista,KeyListener, ActionListener {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Ticket;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JComboBox<String> comboBoxLocacion;
	private JComboBox<String> comboBoxRemu;
	private JComboBox<String> comboBoxCarga;
	private JComboBox<String> comboBoxPuesto;
	private JComboBox<String> comboBoxRango;
	private JComboBox<String> comboBoxExp;
	private JComboBox<String> comboBoxEstudios;
	private JButton btnCrearTicket;
	private JPanel panel_3;
	private JLabel lblMisTickets;
	private JScrollPane scrollPane;
	private JList<Ticket> listTicketsE;
	private JButton btnSuspender;
	private JButton btnActivar;
	private JButton btnEliminar;
	private DefaultListModel<Ticket> modeloListaE;
	private JPanel panel_Lista_Empleadores;
	private JPanel panel;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_4;
	private JButton btnSeleccionar;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_9;
	private JScrollPane scrollPane_5;
	private JButton btnNewButton_2;
	private JPanel panel_resultados;
	private JLabel lblNewLabel_10;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane_3;
	private JList<Ticket> listTicketsA;
	private JList<TicketPuntaje> listTicketsP;
	private DefaultListModel<Ticket> modeloListaTicketsA;
	private DefaultListModel<TicketPuntaje> modeloListaTicketP;
	private JList<Contrato> listSolicitudes;
	private JButton btnActualizarSolicitudes;
	private DefaultListModel<Contrato> modeloListaCont;
	private JButton btnNewButton;
	private JList<Formulario> listDetallesE;
	private DefaultListModel<Formulario> modeloListaFormu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEmpleador frame = new VentanaEmpleador();
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
	public VentanaEmpleadoPretenso() {
		setTitle("Empleado Pretenso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 560);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(0, 0, 603, 520);
		this.contentPane.add(this.tabbedPane);

		this.panel_Ticket = new JPanel();
		this.tabbedPane.addTab("Gestión de Tickets", null, this.panel_Ticket, null);
		this.panel_Ticket.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_2 = new JPanel();
		this.panel_Ticket.add(this.panel_2);
		this.panel_2.setLayout(null);

		this.lblNewLabel = new JLabel("Crear Nuevo Ticket:");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel.setBounds(10, 11, 136, 20);
		this.panel_2.add(this.lblNewLabel);

		this.lblNewLabel_1 = new JLabel("Locaci\u00F3n");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_1.setBounds(2, 45, 55, 14);
		this.panel_2.add(this.lblNewLabel_1);

		this.lblNewLabel_2 = new JLabel("Remuneraci\u00F3n");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_2.setBounds(2, 95, 77, 14);
		this.panel_2.add(this.lblNewLabel_2);

		this.lblNewLabel_3 = new JLabel("Carga horaria");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_3.setBounds(2, 145, 77, 14);
		this.panel_2.add(this.lblNewLabel_3);

		this.lblNewLabel_4 = new JLabel("Puesto");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_4.setBounds(300, 45, 77, 14);
		this.panel_2.add(this.lblNewLabel_4);

		this.lblNewLabel_5 = new JLabel("Rango etario");
		this.lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_5.setBounds(300, 95, 77, 14);
		this.panel_2.add(this.lblNewLabel_5);

		this.lblNewLabel_6 = new JLabel("Experiencia");
		this.lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_6.setBounds(300, 145, 77, 14);
		this.panel_2.add(this.lblNewLabel_6);

		this.lblNewLabel_7 = new JLabel("Estudios");
		this.lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_7.setBounds(2, 195, 77, 14);
		this.panel_2.add(this.lblNewLabel_7);

		this.comboBoxLocacion = new JComboBox();
		this.comboBoxLocacion.setBounds(90, 45, 101, 22);
		this.panel_2.add(this.comboBoxLocacion);
		comboBoxLocacion.addItem("Home Office");
		comboBoxLocacion.addItem("Presencial");
		comboBoxLocacion.addItem("Indistinto");

		this.comboBoxRemu = new JComboBox();
		this.comboBoxRemu.setBounds(90, 92, 101, 22);
		this.panel_2.add(this.comboBoxRemu);
		comboBoxRemu.addItem("hasta V1");
		comboBoxRemu.addItem("entre V1 y V2");
		comboBoxRemu.addItem("mas de V2");

		this.comboBoxCarga = new JComboBox();
		this.comboBoxCarga.setBounds(90, 142, 101, 22);
		this.panel_2.add(this.comboBoxCarga);
		comboBoxCarga.addItem("media");
		comboBoxCarga.addItem("completa");
		comboBoxCarga.addItem("extendida");

		this.comboBoxPuesto = new JComboBox();
		this.comboBoxPuesto.setBounds(400, 42, 88, 22);
		this.panel_2.add(this.comboBoxPuesto);
		comboBoxPuesto.addItem("junior");
		comboBoxPuesto.addItem("senior");
		comboBoxPuesto.addItem("managment");

		this.comboBoxRango = new JComboBox();
		this.comboBoxRango.setBounds(400, 92, 88, 22);
		this.panel_2.add(this.comboBoxRango);
		comboBoxRango.addItem("menos de 40");
		comboBoxRango.addItem("40 a 50");
		comboBoxRango.addItem("mas de 50");

		this.comboBoxExp = new JComboBox();
		this.comboBoxExp.setBounds(400, 142, 88, 22);
		this.panel_2.add(this.comboBoxExp);
		comboBoxExp.addItem("nada");
		comboBoxExp.addItem("media");
		comboBoxExp.addItem("mucha");

		this.comboBoxEstudios = new JComboBox();
		this.comboBoxEstudios.setBounds(90, 192, 101, 22);
		this.panel_2.add(this.comboBoxEstudios);
		comboBoxEstudios.addItem("primario");
		comboBoxEstudios.addItem("secundario");
		comboBoxEstudios.addItem("terciario");

		this.btnCrearTicket = new JButton("Crear Ticket E.");
		this.btnCrearTicket.setBounds(433, 223, 120, 23);
		this.panel_2.add(this.btnCrearTicket);

		this.panel_3 = new JPanel();
		this.panel_Ticket.add(this.panel_3);
		this.panel_3.setLayout(null);

		this.lblMisTickets = new JLabel("Mis tickets:");
		this.lblMisTickets.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblMisTickets.setBounds(10, 11, 136, 20);
		this.panel_3.add(this.lblMisTickets);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 42, 578, 128);
		this.panel_3.add(this.scrollPane);

		this.listTicketsE = new JList<Ticket>();
		this.scrollPane.setViewportView(this.listTicketsE);

		this.btnSuspender = new JButton("Suspender ");
		this.btnSuspender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnSuspender.setBounds(122, 181, 106, 23);
		this.panel_3.add(this.btnSuspender);

		this.btnActivar = new JButton("Activar ");
		this.btnActivar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnActivar.setBounds(238, 181, 106, 23);
		this.panel_3.add(this.btnActivar);

		this.btnEliminar = new JButton("Eliminar ");
		this.btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnEliminar.setBounds(354, 181, 106, 23);
		this.panel_3.add(this.btnEliminar);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		this.comboBoxLocacion.addKeyListener(this);
		this.comboBoxRemu.addKeyListener(this);
		this.comboBoxCarga.addKeyListener(this);
		this.comboBoxEstudios.addKeyListener(this);
		this.comboBoxRango.addKeyListener(this);
		this.comboBoxExp.addKeyListener(this);
		this.comboBoxPuesto.addKeyListener(this);
	
		
		this.panel_Lista_Empleadores = new JPanel();
		this.tabbedPane.addTab("Ofertas de Trabajo", null, this.panel_Lista_Empleadores, null);
		this.panel_Lista_Empleadores.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel_Lista_Empleadores.add(this.panel);
		
		this.lblNewLabel_8 = new JLabel("Tickets Activados por la Ronda");
		this.lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_8.setBounds(10, 11, 221, 19);
		this.panel.add(this.lblNewLabel_8);
		
		this.scrollPane_4 = new JScrollPane();
		this.scrollPane_4.setBounds(10, 40, 279, 366);
		this.panel.add(this.scrollPane_4);
		
		this.listTicketsA = new JList();
		this.scrollPane_4.setViewportView(this.listTicketsA);
		
		this.btnSeleccionar = new JButton("Seleccionar ");
		this.btnSeleccionar.setBounds(174, 417, 115, 23);
		this.panel.add(this.btnSeleccionar);
		
		this.btnNewButton_1 = new JButton("Actualizar Lista ");
		this.btnNewButton_1.setBounds(20, 417, 128, 23);
		this.panel.add(this.btnNewButton_1);
		
		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_Lista_Empleadores.add(this.panel_1);
		
		this.lblNewLabel_9 = new JLabel("Posibles Empleadores");
		this.lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_9.setBounds(10, 11, 153, 19);
		this.panel_1.add(this.lblNewLabel_9);
		
		this.scrollPane_5 = new JScrollPane();
		this.scrollPane_5.setBounds(10, 41, 279, 366);
		this.panel_1.add(this.scrollPane_5);
		
		this.listTicketsP = new JList();
		this.scrollPane_5.setViewportView(this.listTicketsP);
		
		this.btnNewButton_2 = new JButton("Enviar Oferta");
		this.btnNewButton_2.setBounds(174, 418, 115, 23);
		this.panel_1.add(this.btnNewButton_2);
		
		this.panel_resultados = new JPanel();
		this.panel_resultados.setLayout(null);
		this.tabbedPane.addTab("Resultados", null, this.panel_resultados, null);
		
		this.lblNewLabel_10 = new JLabel("Mis Solicitudes Aceptadas");
		this.lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_10.setBounds(10, 11, 191, 14);
		this.panel_resultados.add(this.lblNewLabel_10);
		
		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(10, 36, 578, 220);
		this.panel_resultados.add(this.scrollPane_2);
		
		this.listSolicitudes = new JList<Contrato>();
		this.scrollPane_2.setViewportView(this.listSolicitudes);
		
		this.btnNewButton_3 = new JButton("Ver Detalles ");
		this.btnNewButton_3.setBounds(250, 267, 107, 23);
		this.panel_resultados.add(this.btnNewButton_3);
		
		this.scrollPane_3 = new JScrollPane();
		this.scrollPane_3.setBounds(10, 307, 578, 134);
		this.panel_resultados.add(this.scrollPane_3);
		
		this.listDetallesE = new JList<Formulario>();
		this.scrollPane_3.setViewportView(this.listDetallesE);
		
		this.btnActualizarSolicitudes = new JButton("Actualizar Solicitudes");
		this.btnActualizarSolicitudes.setBounds(10, 267, 164, 23);
		this.panel_resultados.add(this.btnActualizarSolicitudes);
		
		this.modeloListaE=new DefaultListModel<Ticket>();
		this.listTicketsE.setModel(modeloListaE);
		
		this.btnNewButton = new JButton("  Actualizar ");
		this.btnNewButton.setBounds(487, 182, 101, 23);
		this.panel_3.add(this.btnNewButton);
		
		this.modeloListaTicketsA=new DefaultListModel<Ticket>();
		this.listTicketsA.setModel(modeloListaTicketsA);
		
		this.modeloListaTicketP=new DefaultListModel<TicketPuntaje>();
		this.listTicketsP.setModel(modeloListaTicketP);
		
		this.modeloListaCont=new DefaultListModel<Contrato>();
		this.listSolicitudes.setModel(modeloListaCont);
		
		this.modeloListaFormu=new DefaultListModel<Formulario>();
		this.listDetallesE.setModel(modeloListaFormu);
	}
	
	
	public Contrato SeleccionCont() {
		return this.listSolicitudes.getSelectedValue();
	}
	
	public void actualizaFormu(Formulario formu) {
			this.modeloListaFormu.clear();
			this.modeloListaFormu.addElement(formu);

		}
	
	public void actualizaContratos(List<Contrato> contratos,String username) {
		Contrato aux=null;
		this.modeloListaCont.clear();
		Iterator<Contrato> it3=contratos.iterator();
		while(it3.hasNext()) {
			aux=it3.next();
			if(aux.getTicketEmpleado().getNombreDeUsuario().equals(username))
			this.modeloListaCont.addElement(aux);
		}
		
		
	}
	
	public TicketPuntaje EmpleadorAcontratar() {
		return this.listTicketsP.getSelectedValue();
	}
	public void actualizaPosiblesE(List<TicketPuntaje> tickets) {
		this.modeloListaTicketP.clear();
		Iterator<TicketPuntaje> it3=tickets.iterator();
		while(it3.hasNext()) 
			this.modeloListaTicketP.addElement(it3.next());
		}
	
	public void actualizaTicketsListaA(List<Ticket> tickets) {
		Ticket aux=null;
		this.modeloListaTicketsA.clear();
		Iterator<Ticket> it2=tickets.iterator();
		while(it2.hasNext()) {
			aux=it2.next();
			if(aux.getEstado()==EstadoTicket.ACTIVO)
			this.modeloListaTicketsA.addElement(aux);
		}
	}
	public Ticket ticketActivoSeleccionado() {
		return this.listTicketsA.getSelectedValue();
	}
	
	public void agregarTicket(List<Ticket> tickets) {
		this.modeloListaE.clear();
		Iterator<Ticket> it=tickets.iterator();
		while(it.hasNext())
			this.modeloListaE.addElement(it.next());
	}
	public Ticket ticketSeleccionado() {
		return this.listTicketsE.getSelectedValue();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnCrearTicket.addActionListener(actionListener);
		this.btnSuspender.addActionListener(actionListener);
		this.btnActivar.addActionListener(actionListener);
		this.btnEliminar.addActionListener(actionListener);
		this.btnSeleccionar.addActionListener(actionListener);
		this.btnNewButton_2.addActionListener(actionListener);
		this.btnNewButton_3.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.btnActualizarSolicitudes.addActionListener(actionListener);
		this.btnNewButton.addActionListener(actionListener);
	}

	@Override
	public void visible(boolean b) {
		this.setVisible(b);

	}

	@Override
	public void setWindowListener(WindowListener w) {
		this.addWindowListener(w);

	}
	
	public String getLocacion() {
		return this.comboBoxLocacion.getSelectedItem().toString();
	}
	
	public String getRemuneracion() {
		return this.comboBoxRemu.getSelectedItem().toString();
	}
	
	public String getCarga() {
		return this.comboBoxCarga.getSelectedItem().toString();
	}
	
	public String getEstudios() {
		return this.comboBoxEstudios.getSelectedItem().toString();
	}
	
	public String getPuesto() {
		return this.comboBoxPuesto.getSelectedItem().toString();
	}
	
	public String getRango() {
		return this.comboBoxRango.getSelectedItem().toString();
	}
	
	public String getExp() {
		return this.comboBoxExp.getSelectedItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
