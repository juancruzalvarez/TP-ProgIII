package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import sistema.contratos.Contrato;
import sistema.tickets.Ticket;
import sistema.usuarios.Usuario;

public class VentanaSimulacion extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton1;
	private JButton btnFinalizarSimulacion;
	private JScrollPane scrollPane;
	private JTextArea Detalles;

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
	public VentanaSimulacion() {
		setTitle("Simulacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 560);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(0, 0, 603, 520);
		this.contentPane.add(this.tabbedPane);
		
		this.panel = new JPanel();
		this.tabbedPane.addTab("Simulacion", null, this.panel, null);
		this.panel.setLayout(null);
		
		this.lblNewLabel = new JLabel("Control de Simulacion");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel.setBounds(10, 11, 148, 31);
		this.panel.add(this.lblNewLabel);
		
		this.btnNewButton1 = new JButton("Iniciar Simulacion");
		this.btnNewButton1.setBounds(103, 53, 180, 39);
		this.panel.add(this.btnNewButton1);
		
		this.btnFinalizarSimulacion = new JButton("Finalizar Simulacion");
		this.btnFinalizarSimulacion.setBounds(319, 53, 180, 39);
		this.panel.add(this.btnFinalizarSimulacion);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 105, 578, 376);
		this.panel.add(this.scrollPane);
		
		this.Detalles = new JTextArea();
		this.scrollPane.setViewportView(this.Detalles);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.btnFinalizarSimulacion.setEnabled(false);

	}

	public void actualizarDetalles(String act) {
		this.Detalles.append(act+"\n");
	}
	public void actualizarStart(int size) {
		this.Detalles.append("Simulacion Iniciada\n");
		this.Detalles.append("Size: "+ size+"\n");
		this.btnFinalizarSimulacion.setEnabled(true);;
	}
	
	public void actualizarStop() {
		this.Detalles.append("\nSimulacion Finalizada\n");
		this.btnFinalizarSimulacion.setEnabled(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnFinalizarSimulacion.addActionListener(actionListener);
		this.btnNewButton1.addActionListener(actionListener);
		
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

	}
}
