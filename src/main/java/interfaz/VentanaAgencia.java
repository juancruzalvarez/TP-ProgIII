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

public class VentanaAgencia extends JFrame implements IVista {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Ticket;
	private JPanel panel_Lista;
	private JPanel panel_Comisiones;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_Empleadores;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JList list_empleadores;
	private JPanel panel_Empleados;
	private JLabel lblListaDeEmpleados;
	private JScrollPane scrollPane_Empleados;
	private JList listEmpleados;
	private JLabel lblUsuariosACobrar;
	private JScrollPane scrollPane_1;
	private JList list;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JButton btnGananciasTotales;
	private JTextField textField_2;

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
		
		this.panel_3 = new JPanel();
		this.panel_Ticket.add(this.panel_3);
		this.panel_3.setLayout(null);
		
		this.panel_Lista = new JPanel();
		this.tabbedPane.addTab("Usuarios", null, this.panel_Lista, null);
		this.panel_Lista.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_Empleadores = new JPanel();
		this.panel_Lista.add(this.panel_Empleadores);
		this.panel_Empleadores.setLayout(null);
		
		this.lblNewLabel = new JLabel("Lista De Empleadores y Solicitudes");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel.setBounds(10, 11, 223, 19);
		this.panel_Empleadores.add(this.lblNewLabel);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 45, 279, 436);
		this.panel_Empleadores.add(this.scrollPane);
		
		this.list_empleadores = new JList();
		this.scrollPane.setViewportView(this.list_empleadores);
		
		this.panel_Empleados = new JPanel();
		this.panel_Lista.add(this.panel_Empleados);
		this.panel_Empleados.setLayout(null);
		
		this.lblListaDeEmpleados = new JLabel("Lista De Empleados y Solicitudes");
		this.lblListaDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblListaDeEmpleados.setBounds(10, 11, 223, 19);
		this.panel_Empleados.add(this.lblListaDeEmpleados);
		
		this.scrollPane_Empleados = new JScrollPane();
		this.scrollPane_Empleados.setBounds(10, 45, 279, 436);
		this.panel_Empleados.add(this.scrollPane_Empleados);
		
		this.listEmpleados = new JList();
		this.scrollPane_Empleados.setViewportView(this.listEmpleados);
		
		this.panel_Comisiones = new JPanel();
		this.tabbedPane.addTab("Comisiones", null, this.panel_Comisiones, null);
		this.panel_Comisiones.setLayout(null);
		
		this.lblUsuariosACobrar = new JLabel("Contratos Cerrados");
		this.lblUsuariosACobrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblUsuariosACobrar.setBounds(10, 11, 223, 19);
		this.panel_Comisiones.add(this.lblUsuariosACobrar);
		
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 41, 264, 440);
		this.panel_Comisiones.add(this.scrollPane_1);
		
		this.list = new JList();
		this.scrollPane_1.setViewportView(this.list);
		
		this.btnNewButton = new JButton("Calcular Comision");
		this.btnNewButton.setBounds(310, 142, 122, 31);
		this.panel_Comisiones.add(this.btnNewButton);
		
		this.lblNewLabel_1 = new JLabel("El Empleador Paga:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_1.setBounds(310, 185, 111, 19);
		this.panel_Comisiones.add(this.lblNewLabel_1);
		
		this.textField = new JTextField();
		this.textField.setBounds(438, 185, 86, 20);
		this.panel_Comisiones.add(this.textField);
		this.textField.setColumns(10);
		
		this.lblNewLabel_2 = new JLabel("El Empleador Paga:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblNewLabel_2.setBounds(310, 224, 111, 19);
		this.panel_Comisiones.add(this.lblNewLabel_2);
		
		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.textField_1.setBounds(438, 224, 86, 20);
		this.panel_Comisiones.add(this.textField_1);
		
		this.btnGananciasTotales = new JButton("Calcular Ganancias Totales");
		this.btnGananciasTotales.setBounds(310, 293, 172, 31);
		this.panel_Comisiones.add(this.btnGananciasTotales);
		
		this.textField_2 = new JTextField();
		this.textField_2.setBounds(310, 335, 172, 20);
		this.panel_Comisiones.add(this.textField_2);
		this.textField_2.setColumns(10);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnGananciasTotales.addActionListener(actionListener);
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
}


