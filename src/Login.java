import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_usuario;
	private JPasswordField passwordField;
	//public static String users="";
	public static String tipo;
	public static String nombre;

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
		setTitle("Iniciar Sesión");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/Bulme24.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 740, 474);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(260, 143, 62, 23);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(262, 219, 98, 25);
		contentPane.add(lblContrasea);
		
		textField_usuario = new JTextField();
		textField_usuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
					
				}
			}
		});
		textField_usuario.setBounds(260, 180, 191, 20);
		contentPane.add(textField_usuario);
		textField_usuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Ingresar();
				}
				
			}
		});
		passwordField.setBounds(260, 256, 191, 20);
		contentPane.add(passwordField);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio c=new Inicio();
				c.setVisible(true);
				Login.this.dispose();
			}
		});
		btnVolver.setBounds(115, 386, 91, 23);
		contentPane.add(btnVolver);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_usuario.setText("");
				passwordField.setText("");
			}
		});
		btnCancelar.setBounds(522, 386, 91, 23);
		contentPane.add(btnCancelar);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar();
			}
		});
		btnIngresar.setBounds(317, 386, 91, 23);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Inicio.png")));
		label.setBounds(-11, 0, 735, 435);
		contentPane.add(label);
	}
	int error=0;
	//comienzo del metodo
	void Ingresar(){
		int encontrado=0;
		//users=textField_usuario.getText();
		String user=textField_usuario.getText();
		String pass=passwordField.getText();
		//conexion-consulta base de datos
		try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
		Statement comando = conexion.createStatement();
		ResultSet resultado = comando.executeQuery("select * from usuarios where usuario='"+user+"'and password='"+pass+"' ");
		if(resultado.next()){
		encontrado=1;
		if(encontrado==1) {
		nombre=resultado.getString(2);
		tipo=resultado.getString(5);
		Sistema abrir=new Sistema();
		abrir.setVisible(true);
		Login.this.dispose();
		    }
		}
		else if (error<=2){
		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
		textField_usuario.setText("");
		passwordField.setText("");
		textField_usuario.requestFocus();
		error=error+1;
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto \n por 3° vez","ERROR",JOptionPane.ERROR_MESSAGE);
			dispose();
			}
		}//fin del try
			catch (Exception e) {
			setTitle(e.toString());
			JOptionPane.showMessageDialog(null,"Problemas al ingresar");
			}
	}//final del metodo
}//fin del JFRame
