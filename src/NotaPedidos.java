import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;

public class NotaPedidos extends JInternalFrame {
	private JTextField tFnumnota;
	private JTextField tFfecha;
	public static JTextField tFcant;
	public static JTextField tFid_prov;
	public static JTextField tFnomp;
	public static JTextField tFdes;
	public static JTextField tFtelp;
	public static JTextField tFid_prod;
	public static JTable tableNota;
	public static int auxcant=0;
	
	public static String nota;
	public static int aumentar=0;
	public static float cant=0;
	public DefaultTableModel modelo=new DefaultTableModel();
	public String npedi="";
	public static String Envio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotaPedidos frame = new NotaPedidos();
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
	public NotaPedidos() {
		nota="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				nota=null;
				Envio=null;
			}
		});
		Envio="Si";
		setFrameIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/Bulme24.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Nota Pedidos");
		setBounds(100, 100, 1090, 577);
		getContentPane().setLayout(null);
		
		JLabel lblBul = new JLabel("BULME");
		lblBul.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBul.setBounds(167, 77, 49, 17);
		getContentPane().add(lblBul);
		
		JLabel lblDirecB = new JLabel("Jujuy 337 - Tel. (0381) 4314938 ");
		lblDirecB.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDirecB.setBounds(90, 105, 210, 16);
		getContentPane().add(lblDirecB);
		
		JLabel lblLoc = new JLabel("San Miguel de Tucum\u00E1n, Tucum\u00E1n T4000");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoc.setBounds(65, 130, 258, 16);
		getContentPane().add(lblLoc);
		
		JLabel lblFact = new JLabel("NOTAS DE PEDIDOS");
		lblFact.setForeground(SystemColor.textHighlight);
		lblFact.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFact.setBounds(454, 72, 193, 23);
		getContentPane().add(lblFact);
		
		JLabel lblIdcliente = new JLabel("ID Proveedor");
		lblIdcliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdcliente.setBounds(47, 210, 93, 17);
		getContentPane().add(lblIdcliente);
		
		JLabel lblidprod = new JLabel("ID Producto");
		lblidprod.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblidprod.setBounds(47, 260, 85, 17);
		getContentPane().add(lblidprod);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(920, 98, 40, 17);
		getContentPane().add(lblFecha);
		
		JLabel lblTNumero = new JLabel("N\u00B0 Pedidos");
		lblTNumero.setForeground(new Color(255, 255, 255));
		lblTNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTNumero.setBounds(782, 98, 76, 17);
		getContentPane().add(lblTNumero);
		
		tFid_prov = new JTextField();
		tFid_prov.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_prov.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFid_prov.setBackground(new Color(255, 255, 255));
		tFid_prov.setSelectionColor(new Color(255, 255, 255));
		tFid_prov.setDisabledTextColor(new Color(0, 0, 0));
		tFid_prov.setEnabled(false);
		tFid_prov.setBounds(157, 210, 80, 20);
		getContentPane().add(tFid_prov);
		tFid_prov.setColumns(10);
		
		tFnumnota = new JTextField();
		tFnumnota.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFnumnota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFnumnota.setBackground(new Color(255, 255, 255));
		tFnumnota.setSelectionColor(new Color(255, 255, 255));
		tFnumnota.setDisabledTextColor(new Color(0, 0, 0));
		numnota();
		tFnumnota.setText(npedi);
		tFnumnota.setEnabled(false);
		tFnumnota.setBounds(762, 126, 116, 20);
		getContentPane().add(tFnumnota);
		tFnumnota.setColumns(10);
		
		tFfecha = new JTextField();
		tFfecha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFfecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFfecha.setBackground(new Color(255, 255, 255));
		tFfecha.setSelectionColor(new Color(255, 255, 255));
		tFfecha.setDisabledTextColor(new Color(0, 0, 0));
		Calendar calendario=new GregorianCalendar();
		tFfecha.setText(""+calendario.get(Calendar.YEAR)+"-"+(calendario.get(Calendar.MONTH)+1)+"-"+calendario.get(Calendar.DAY_OF_MONTH));
		tFfecha.setEnabled(false);
		tFfecha.setBounds(883, 126, 116, 20);
		getContentPane().add(tFfecha);
		tFfecha.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(27, 167, 132, 28);
		getContentPane().add(panel_1);
		
		JLabel lblComprar = new JLabel("Comprar a:");
		panel_1.add(lblComprar);
		lblComprar.setForeground(new Color(255, 255, 255));
		lblComprar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 204), new Color(0, 102, 204)));
		panel_2.setBackground(UIManager.getColor("ToolBar.highlight"));
		panel_2.setBounds(27, 167, 1022, 149);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblnomclie = new JLabel("Nombre y Apellido");
		lblnomclie.setBounds(241, 43, 126, 17);
		panel_2.add(lblnomclie);
		lblnomclie.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tFnomp = new JTextField();
		tFnomp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFnomp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFnomp.setBackground(new Color(255, 255, 255));
		tFnomp.setSelectionColor(new Color(255, 255, 255));
		tFnomp.setDisabledTextColor(new Color(0, 0, 0));
		tFnomp.setEnabled(false);
		tFnomp.setBounds(401, 43, 174, 20);
		panel_2.add(tFnomp);
		tFnomp.setColumns(10);
		
		JButton btnConsultar_1 = new JButton("Consultar Proveedores");
		btnConsultar_1.setBounds(828, 33, 174, 33);
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
					ConsultaProveedores cpv= new ConsultaProveedores();
					Sistema.escritorio.add(cpv);
					Dimension desktopSize=Sistema.escritorio.getSize();
					Dimension FrameSize=cpv.getSize();
					cpv.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
					cpv.setVisible(true);
					JOptionPane.showMessageDialog(null, "Seleccione un registro y presione el botón enviar");
				
			}
		});
		panel_2.add(btnConsultar_1);
		
		JButton btnconsulprod = new JButton("Consultar Productos");
		btnconsulprod.setBounds(828, 81, 174, 33);
		btnconsulprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tFid_prov.getText().length()==0||tFnomp.getText().length()==0||tFtelp.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Ingrese el registro de un proveedor");
				}
				else {
					ConsultaProd abrir=new ConsultaProd();
					Sistema.escritorio.add(abrir);
					Dimension desktopSize=Sistema.escritorio.getSize();
					Dimension FrameSize=abrir.getSize();
					abrir.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
					abrir.setVisible(true);
					JOptionPane.showMessageDialog(null, "Seleccione un registro y presione el botón enviar");
				}
			}
		});
		panel_2.add(btnconsulprod);
		
		JLabel lbltel = new JLabel("Tel\u00E9fono");
		lbltel.setBounds(605, 43, 60, 17);
		panel_2.add(lbltel);
		lbltel.setForeground(new Color(0, 0, 0));
		lbltel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tFtelp = new JTextField();
		tFtelp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFtelp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFtelp.setBackground(new Color(255, 255, 255));
		tFtelp.setSelectionColor(new Color(255, 255, 255));
		tFtelp.setDisabledTextColor(new Color(0, 0, 0));
		tFtelp.setEnabled(false);
		tFtelp.setBounds(691, 43, 113, 20);
		panel_2.add(tFtelp);
		tFtelp.setColumns(10);
		
		JLabel lbldes_1 = new JLabel("Descrip.");
		lbldes_1.setBounds(241, 93, 60, 17);
		panel_2.add(lbldes_1);
		lbldes_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tFdes = new JTextField();
		tFdes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFdes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFdes.setBackground(new Color(255, 255, 255));
		tFdes.setSelectionColor(new Color(255, 255, 255));
		tFdes.setDisabledTextColor(new Color(0, 0, 0));
		tFdes.setEnabled(false);
		tFdes.setBounds(327, 93, 121, 20);
		panel_2.add(tFdes);
		tFdes.setColumns(10);
		
		JLabel lblcant = new JLabel("Cant.");
		lblcant.setBounds(491, 94, 37, 17);
		panel_2.add(lblcant);
		lblcant.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tFcant = new JTextField();
		tFcant.setBounds(570, 94, 95, 20);
		panel_2.add(tFcant);
		tFcant.setColumns(10);
		
		tFid_prod = new JTextField();
		tFid_prod.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_prod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFid_prod.setBackground(new Color(255, 255, 255));
		tFid_prod.setSelectionColor(new Color(255, 255, 255));
		tFid_prod.setDisabledTextColor(new Color(0, 0, 0));
		tFid_prod.setEnabled(false);
		tFid_prod.setBounds(129, 93, 80, 20);
		panel_2.add(tFid_prod);
		tFid_prod.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255)));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(759, 91, 121, 32);
		getContentPane().add(panel);
		
		JPanel panel_F = new JPanel();
		panel_F.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_F.setBackground(new Color(0, 102, 204));
		panel_F.setBounds(880, 91, 121, 32);
		getContentPane().add(panel_F);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				numnota();
					
			}
		});
		btnNuevo.setBounds(491, 495, 117, 33);
		getContentPane().add(btnNuevo);
		
		
		
		JButton btnAgregar = new JButton("Agregar Producto");
		btnAgregar.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/Agregar.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tFcant.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
				}
				else {
                    agregar();
				}
			}
		});
		btnAgregar.setBounds(859, 366, 175, 33);
		getContentPane().add(btnAgregar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConsultaFactura.class.getResource("/Imagenes/Bulme48.png")));
		label_1.setBounds(167, 21, 53, 45);
		getContentPane().add(label_1);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 350, 770, 128);
		getContentPane().add(scrollPane);
		
		tableNota = new JTable();
		modelo.addColumn("Código");
		modelo.addColumn("Descripción");
		modelo.addColumn("Cantidad");
		tableNota.setModel(modelo);
	   
		scrollPane.setViewportView(tableNota);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.setIcon(new ImageIcon(NotaPedidos.class.getResource("/Imagenes/Save24.png")));
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n=Integer.parseInt(tFnumnota.getText());
				String f=tFfecha.getText();
				String prov=tFid_prov.getText();
				
				if( tableNota.getRowCount()>0) {
					
					try {
						//para pasar a la tabla pedidos
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
						Statement comando=conexion.createStatement();
						comando.executeUpdate("insert into pedidos(num_pedidos,fecha,id_prov)values("+n+",'"+f+"',"+prov+")");
						
					}
					catch(Exception e) {
						setTitle(e.toString());
						JOptionPane.showMessageDialog(null, "Problemas al ingresar la información a la tabla Pedidos");
					}
					for(int i=0;i<tableNota.getRowCount();i++) {
				
						try {
						
						//tabla detallepedidos
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
						Statement comando=conexion.createStatement();
						comando.executeUpdate("insert into detallepedidos(num_pedidos,id_prod,cantidad) values("+n+","+tableNota.getValueAt(i, 0)+","+tableNota.getValueAt(i, 2)+")");
						conexion.close();
						}//fin del try
						catch(Exception e) {
									setTitle(e.toString());
									JOptionPane.showMessageDialog(null, "Problemas al ingresar la información");
						}
								
					}//fin del for
					JOptionPane.showMessageDialog(null, "La información ingreso correctamente");
					limpiar();//llama al metodo limpiar
						}// fin del if de si hay filas en la tabla
						else {
							JOptionPane.showMessageDialog(null, "NO hay Registros por incorporar");
						}
						
				}//find el 1er else		
		});
		btnguardar.setBounds(693, 495, 117, 33);
		getContentPane().add(btnguardar);
		
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                if(tableNota.getSelectedRow()==-1) {
					tFid_prod.setText("");
					tFdes.setText("");
					tFcant.setText("");
				}
				else {
					modelo.removeRow(tableNota.getSelectedRow());
					tableNota.updateUI();
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/cancelar24.png")));
		btnEliminar.setBounds(859, 426, 175, 33);
		getContentPane().add(btnEliminar);
		
	}
	public void agregar(){
		String des=tFdes.getText();
		int cant=Integer.parseInt(tFcant.getText());
		int idprod=Integer.parseInt(tFid_prod.getText());
		
			Object datos[]=new Object[3];
			
			datos[0]=tFid_prod.getText();
			datos[1]=tFdes.getText();
			datos[2]=tFcant.getText();
			
			modelo.addRow(datos);
			
			tableNota.getColumnModel().getColumn(0);
			tableNota.getColumnModel().getColumn(1);
			tableNota.getColumnModel().getColumn(2);
			
			tFid_prod.setText("");
			tFdes.setText("");
			tFcant.setText("");
			
	}//fin del metodo Agregar
	
	public int numnota() {
		String serie="";
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
		 		Statement comando = conexion.createStatement();
			 	ResultSet resultado = comando.executeQuery("select num_pedidos from pedidos");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFnumnota.setText("1000");
			 	}
			 	else {
			 		aumentar=Integer.parseInt(serie);
			 		aumentar=aumentar+1;
			 	}
	}
		 catch (Exception e) {
			
				JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla Pedidos");
				 setTitle(e.toString());
		 }	
		 npedi=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo numfactura
	
	//Metodo limpiar
	public void limpiar() {
		modelo.getDataVector().removeAllElements();
		tableNota.updateUI();
		tFid_prod.setText("");
		tFdes.setText("");
		tFcant.setText("");
		tFid_prov.setText("");
		tFnomp.setText("");
		tFtelp.setText("");
		tFnumnota.setText(npedi);
	}
}
