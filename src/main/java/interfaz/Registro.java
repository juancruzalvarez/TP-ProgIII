package interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sistema.usuarios.RubroEmpleador;
import sistema.usuarios.TipoEmpleador;

public class Registro extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFIeldnombreUsuario;
	private JTextField textFieldUserE;
	private JTextField textFieldNombreE;
	private JPasswordField textFieldPassword;
	private JPasswordField passField;
	private JComboBox<String> comboBoxRubro;
	private JComboBox<String> comboBoxTipoPersona;
	private JButton btnRegistrarEmpleadoPretenso;
	private JButton btnRegistrarEmpleador;
	private JTextField textField_dia;
	private JTextField textFieldmes;
	private JTextField textFieldyear;
	private JLabel Dia;
	private JLabel lblMes;
	private JLabel lblYear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		this.setTitle("Registro nuevo usuario");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 766, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado Pretenso");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(105, 25, 176, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 77, 134, 13);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 173, 145, 13);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 217, 145, 13);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Usuario");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(10, 264, 145, 13);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Apellido");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 121, 134, 13);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_1.setBounds(10, 313, 145, 13);
		panel_1.add(lblNewLabel_1_5_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(127, 76, 207, 19);
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(127, 120, 207, 19);
		panel_1.add(textFieldApellido);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(127, 172, 207, 19);
		panel_1.add(textFieldTelefono);
		
		textFIeldnombreUsuario = new JTextField();
		textFIeldnombreUsuario.setColumns(10);
		textFIeldnombreUsuario.setBounds(127, 263, 207, 19);
		panel_1.add(textFIeldnombreUsuario);
		
		btnRegistrarEmpleadoPretenso = new JButton("Registrar empleado pretenso");
	
		
		btnRegistrarEmpleadoPretenso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarEmpleadoPretenso.setBounds(79, 386, 202, 30);
		panel_1.add(btnRegistrarEmpleadoPretenso);
		
		this.textFieldPassword = new JPasswordField();
		this.textFieldPassword.setBounds(127, 311, 207, 20);
		panel_1.add(this.textFieldPassword);
		
		this.textField_dia = new JTextField();
		this.textField_dia.setBounds(174, 216, 26, 18);
		panel_1.add(this.textField_dia);
		this.textField_dia.setColumns(10);
		
		this.textFieldmes = new JTextField();
		this.textFieldmes.setColumns(10);
		this.textFieldmes.setBounds(235, 217, 26, 18);
		panel_1.add(this.textFieldmes);
		
		this.textFieldyear = new JTextField();
		this.textFieldyear.setColumns(10);
		this.textFieldyear.setBounds(295, 216, 26, 18);
		panel_1.add(this.textFieldyear);
		
		this.Dia = new JLabel("Dia");
		this.Dia.setBounds(154, 218, 46, 14);
		panel_1.add(this.Dia);
		
		this.lblMes = new JLabel("Mes");
		this.lblMes.setBounds(210, 218, 46, 14);
		panel_1.add(this.lblMes);
		
		this.lblYear = new JLabel("Year");
		this.lblYear.setBounds(271, 218, 46, 14);
		panel_1.add(this.lblYear);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Empleador");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(124, 26, 145, 13);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Usuario");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_2.setBounds(34, 238, 145, 13);
		panel_2.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_1_1.setBounds(34, 287, 145, 13);
		panel_2.add(lblNewLabel_1_5_1_1);
		
		textFieldUserE = new JTextField();
		textFieldUserE.setColumns(10);
		textFieldUserE.setBounds(123, 237, 223, 19);
		panel_2.add(textFieldUserE);
		
		btnRegistrarEmpleador = new JButton("Registrar empleador");
		btnRegistrarEmpleador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarEmpleador.setBounds(124, 386, 145, 30);
		panel_2.add(btnRegistrarEmpleador);
		
		JLabel lblNewLabel_1_5_2_1 = new JLabel("Nombre o razon social");
		lblNewLabel_1_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_2_1.setBounds(34, 71, 145, 30);
		panel_2.add(lblNewLabel_1_5_2_1);
		
		textFieldNombreE = new JTextField();
		textFieldNombreE.setColumns(10);
		textFieldNombreE.setBounds(189, 79, 157, 19);
		panel_2.add(textFieldNombreE);
		
		comboBoxTipoPersona = new JComboBox<String>();
		comboBoxTipoPersona.setBounds(189, 124, 157, 21);
		panel_2.add(comboBoxTipoPersona);
		
		JLabel lblNewLabel_1_5_2_1_1 = new JLabel("Tipo de persona");
		lblNewLabel_1_5_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_2_1_1.setBounds(34, 117, 145, 30);
		panel_2.add(lblNewLabel_1_5_2_1_1);
		
		JLabel lblNewLabel_1_5_2_1_1_1 = new JLabel("Rubro");
		lblNewLabel_1_5_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_2_1_1_1.setBounds(34, 161, 145, 30);
		panel_2.add(lblNewLabel_1_5_2_1_1_1);
		
		comboBoxRubro = new JComboBox<String>();
		comboBoxRubro.setBounds(189, 168, 157, 21);
		panel_2.add(comboBoxRubro);
		
		this.passField = new JPasswordField();
		this.passField.setBounds(123, 285, 223, 20);
		panel_2.add(this.passField);
		
		
		comboBoxTipoPersona.addItem("Persona fisica");
		comboBoxTipoPersona.addItem("Presona juridica");
		
		comboBoxRubro.addItem("Salud");
		comboBoxRubro.addItem("Comercio local");
		comboBoxRubro.addItem("Comercio internacional");
		
		this.setVisible(true);
		this.setResizable(false);
		
		this.textFieldNombre.addKeyListener(this);
		this.textFieldApellido.addKeyListener(this);
		this.textFieldTelefono.addKeyListener(this);
		this.textField_dia.addKeyListener(this);
		this.textFieldmes.addKeyListener(this);
		this.textFieldyear.addKeyListener(this);
		this.textFieldPassword.addKeyListener(this);
		this.btnRegistrarEmpleadoPretenso.setEnabled(false);
		
		this.textFieldNombreE.addKeyListener(this);
		this.textFieldUserE.addKeyListener(this);
		this.passField.addKeyListener(this);
		this.comboBoxRubro.addKeyListener(this);
		this.comboBoxTipoPersona.addKeyListener(this);
	}
	
	public void addActionListener() {
		
		
		
	}

	@Override
	public void visible(boolean b) {
		this.setVisible(b);
		
	}
	
	@Override
	public void setActionListener(ActionListener a) {
		this.btnRegistrarEmpleadoPretenso.addActionListener(a);
		this.btnRegistrarEmpleador.addActionListener(a);
		
	}
	
	@Override
	public void setWindowListener(WindowListener w) {
		this.addWindowListener(w);
	}
	
	public String getNombreE() {
		return this.textFieldNombreE.getText();
	}
	
	public String getNombre() {
		return this.textFieldNombre.getText();
	}
	
	public String getApellido() {
		return this.textFieldApellido.getText();
	}
	
	public String getTelefono() {
		return this.textFieldTelefono.getText();
	}
	
	public LocalDate getEdad() {
		int dia=Integer.parseInt(this.textField_dia.getText()),mes=Integer.parseInt(this.textFieldmes.getText()),year=Integer.parseInt(this.textFieldyear.getText());
		return LocalDate.of(year, mes, dia);
	}
	
	public String getNombreUsuarioE() {
		return this.textFieldUserE.getText();
	}
	
	public String getNombreUsuario() {
		return this.textFIeldnombreUsuario.getText();
	}
	
	public String getPassE() {
		String aux = new String(this.passField.getPassword());
		return aux;
	}
	
	public String getPass() {
		String aux = new String(this.textFieldPassword.getPassword());
		return aux;
	}
	public TipoEmpleador getTipoPersona() {
		if(this.comboBoxTipoPersona.getSelectedItem().toString().equals("Persona fisica"))
			return TipoEmpleador.PERSONA_FISICA;
		else if(this.comboBoxTipoPersona.getSelectedItem().toString().equals("Presona juridica"))
			return TipoEmpleador.PERSONA_JURIDICA;
		else return null;
	}
	

	public RubroEmpleador getRubro() {
		if(this.comboBoxRubro.getSelectedItem().toString().equals("Comercio internacional"))
			return RubroEmpleador.COMERCIO_INTERNACIONAL;
		else if(this.comboBoxRubro.getSelectedItem().toString().equals("Comercio local"))
			return RubroEmpleador.COMERCIO_LOCAL;
		else if(this.comboBoxRubro.getSelectedItem().toString().equals("Salud"))
			return RubroEmpleador.SALUD;
		else return null;
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
		String username = this.getNombreUsuario();
		String password = this.getPass();
		String nombre=this.getNombre();
		String apellido=this.getApellido();
		String tel=this.getTelefono();
		int dia=Integer.parseInt(this.textField_dia.getText()),mes=Integer.parseInt(this.textFieldmes.getText()),year=Integer.parseInt(this.textFieldyear.getText());
		
		
		boolean cond = (!username.isEmpty() && !password.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && (Pattern.matches("[a-zA-Z]+", tel) == false
				&& tel.length() >= 4) && dia>=1&&dia<=30 && mes<=12&&mes>=1 &&year>=1922&&year<=2004);
		this.btnRegistrarEmpleadoPretenso.setEnabled(cond);
		
	}
}