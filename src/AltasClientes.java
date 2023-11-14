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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.ComponentOrientation;

public class AltasClientes extends JInternalFrame {
	private JTextField tFnom;
	private JTextField tFdire;
	private JTextField tFcorreo;
	private JTextField tFtel;
	public JTextField tFid_clie;
	
	public static String clie;
	public static int aumentar=0;
	public String cl="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasClientes frame = new AltasClientes();
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
	public AltasClientes() {
		clie="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				clie=null;
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Altas de Clientes");
		setBounds(100, 100, 800, 508);
		getContentPane().setLayout(null);
		
		JLabel lblusuario = new JLabel("");
		lblusuario.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/Login4.png")));
		lblusuario.setBounds(100, 89, 80, 80);
		getContentPane().add(lblusuario);
		
		JLabel lblAltasDeClientes = new JLabel("Altas de Clientes");
		lblAltasDeClientes.setBounds(80, 35, 169, 23);
		getContentPane().add(lblAltasDeClientes);
		lblAltasDeClientes.setForeground(new Color(255, 255, 255));
		lblAltasDeClientes.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JLabel lbldatosg = new JLabel("Datos Generales");
		lbldatosg.setForeground(new Color(255, 255, 255));
		lbldatosg.setFont(new Font("Verdana", Font.BOLD, 16));
		lbldatosg.setBounds(243, 118, 145, 21);
		getContentPane().add(lbldatosg);
		
		JLabel lblid_clie = new JLabel("C\u00D3DIGO");
		lblid_clie.setForeground(new Color(0, 0, 153));
		lblid_clie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblid_clie.setBounds(117, 199, 59, 17);
		getContentPane().add(lblid_clie);
		
		JLabel lblNombreClie = new JLabel("NOMBRE");
		lblNombreClie.setForeground(new Color(0, 0, 153));
		lblNombreClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombreClie.setBounds(117, 252, 63, 17);
		getContentPane().add(lblNombreClie);
		
		JLabel lblDireccionClie = new JLabel("DIRECCI\u00D3N");
		lblDireccionClie.setForeground(new Color(0, 0, 153));
		lblDireccionClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDireccionClie.setBounds(117, 306, 85, 17);
		getContentPane().add(lblDireccionClie);
		
		JLabel lblTelefonoClie = new JLabel("TEL\u00C9FONO");
		lblTelefonoClie.setForeground(new Color(0, 0, 153));
		lblTelefonoClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefonoClie.setBounds(117, 358, 76, 17);
		getContentPane().add(lblTelefonoClie);
		
		JLabel lblCorreoClie = new JLabel("CORREO ELECT.");
		lblCorreoClie.setForeground(new Color(0, 0, 153));
		lblCorreoClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCorreoClie.setBounds(117, 409, 106, 16);
		getContentPane().add(lblCorreoClie);
		
		tFid_clie = new JTextField();
		tFid_clie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_clie.setBackground(new Color(255, 255, 255));
		tFid_clie.setFont(new Font("Tahoma", Font.BOLD, 12));
		tFid_clie.setSelectionColor(new Color(255, 255, 255));
		tFid_clie.setDisabledTextColor(new Color(0, 0, 0));
		codigo();
		tFid_clie.setEnabled(false);
		tFid_clie.setText(cl);
		tFid_clie.setBounds(243, 198, 112, 20);
		getContentPane().add(tFid_clie);
		tFid_clie.setColumns(10);
		
		tFnom = new JTextField();
		tFnom.setBounds(243, 251, 210, 20);
		getContentPane().add(tFnom);
		tFnom.setColumns(10);
		
		tFtel = new JTextField();
		tFtel.setColumns(10);
		getContentPane().add(tFtel);
		tFtel.setBounds(243, 357, 143, 20);
		
		tFcorreo = new JTextField();
		tFcorreo.setColumns(10);
		tFcorreo.setBounds(243, 406, 244, 20);
		getContentPane().add(tFcorreo);
		
		tFdire = new JTextField();
		tFdire.setColumns(10);
		tFdire.setBounds(243, 305, 244, 20);
		getContentPane().add(tFdire);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFid_clie.setText("");
				tFnom.setText("");
				tFdire.setText("");
				tFtel.setText("");
				tFcorreo.setText("");
				codigo();
				tFid_clie.setText(cl);
			}
		});
		btnNuevo.setBounds(581, 290, 117, 33);
		getContentPane().add(btnNuevo);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
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
		panel_cuad.setBounds(80, 136, 438, 318);
		getContentPane().add(panel_cuad);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/cancelar24.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFnom.setText("");
				tFdire.setText("");
				tFtel.setText("");
				tFcorreo.setText("");
			}
		});
		btnCancelar.setBounds(581, 220, 117, 33);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/Save24.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom=tFnom.getText();
				String dire=tFdire.getText();
				String correo=tFcorreo.getText();
				String tel=tFtel.getText();
				if(tFnom.getText().length()==0||tFtel.getText().length()==0||tFcorreo.getText().length()==0||tFcorreo.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Ingrese la información del cliente");
				}
				else {
				try {
			        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
			        Statement comando=conexion.createStatement();
			        comando.executeUpdate("insert into clientes(nombre,direccion,telefono,correo)values('"+nom+"','"+dire+"','"+tel+"','"+correo+"')");
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
			 	ResultSet resultado = comando.executeQuery("select id_clie from clientes");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFid_clie.setText("100");
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
		 cl=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo codigo
}
