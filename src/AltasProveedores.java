import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
import javax.swing.border.EtchedBorder;

public class AltasProveedores extends JInternalFrame {
	public JTextField tFid_prov;
	public JTextField tFnomp;
	public JTextField tFtelp;
	private JTextField tFdirep;
	private JTextField tFcorreop;
	
	public static String prov;
	public static int aumentar=0;
	public String prv="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasProveedores frame = new AltasProveedores();
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
	public AltasProveedores() {
		prov="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				prov=null;
			}
		});
		setIconifiable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Altas de Proveedores");
		setBounds(100, 100, 800, 508);
		getContentPane().setLayout(null);
		
		JLabel lblprov = new JLabel("");
		lblprov.setIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/proveedor.png")));
		lblprov.setBounds(100, 89, 80, 80);
		getContentPane().add(lblprov);
		
		JLabel lblAltasProveedores = new JLabel("Altas de Proveedores");
		lblAltasProveedores.setForeground(new Color(255, 255, 255));
		lblAltasProveedores.setFont(new Font("Verdana", Font.BOLD, 18));
		lblAltasProveedores.setBounds(80, 35, 215, 23);
		getContentPane().add(lblAltasProveedores);
		
		JLabel lbldatosg = new JLabel("Datos Generales");
		lbldatosg.setForeground(new Color(255, 255, 255));
		lbldatosg.setFont(new Font("Verdana", Font.BOLD, 16));
		lbldatosg.setBounds(243, 118, 145, 21);
		getContentPane().add(lbldatosg);
		
		JLabel lblCdigosProv = new JLabel("C\u00D3DIGO");
		lblCdigosProv.setForeground(new Color(0, 0, 153));
		lblCdigosProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCdigosProv.setBounds(117, 199, 59, 17);
		getContentPane().add(lblCdigosProv);
		
		JLabel lblNombreProv = new JLabel("NOMBRE");
		lblNombreProv.setForeground(new Color(0, 0, 153));
		lblNombreProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombreProv.setBounds(117, 252, 63, 17);
		getContentPane().add(lblNombreProv);
		
		JLabel lblDireccionProv = new JLabel("DIRECCI\u00D3N");
		lblDireccionProv.setForeground(new Color(0, 0, 153));
		lblDireccionProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDireccionProv.setBounds(117, 306, 85, 17);
		getContentPane().add(lblDireccionProv);
		
		JLabel lblTelefonoProv = new JLabel("TEL\u00C9FONO");
		lblTelefonoProv.setForeground(new Color(0, 0, 153));
		lblTelefonoProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefonoProv.setBounds(117, 358, 76, 17);
		getContentPane().add(lblTelefonoProv);
		
		JLabel lblCorreoProv = new JLabel("CORREO ELECT.");
		lblCorreoProv.setForeground(new Color(0, 0, 153));
		lblCorreoProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCorreoProv.setBounds(117, 409, 106, 16);
		getContentPane().add(lblCorreoProv);
		
		tFid_prov = new JTextField();
		tFid_prov.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_prov.setSelectionColor(new Color(255, 255, 255));
		tFid_prov.setDisabledTextColor(new Color(0, 0, 0));
		tFid_prov.setBackground(new Color(255, 255, 255));
		tFid_prov.setFont(new Font("Tahoma", Font.BOLD, 12));
		codigo();
		tFid_prov.setEnabled(false);
		tFid_prov.setText(prv);
		tFid_prov.setBounds(243, 198, 112, 20);
		getContentPane().add(tFid_prov);
		tFid_prov.setColumns(10);
		
		tFnomp = new JTextField();
		tFnomp.setBounds(243, 251, 210, 20);
		getContentPane().add(tFnomp);
		tFnomp.setColumns(10);
		
		tFdirep = new JTextField();
		tFdirep.setBounds(243, 305, 244, 20);
		getContentPane().add(tFdirep);
		tFdirep.setColumns(10);
		
		tFtelp = new JTextField();
		tFtelp.setColumns(10);
		getContentPane().add(tFtelp);
		tFtelp.setBounds(243, 357, 160, 20);
			
		tFcorreop = new JTextField();
		tFcorreop.setColumns(10);
		getContentPane().add(tFcorreop);
		tFcorreop.setBounds(243, 406, 244, 20);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				tFid_prov.setText("");
				tFnomp.setText("");
				tFdirep.setText("");
				tFtelp.setText("");
				tFcorreop.setText("");
				codigo();
				tFid_prov.setText(prv);
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
		btnCancelar.setIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/cancelar24.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFnomp.setText("");
				tFdirep.setText("");
				tFtelp.setText("");
				tFcorreop.setText("");
			}
		});
		btnCancelar.setBounds(581, 220, 117, 33);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/Save24.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=tFnomp.getText();
				String dire=tFdirep.getText();
				String tel=tFtelp.getText();
				String correo=tFcorreop.getText();
			    if(tFnomp.getText().length()==0||tFdirep.getText().length()==0||tFtelp.getText().length()==0||tFcorreop.getText().length()==0) {
		    		JOptionPane.showMessageDialog(null, "Ingrese la información del proveedor");
		      }
		      else {
				try {
			        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
			        Statement comando=conexion.createStatement();
			        comando.executeUpdate("insert into proveedores(nombre,direccion,telefono,correo)values('"+nom+"','"+dire+"','"+tel+"','"+correo+"')");
			        conexion.close();
			        JOptionPane.showMessageDialog(null, "La información se guardo correctamente");
			      }
			      catch(Exception ex) {
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
			 	ResultSet resultado = comando.executeQuery("select id_prov from proveedores");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFid_prov.setText("100");
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
		 prv=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo codigo
}
