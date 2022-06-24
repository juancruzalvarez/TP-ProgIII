package interfaz;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements IVista, KeyListener{

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldPass;
	private JButton btnLogin;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(65, 90, 63, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblPaswword = new JLabel("Contrase\u00F1a:");
		lblPaswword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaswword.setBounds(65, 132, 82, 17);
		contentPane.add(lblPaswword);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(157, 91, 134, 19);
		contentPane.add(textFieldUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(65, 42, 84, 17);
		contentPane.add(lblNewLabel_1);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(94, 185, 104, 23);
		contentPane.add(btnRegister);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(221, 185, 70, 23);
		contentPane.add(btnLogin);
		
		this.textFieldPass = new JPasswordField();
		this.textFieldPass.setBounds(157, 132, 134, 20);
		this.contentPane.add(this.textFieldPass);
		
		
		this.textFieldPass.addKeyListener(this);
		this.textFieldUsuario.addKeyListener(this);
		
		this.btnLogin.setEnabled(false);
		this.setVisible(true);
		this.setResizable(false);
	}


	@Override
	public void setActionListener(ActionListener a) {
		this.btnLogin.addActionListener(a);
		this.btnRegister.addActionListener(a);
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
		String username = this.textFieldUsuario.getText();
		char[] password = this.textFieldPass.getPassword();
		
		boolean cond = (!username.isEmpty() && password.length != 0);
		this.btnLogin.setEnabled(cond);
	}
	
	public String getTextUsuario() {
		return this.textFieldUsuario.getText();
	}
	
	public String getTextPass() {
		String aux = new String(this.textFieldPass.getPassword());
		return aux;
	}
	
	public void usuarioInexistente() {
		this.textFieldPass.setText("");
		this.textFieldUsuario.setText("");
		this.btnLogin.setEnabled(false);
	}
	
	public void contraseniaMal() {
		this.textFieldPass.setText("");
		this.btnLogin.setEnabled(false);
	}
	
}
