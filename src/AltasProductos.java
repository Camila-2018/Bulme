import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.SystemColor;

public class AltasProductos extends JInternalFrame {
	public JTextField tFid_prod;
	public JTextField tFdes;
	public JTextField tFcant;
	public static JTextField tFid_prov;
	private JTextField tFpu;
	
	public static String pro;
	public static int aumentar=0;
	public String pr="";
	public static String Envio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasProductos frame = new AltasProductos();
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
	public AltasProductos() {
		pro="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				pro=null;
				Envio=null;
			}
		});
		Envio="Si";
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setFrameIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Alta Productos");
		setBounds(100, 100, 800, 556);
		getContentPane().setLayout(null);
		
		JLabel lblprod = new JLabel("");
		lblprod.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/productos.png")));
		lblprod.setBounds(100, 89, 80, 80);
		getContentPane().add(lblprod);
		
		JLabel lblAltasDeProductos = new JLabel("Altas de Productos");
		lblAltasDeProductos.setForeground(new Color(255, 255, 255));
		lblAltasDeProductos.setFont(new Font("Verdana", Font.BOLD, 18));
		lblAltasDeProductos.setBounds(80, 35, 190, 23);
		getContentPane().add(lblAltasDeProductos);
		
		JLabel lbldatosg = new JLabel("Datos Generales");
		lbldatosg.setForeground(new Color(255, 255, 255));
		lbldatosg.setFont(new Font("Verdana", Font.BOLD, 16));
		lbldatosg.setBounds(243, 118, 145, 21);
		getContentPane().add(lbldatosg);
		
		JLabel lblCdigosProd = new JLabel("C\u00D3DIGO");
		lblCdigosProd.setForeground(new Color(0, 0, 153));
		lblCdigosProd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCdigosProd.setBounds(117, 199, 59, 17);
		getContentPane().add(lblCdigosProd);
		
		JLabel lblNombreProd = new JLabel("PRODUCTO");
		lblNombreProd.setForeground(new Color(0, 0, 153));
		lblNombreProd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombreProd.setBounds(117, 252, 77, 16);
		getContentPane().add(lblNombreProd);
		
		JLabel lblMaterialProd = new JLabel("MATERIAL");
		lblMaterialProd.setForeground(new Color(0, 0, 153));
		lblMaterialProd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMaterialProd.setBounds(117, 306, 68, 16);
		getContentPane().add(lblMaterialProd);
		
		JLabel lblTelefonoProd = new JLabel("CANTIDAD");
		lblTelefonoProd.setForeground(new Color(0, 0, 153));
		lblTelefonoProd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefonoProd.setBounds(117, 358, 76, 17);
		getContentPane().add(lblTelefonoProd);
		
		JLabel lblPrecioProd = new JLabel("PRECIO UNIT.");
		lblPrecioProd.setForeground(new Color(0, 0, 153));
		lblPrecioProd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPrecioProd.setBounds(117, 409, 94, 16);
		getContentPane().add(lblPrecioProd);
		
		JLabel lblCdigoProv = new JLabel("C\u00D3DIGO PROV");
		lblCdigoProv.setForeground(new Color(0, 0, 153));
		lblCdigoProv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCdigoProv.setBounds(117, 455, 99, 16);
		getContentPane().add(lblCdigoProv);
		
		tFid_prod = new JTextField();
		tFid_prod.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_prod.setDisabledTextColor(new Color(0, 0, 0));
		tFid_prod.setSelectionColor(new Color(255, 255, 255));
		tFid_prod.setFont(new Font("Tahoma", Font.BOLD, 12));
		tFid_prod.setBackground(new Color(255, 255, 255));
		codigo();
		tFid_prod.setEnabled(false);
		tFid_prod.setText(pr);
		tFid_prod.setBounds(235, 198, 112, 20);
		getContentPane().add(tFid_prod);
		tFid_prod.setColumns(10);
		
		tFdes = new JTextField();
		tFdes.setBounds(235, 251, 145, 20);
		getContentPane().add(tFdes);
		tFdes.setColumns(10);
		
		JComboBox cbmat = new JComboBox();
		cbmat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbmat.setBackground(new Color(255, 255, 255));
		cbmat.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "Algarrobo", "Cedro", "Pino", "Roble"}));
		cbmat.setBounds(235, 305, 145, 23);
		getContentPane().add(cbmat);
		
		tFcant = new JTextField();
		tFcant.setBounds(235, 357, 123, 20);
		getContentPane().add(tFcant);
		tFcant.setColumns(10);
		
		tFpu = new JTextField();
		tFpu.setColumns(10);
		getContentPane().add(tFpu);
		tFpu.setBounds(235, 406, 112, 20);
			
		tFid_prov = new JTextField();
		tFid_prov.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_prov.setDisabledTextColor(new Color(0, 0, 0));
		tFid_prov.setFont(new Font("Tahoma", Font.BOLD, 12));
		tFid_prov.setForeground(new Color(255, 255, 255));
		tFid_prov.setBackground(new Color(255, 255, 255));
		tFid_prov.setEnabled(false);
		//tFid_prov.setText(pr);
		tFid_prov.setColumns(10);
		getContentPane().add(tFid_prov);
		tFid_prov.setBounds(235, 455, 123, 20);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFid_prod.setText("");
				tFdes.setText("");
				cbmat.setSelectedItem("Tipo");
				tFcant.setText("");
				tFpu.setText("");
				tFid_prov.setText("");
				codigo();
				tFid_prod.setText(pr);
			}
		});
		btnNuevo.setBounds(588, 297, 117, 33);
		getContentPane().add(btnNuevo);
		
		JPanel paneldatos = new JPanel();
		paneldatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
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
		panel_cuad.setBounds(80, 136, 438, 369);
		getContentPane().add(panel_cuad);
		panel_cuad.setLayout(null);
		
		JButton btnConsultar = new JButton("<html><center>Consulta Proveedores<html>");
		btnConsultar.setBounds(297, 310, 123, 37);
		panel_cuad.add(btnConsultar);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaProveedores con=new ConsultaProveedores();
				Sistema.escritorio.add(con);
				Dimension desktopSize=Sistema.escritorio.getSize();
				Dimension FrameSize=con.getSize();
				con.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
				con.toFront();
				con.setVisible(true);
				JOptionPane.showMessageDialog(null, "Seleccione un registro y presione el botón enviar");
			}
		});
		btnConsultar.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/consulta24.png")));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/cancelar24.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFdes.setText("");
				cbmat.setSelectedItem("Tipo");
				tFcant.setText("");
				tFpu.setText("");
			}
		});
		btnCancelar.setBounds(588, 227, 117, 33);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/Save24.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String des=tFdes.getText();
				String mat=cbmat.getSelectedItem().toString();
			    if(tFdes.getText().length()==0||tFpu.getText().length()==0||tFid_prov.getText().length()==0||mat.equalsIgnoreCase("Tipo")) {
		    		JOptionPane.showMessageDialog(null, "Ingrese la información del producto");
		      }
		      else {
				      int cant=Integer.parseInt(tFcant.getText());
				      float pu=Float.parseFloat(tFpu.getText());
				      int idprov=Integer.parseInt(tFid_prov.getText());
				  
				      try {
				        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
				        Statement comando=conexion.createStatement();
				        comando.executeUpdate("insert into productos(descripcion,material,cantidad,preciou,id_prov)values('"+des+"','"+mat+"',"+cant+","+pu+","+idprov+")");
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
		btnAgregar.setBounds(588, 369, 117, 33);
		getContentPane().add(btnAgregar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(681, 27, 60, 60);
		getContentPane().add(label_1);

	}
	public int codigo() {
		String serie="";
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
		 		Statement comando = conexion.createStatement();
			 	ResultSet resultado = comando.executeQuery("select id_prod from productos");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFid_prod.setText("100");
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
		 pr=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo codigo
}
