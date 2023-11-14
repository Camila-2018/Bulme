import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class AltasUser extends JInternalFrame {
	public static JTextField tFid_user;
	public static JTextField tFtipo;
	public static JTextField tFnom;
	public static JTextField tFuser;
	public static JTextField tFpass;
	
	public static String cuser;
	public static int aumentar=0;
	public String u="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasUser frame = new AltasUser();
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
	public AltasUser() {
		cuser="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				cuser=null;
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Altas de Usuarios");
		setBounds(100, 100, 800, 519);
		getContentPane().setLayout(null);
		
		JLabel lblusuario = new JLabel("");
		lblusuario.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/User.png")));
		lblusuario.setBounds(100, 89, 82, 82);
		getContentPane().add(lblusuario);
		
		JLabel lblAltasDeClientes = new JLabel("Altas de Usuarios");
		lblAltasDeClientes.setBounds(80, 35, 177, 23);
		getContentPane().add(lblAltasDeClientes);
		lblAltasDeClientes.setForeground(new Color(255, 255, 255));
		lblAltasDeClientes.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JLabel lbldatosg = new JLabel("Datos Generales");
		lbldatosg.setForeground(new Color(255, 255, 255));
		lbldatosg.setFont(new Font("Verdana", Font.BOLD, 16));
		lbldatosg.setBounds(243, 118, 145, 21);
		getContentPane().add(lbldatosg);
		
		JLabel lblid_user = new JLabel("C\u00D3DIGO");
		lblid_user.setForeground(new Color(0, 0, 153));
		lblid_user.setFont(new Font("Verdana", Font.BOLD, 12));
		lblid_user.setBounds(117, 200, 59, 17);
		getContentPane().add(lblid_user);
		
		JLabel lbltipo = new JLabel("TIPO");
		lbltipo.setForeground(new Color(0, 0, 153));
		lbltipo.setFont(new Font("Verdana", Font.BOLD, 12));
		lbltipo.setBounds(117, 252, 42, 16);
		getContentPane().add(lbltipo);
		
		JLabel lblnom = new JLabel("NOMBRE");
		lblnom.setForeground(new Color(0, 0, 153));
		lblnom.setFont(new Font("Verdana", Font.BOLD, 12));
		lblnom.setBounds(117, 304, 63, 17);
		getContentPane().add(lblnom);
		
		JLabel lblnomuser = new JLabel("USUARIO");
		lblnomuser.setForeground(new Color(0, 0, 153));
		lblnomuser.setFont(new Font("Verdana", Font.BOLD, 12));
		lblnomuser.setBounds(117, 356, 64, 16);
		getContentPane().add(lblnomuser);
		
		JLabel lblpass = new JLabel("CONTRASE\u00D1A");
		lblpass.setForeground(new Color(0, 0, 153));
		lblpass.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpass.setBounds(117, 408, 92, 16);
		getContentPane().add(lblpass);
		
		tFid_user = new JTextField();
		tFid_user.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_user.setDisabledTextColor(new Color(0, 0, 0));
		tFid_user.setSelectionColor(new Color(255, 255, 255));
		tFid_user.setFont(new Font("Tahoma", Font.BOLD, 12));
		codigo();
		tFid_user.setEnabled(false);
		tFid_user.setText(u);
		tFid_user.setBounds(224, 199, 112, 20);
		getContentPane().add(tFid_user);
		tFid_user.setColumns(10);
		
		/**tFtipo = new JTextField();
		tFtipo.setBounds(224, 251, 210, 20);
		getContentPane().add(tFtipo);
		tFtipo.setColumns(10);*/
		
		JComboBox cbtipo = new JComboBox();
		cbtipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbtipo.setBackground(new Color(255, 255, 255));
		cbtipo.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "administrador", "jefe", "vendedor"}));
		cbtipo.setBounds(224, 251, 210, 20);
		getContentPane().add(cbtipo);
		
		tFnom = new JTextField();
		tFnom.setBounds(224, 303, 210, 20);
		getContentPane().add(tFnom);
		tFnom.setColumns(10);
		
		tFuser = new JTextField();
		tFuser.setBounds(224, 355, 210, 20);
		getContentPane().add(tFuser);
		tFuser.setColumns(10);
		
		tFpass = new JTextField();
		tFpass.setBounds(224, 407, 210, 20);
		getContentPane().add(tFpass);
		tFpass.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(AltasUser.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFid_user.setText("");
				cbtipo.setSelectedItem("Tipo");
				tFnom.setText("");
				tFuser.setText("");
				tFpass.setText("");
				codigo();
				tFid_user.setText(u);
			}
		});
		btnNuevo.setBounds(581, 290, 117, 33);
		getContentPane().add(btnNuevo);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasUser.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(681, 27, 60, 60);
		getContentPane().add(label_1);
		
		JPanel paneldatos = new JPanel();
		paneldatos.setBackground(new Color(247, 186, 42));
		paneldatos.setBounds(200, 113, 232, 33);
		getContentPane().add(paneldatos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JPanel panel_cuad = new JPanel();
		panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		panel_cuad.setBackground(new Color(255, 255, 255));
		panel_cuad.setBounds(80, 136, 438, 319);
		getContentPane().add(panel_cuad);
		panel_cuad.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AltasUser.class.getResource("/Imagenes/cancelar24.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFnom.setText("");
				cbtipo.setSelectedItem("Tipo");
				tFuser.setText("");
				tFpass.setText("");
			}
		});
		btnCancelar.setBounds(581, 220, 117, 33);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(AltasUser.class.getResource("/Imagenes/Save24.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom=tFnom.getText();
				String tipo=cbtipo.getSelectedItem().toString();
				String usuario=tFuser.getText();
				String password=tFpass.getText();
				if(tFnom.getText().length()==0||tFpass.getText().length()==0||tipo.equalsIgnoreCase("Tipo")) {
					JOptionPane.showMessageDialog(null, "Ingrese la información del usuario");
				}
				else {
				try {
			        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
			        Statement comando=conexion.createStatement();
			        comando.executeUpdate("insert into usuarios(tipo,nombre,usuario,password)values('"+tipo+"','"+nom+"','"+usuario+"','"+password+"')");
			        conexion.close();
			        JOptionPane.showMessageDialog(null, "La información se guardo correctamente");
			      }
			      catch(Exception e) {
			    	setTitle(e.toString());
			    	JOptionPane.showMessageDialog(null, "Problemas al ingresar la información");
			      }
				}
			}
		});
		btnAgregar.setBounds(581, 362, 117, 33);
		getContentPane().add(btnAgregar);
		
	}
	public int codigo() {
		String serie="";
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
		 		Statement comando = conexion.createStatement();
			 	ResultSet resultado = comando.executeQuery("select id_usuario from usuarios");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFid_user.setText("100");
			 	}
			 	else {
			 		aumentar=Integer.parseInt(serie);
			 		aumentar=aumentar+1;
			 	}
	}
		 catch (Exception e) {
			
				JOptionPane.showMessageDialog(null,"Problemas al consultar los registros");
				 setTitle(e.toString());
		 }	
		 u=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo codigo
}
