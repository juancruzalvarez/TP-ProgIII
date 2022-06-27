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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sistema.asignaciones.TicketPuntaje;
import sistema.contratos.Contrato;
import sistema.tickets.EstadoTicket;
import sistema.tickets.Formulario;
import sistema.tickets.Ticket;

public class VentanaEmpleador extends JFrame implements IVista,KeyListener, ActionListener{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Ticket;
	private JPanel panel_Lista_Empleados;
	private JPanel panel_resultados;
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
	private JTextField textFieldPlocacion;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField textFieldPremu;
	private JTextField textFieldPcarga;
	private JLabel lblNewLabel_11;
	private JTextField textFieldPpuesto;
	private JComboBox<String> comboBoxRango;
	private JComboBox<String> comboBoxExp;
	private JComboBox<String> comboBoxEstudios;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField textFieldPrango;
	private JTextField textFieldPexp;
	private JTextField textFieldPestudios;
	private JLabel lblNewLabel_15;
	private JTextField textFieldCantE;
	private JButton btnCrearTicket;
	private JPanel panel_3;
	private JLabel lblMisTickets;
	private JScrollPane scrollPane;
	private JList<Ticket> Ticket_list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_17;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_5;
	private JList<Contrato> listContrataciones;
	private JScrollPane scrollPane_3;
	private JList<Formulario> listDetalles;
	private DefaultListModel<Formulario> modeloListaFormu;
	private DefaultListModel<Ticket> modeloLista;
	private DefaultListModel<Ticket> modeloListaTicketsA;
	private DefaultListModel<TicketPuntaje> modeloListaTicketP;
	private DefaultListModel<Contrato> modeloListaCont;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_16;
	private JScrollPane scrollPane_1;
	private JList<Ticket> listTicketsActivados;
	private JButton btnNewButton;
	private JLabel lblNewLabel_18;
	private JScrollPane scrollPane_4;
	private JList<TicketPuntaje> listPosiblesE;
	private JButton btnNewButton_4;
	private JButton btnNewButton_6;
	private JButton btnContratos;
	private JButton btnNewButton_7;

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
	public VentanaEmpleador() {
		setTitle("Empleador");
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
		
		this.comboBoxLocacion = new JComboBox<String>();
		this.comboBoxLocacion.setBounds(90, 45, 77, 22);
		this.panel_2.add(this.comboBoxLocacion);
		comboBoxLocacion.addItem("Home Office");
		comboBoxLocacion.addItem("Presencial");
		comboBoxLocacion.addItem("Indistinto");
		
		this.comboBoxRemu = new JComboBox<String>();
		this.comboBoxRemu.setBounds(90, 92, 77, 22);
		this.panel_2.add(this.comboBoxRemu);
		comboBoxRemu.addItem("hasta V1");
		comboBoxRemu.addItem("entre V1 y V2");
		comboBoxRemu.addItem("mas de V2");
		
		this.comboBoxCarga = new JComboBox<String>();
		this.comboBoxCarga.setBounds(90, 142, 77, 22);
		this.panel_2.add(this.comboBoxCarga);
		comboBoxCarga.addItem("media");
		comboBoxCarga.addItem("completa");
		comboBoxCarga.addItem("extendida");
		
		this.comboBoxPuesto = new JComboBox<String>();
		this.comboBoxPuesto.setBounds(400, 42, 77, 22);
		this.panel_2.add(this.comboBoxPuesto);
		comboBoxPuesto.addItem("junior");
		comboBoxPuesto.addItem("senior");
		comboBoxPuesto.addItem("managment");
		
		this.textFieldPlocacion = new JTextField();
		this.textFieldPlocacion.setBounds(215, 45, 28, 22);
		this.panel_2.add(this.textFieldPlocacion);
		this.textFieldPlocacion.setColumns(10);
		
		this.lblNewLabel_8 = new JLabel("Peso:");
		this.lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_8.setBounds(180, 45, 46, 14);
		this.panel_2.add(this.lblNewLabel_8);
		
		this.lblNewLabel_9 = new JLabel("Peso:");
		this.lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_9.setBounds(180, 96, 46, 14);
		this.panel_2.add(this.lblNewLabel_9);
		
		this.lblNewLabel_10 = new JLabel("Peso:");
		this.lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_10.setBounds(180, 146, 46, 14);
		this.panel_2.add(this.lblNewLabel_10);
		
		this.textFieldPremu = new JTextField();
		this.textFieldPremu.setColumns(10);
		this.textFieldPremu.setBounds(215, 93, 28, 22);
		this.panel_2.add(this.textFieldPremu);
		
		this.textFieldPcarga = new JTextField();
		this.textFieldPcarga.setColumns(10);
		this.textFieldPcarga.setBounds(215, 143, 28, 22);
		this.panel_2.add(this.textFieldPcarga);
		
		this.lblNewLabel_11 = new JLabel("Peso:");
		this.lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_11.setBounds(490, 45, 46, 14);
		this.panel_2.add(this.lblNewLabel_11);
		
		this.textFieldPpuesto = new JTextField();
		this.textFieldPpuesto.setColumns(10);
		this.textFieldPpuesto.setBounds(525, 43, 28, 22);
		this.panel_2.add(this.textFieldPpuesto);
		
		this.comboBoxRango = new JComboBox<String>();
		this.comboBoxRango.setBounds(400, 92, 77, 22);
		this.panel_2.add(this.comboBoxRango);
		comboBoxRango.addItem("menos de 40");
		comboBoxRango.addItem("40 a 50");
		comboBoxRango.addItem("mas de 50");
		
		this.comboBoxExp = new JComboBox<String>();
		this.comboBoxExp.setBounds(400, 142, 77, 22);
		this.panel_2.add(this.comboBoxExp);
		comboBoxExp.addItem("nada");
		comboBoxExp.addItem("media");
		comboBoxExp.addItem("mucha");
		
		this.comboBoxEstudios = new JComboBox<String>();
		this.comboBoxEstudios.setBounds(90, 192, 77, 22);
		this.panel_2.add(this.comboBoxEstudios);
		comboBoxEstudios.addItem("primario");
		comboBoxEstudios.addItem("secundario");
		comboBoxEstudios.addItem("terciario");
		
		this.lblNewLabel_12 = new JLabel("Peso:");
		this.lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_12.setBounds(487, 96, 46, 14);
		this.panel_2.add(this.lblNewLabel_12);
		
		this.lblNewLabel_13 = new JLabel("Peso:");
		this.lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_13.setBounds(490, 146, 46, 14);
		this.panel_2.add(this.lblNewLabel_13);
		
		this.lblNewLabel_14 = new JLabel("Peso:");
		this.lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_14.setBounds(180, 195, 46, 14);
		this.panel_2.add(this.lblNewLabel_14);
		
		this.textFieldPrango = new JTextField();
		this.textFieldPrango.setColumns(10);
		this.textFieldPrango.setBounds(525, 93, 28, 22);
		this.panel_2.add(this.textFieldPrango);
		
		this.textFieldPexp = new JTextField();
		this.textFieldPexp.setColumns(10);
		this.textFieldPexp.setBounds(525, 143, 28, 22);
		this.panel_2.add(this.textFieldPexp);
		
		this.textFieldPestudios = new JTextField();
		this.textFieldPestudios.setColumns(10);
		this.textFieldPestudios.setBounds(215, 192, 28, 22);
		this.panel_2.add(this.textFieldPestudios);
		
		this.lblNewLabel_15 = new JLabel("Cantidad de empleados buscados:");
		this.lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.lblNewLabel_15.setBounds(300, 196, 209, 14);
		this.panel_2.add(this.lblNewLabel_15);
		
		this.textFieldCantE = new JTextField();
		this.textFieldCantE.setColumns(10);
		this.textFieldCantE.setBounds(506, 192, 47, 22);
		this.panel_2.add(this.textFieldCantE);
		
		this.btnCrearTicket = new JButton("Crear Ticket");
		this.btnCrearTicket.setBounds(446, 223, 107, 23);
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
		
		this.Ticket_list = new JList<Ticket>();
		this.scrollPane.setViewportView(this.Ticket_list);
		
		this.btnNewButton_1 = new JButton("Suspender");
		this.btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnNewButton_1.setBounds(122, 181, 106, 23);
		this.panel_3.add(this.btnNewButton_1);
		
		this.btnNewButton_2 = new JButton("Activar");
		this.btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnNewButton_2.setBounds(238, 181, 106, 23);
		this.panel_3.add(this.btnNewButton_2);
		
		this.btnNewButton_3 = new JButton("Eliminar");
		this.btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnNewButton_3.setBounds(354, 181, 106, 23);
		this.panel_3.add(this.btnNewButton_3);
		
		this.panel_Lista_Empleados = new JPanel();
		this.tabbedPane.addTab("Contrataciones", null, this.panel_Lista_Empleados, null);
		this.panel_Lista_Empleados.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_resultados = new JPanel();
		this.tabbedPane.addTab("Resultados", null, this.panel_resultados, null);
		this.panel_resultados.setLayout(null);
		
		
		this.lblNewLabel_17 = new JLabel("Mis Contrataciones");
		this.lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_17.setBounds(10, 11, 191, 14);
		this.panel_resultados.add(this.lblNewLabel_17);
		
		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(10, 36, 578, 220);
		this.panel_resultados.add(this.scrollPane_2);
		
		this.listContrataciones = new JList<Contrato>();
		this.scrollPane_2.setViewportView(this.listContrataciones);
		
		this.btnNewButton_5 = new JButton("Ver Detalles");
		this.btnNewButton_5.setBounds(250, 267, 107, 23);
		this.panel_resultados.add(this.btnNewButton_5);
		
		this.scrollPane_3 = new JScrollPane();
		this.scrollPane_3.setBounds(10, 307, 578, 134);
		this.panel_resultados.add(this.scrollPane_3);
		
		this.listDetalles = new JList<Formulario>();
		this.scrollPane_3.setViewportView(this.listDetalles);
		
		
		this.btnContratos = new JButton("Actualizar Contratos");
		this.btnContratos.setBounds(10, 267, 165, 23);
		this.panel_resultados.add(this.btnContratos);
		
		this.panel = new JPanel();
		this.panel_Lista_Empleados.add(this.panel);
		this.panel.setLayout(null);
		
		this.lblNewLabel_16 = new JLabel("Tickets Activados por la Ronda");
		this.lblNewLabel_16.setBounds(10, 11, 221, 19);
		this.lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.panel.add(this.lblNewLabel_16);
		
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 40, 279, 366);
		this.panel.add(this.scrollPane_1);
		
		this.listTicketsActivados = new JList<Ticket>();
		this.scrollPane_1.setViewportView(this.listTicketsActivados);
		
		this.btnNewButton = new JButton("Seleccionar");
		this.btnNewButton.setBounds(176, 417, 113, 23);
		this.panel.add(this.btnNewButton);
		
		this.btnNewButton_6 = new JButton("Actualizar Lista");
		this.btnNewButton_6.setBounds(10, 417, 132, 23);
		this.panel.add(this.btnNewButton_6);
		
		this.panel_1 = new JPanel();
		this.panel_Lista_Empleados.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.lblNewLabel_18 = new JLabel("Posibles Empleados");
		this.lblNewLabel_18.setBounds(10, 11, 153, 19);
		this.lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.panel_1.add(this.lblNewLabel_18);
		
		this.scrollPane_4 = new JScrollPane();
		this.scrollPane_4.setBounds(10, 41, 279, 366);
		this.panel_1.add(this.scrollPane_4);
		
		this.listPosiblesE = new JList<TicketPuntaje>();
		this.scrollPane_4.setViewportView(this.listPosiblesE);
		
		this.btnNewButton_4 = new JButton("Contratar");
		this.btnNewButton_4.setBounds(200, 418, 89, 23);
		this.panel_1.add(this.btnNewButton_4);
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
		this.textFieldPlocacion.addKeyListener(this);
		this.textFieldPremu.addKeyListener(this);
		this.textFieldPcarga.addKeyListener(this);
		this.textFieldPestudios.addKeyListener(this);
		this.textFieldPrango.addKeyListener(this);
		this.textFieldPexp.addKeyListener(this);
		this.textFieldPpuesto.addKeyListener(this);
		this.textFieldCantE.addKeyListener(this);
		this.btnCrearTicket.addKeyListener(this);
		this.btnNewButton_6.addKeyListener(this);
		
		this.modeloLista=new DefaultListModel<Ticket>();
		this.Ticket_list.setModel(modeloLista);
		
		this.btnNewButton_7 = new JButton(" Actualizar  ");
		this.btnNewButton_7.setBounds(482, 181, 106, 23);
		this.panel_3.add(this.btnNewButton_7);
		
		this.modeloListaTicketsA=new DefaultListModel<Ticket>();
		this.listTicketsActivados.setModel(modeloListaTicketsA);
		
		this.modeloListaTicketP=new DefaultListModel<TicketPuntaje>();
		this.listPosiblesE.setModel(modeloListaTicketP);
		
		this.modeloListaFormu=new DefaultListModel<Formulario>();
		this.listDetalles.setModel(modeloListaFormu);
		
		this.modeloListaCont=new DefaultListModel<Contrato>();
		this.listContrataciones.setModel(modeloListaCont);
	}
	
	public Contrato SeleccionCont() {
		return this.listContrataciones.getSelectedValue();
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
			if(aux.getTicketEmpleador().getNombreDeUsuario().equals(username))
			this.modeloListaCont.addElement(aux);
		
		}
	}
	
	public TicketPuntaje EmpleadoAcontratar() {
		return this.listPosiblesE.getSelectedValue();
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
		return this.listTicketsActivados.getSelectedValue();
	}
	
	public void agregarTicket(List<Ticket> tickets) {
		this.modeloLista.clear();
		Iterator<Ticket> it=tickets.iterator();
		while(it.hasNext())
			this.modeloLista.addElement(it.next());
	}
	public Ticket ticketSeleccionado() {
		return this.Ticket_list.getSelectedValue();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnCrearTicket.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.btnNewButton_2.addActionListener(actionListener);
		this.btnNewButton_3.addActionListener(actionListener);
		this.btnNewButton_4.addActionListener(actionListener);
		this.btnNewButton_5.addActionListener(actionListener);
		this.btnNewButton_6.addActionListener(actionListener);
		this.btnNewButton.addActionListener(actionListener);
		this.btnContratos.addActionListener(actionListener);
		this.btnNewButton_7.addActionListener(actionListener);
		
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
	public int getLocacionP() {
		return Integer.parseInt(this.textFieldPlocacion.getText());
	}
	public String getRemuneracion() {
		return this.comboBoxRemu.getSelectedItem().toString();
	}
	public int getRemuneracionP() {
		return Integer.parseInt(this.textFieldPremu.getText());
	}
	public String getCarga() {
		return this.comboBoxCarga.getSelectedItem().toString();
	}
	public int getCargaP() {
		return Integer.parseInt(this.textFieldPcarga.getText());
	}
	public String getEstudios() {
		return this.comboBoxEstudios.getSelectedItem().toString();
	}
	public int getEstudiosP() {
		return Integer.parseInt(this.textFieldPestudios.getText());
	}
	public String getPuesto() {
		return this.comboBoxPuesto.getSelectedItem().toString();
	}
	public int getPuestoP() {
		return Integer.parseInt(this.textFieldPpuesto.getText());
	}
	public String getRango() {
		return this.comboBoxRango.getSelectedItem().toString();
	}
	public int getRangoP() {
		return Integer.parseInt(this.textFieldPrango.getText());
	}
	public String getExp() {
		return this.comboBoxExp.getSelectedItem().toString();
	}
	public int getExpP() {
		return Integer.parseInt(this.textFieldPexp.getText());
	}
	public int getCantEmpleados() {
		return Integer.parseInt(this.textFieldCantE.getText());
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
	public void actionPerformed(ActionEvent e) {
	}
}
