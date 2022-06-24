package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VentanaEmpleadoPretenso extends JFrame implements IVista {

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
	private JComboBox comboBoxLocacion;
	private JComboBox comboBoxRemu;
	private JComboBox comboBoxCarga;
	private JComboBox comboBoxPuesto;
	private JComboBox comboBoxRango;
	private JComboBox comboBoxExp;
	private JComboBox comboBoxEstudios;
	private JButton btnNewButton;
	private JPanel panel_3;
	private JLabel lblMisTickets;
	private JScrollPane scrollPane;
	private JList list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_16;
	private JScrollPane scrollPane_1;
	private JList list_1;
	private JButton btnGenerarContrato;
	private JLabel lblNewLabel_17;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_5;
	private JList list_2;
	private JScrollPane scrollPane_3;
	private JList list_3;

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
		this.comboBoxLocacion.setBounds(90, 45, 77, 22);
		this.panel_2.add(this.comboBoxLocacion);
		comboBoxLocacion.addItem("Home Office");
		comboBoxLocacion.addItem("Presencial");
		comboBoxLocacion.addItem("Indistinto");

		this.comboBoxRemu = new JComboBox();
		this.comboBoxRemu.setBounds(90, 92, 77, 22);
		this.panel_2.add(this.comboBoxRemu);
		comboBoxRemu.addItem("hasta V1");
		comboBoxRemu.addItem("entre V1 y V2");
		comboBoxRemu.addItem("mas de V2");

		this.comboBoxCarga = new JComboBox();
		this.comboBoxCarga.setBounds(90, 142, 77, 22);
		this.panel_2.add(this.comboBoxCarga);
		comboBoxCarga.addItem("media");
		comboBoxCarga.addItem("completa");
		comboBoxCarga.addItem("extendida");

		this.comboBoxPuesto = new JComboBox();
		this.comboBoxPuesto.setBounds(400, 42, 77, 22);
		this.panel_2.add(this.comboBoxPuesto);
		comboBoxPuesto.addItem("junior");
		comboBoxPuesto.addItem("senior");
		comboBoxPuesto.addItem("managment");

		this.comboBoxRango = new JComboBox();
		this.comboBoxRango.setBounds(400, 92, 77, 22);
		this.panel_2.add(this.comboBoxRango);
		comboBoxRango.addItem("menos de 40");
		comboBoxRango.addItem("40 a 50");
		comboBoxRango.addItem("mas de 50");

		this.comboBoxExp = new JComboBox();
		this.comboBoxExp.setBounds(400, 142, 77, 22);
		this.panel_2.add(this.comboBoxExp);
		comboBoxExp.addItem("nada");
		comboBoxExp.addItem("media");
		comboBoxExp.addItem("mucha");

		this.comboBoxEstudios = new JComboBox();
		this.comboBoxEstudios.setBounds(90, 192, 77, 22);
		this.panel_2.add(this.comboBoxEstudios);
		comboBoxEstudios.addItem("primario");
		comboBoxEstudios.addItem("secundario");
		comboBoxEstudios.addItem("terciario");

		this.btnNewButton = new JButton("Crear Ticket");
		this.btnNewButton.setBounds(446, 223, 107, 23);
		this.panel_2.add(this.btnNewButton);

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

		this.list = new JList();
		this.scrollPane.setViewportView(this.list);

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
		this.panel_Lista_Empleados.setLayout(null);

		this.lblNewLabel_16 = new JLabel(" Lista de Empleadores");
		this.lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_16.setBounds(10, 11, 206, 14);
		this.panel_Lista_Empleados.add(this.lblNewLabel_16);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 47, 578, 243);
		this.panel_Lista_Empleados.add(this.scrollPane_1);

		this.list_1 = new JList();
		this.scrollPane_1.setViewportView(this.list_1);

		this.btnGenerarContrato = new JButton("Generar Contrato");
		this.btnGenerarContrato.setBounds(232, 301, 117, 23);
		this.panel_Lista_Empleados.add(this.btnGenerarContrato);

		this.panel_resultados = new JPanel();
		this.tabbedPane.addTab("Resultados", null, this.panel_resultados, null);
		this.panel_resultados.setLayout(null);

		this.lblNewLabel_17 = new JLabel("Resultados De La Busqueda");
		this.lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_17.setBounds(10, 11, 191, 14);
		this.panel_resultados.add(this.lblNewLabel_17);

		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(10, 36, 578, 220);
		this.panel_resultados.add(this.scrollPane_2);

		this.list_2 = new JList();
		this.scrollPane_2.setViewportView(this.list_2);

		this.btnNewButton_5 = new JButton("Ver Detalles");
		this.btnNewButton_5.setBounds(250, 267, 107, 23);
		this.panel_resultados.add(this.btnNewButton_5);

		this.scrollPane_3 = new JScrollPane();
		this.scrollPane_3.setBounds(10, 307, 578, 134);
		this.panel_resultados.add(this.scrollPane_3);

		this.list_3 = new JList();
		this.scrollPane_3.setViewportView(this.list_3);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnNewButton.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.btnNewButton_2.addActionListener(actionListener);
		this.btnNewButton_3.addActionListener(actionListener);
		this.btnGenerarContrato.addActionListener(actionListener);
		this.btnNewButton_5.addActionListener(actionListener);
	}

	@Override
	public void visible(boolean b) {
		this.setVisible(b);

	}

	@Override
	public void setWindowListener(WindowListener w) {
		this.addWindowListener(w);

	}
}
