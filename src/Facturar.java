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

public class Facturar extends JInternalFrame {
	private JTextField tFcant;
	private JTextField tFnumfact;
	private JTextField tFfecha;
	private JTextField tFsub;
	private JTextField tFiva;
	private JTextField tFtotal;
	public static JTextField tFid_clie;
	public static JTextField tFnom;
	public static JTextField tFdes;
	public static JTextField tFpu;
	public static JTextField tFid_prod;
	public static JTable tableFactura;
	
	public static String fac;
	public static int aumentar=0;
	public static float pu=0;
	public static float cant=0;
	public static float imp=0 ;
	public DefaultTableModel modelo=new DefaultTableModel();
	public JComboBox cbtipo = new JComboBox();
	public JComboBox FormaPago = new JComboBox();
	public String nfact="";
	public static String Envio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturar frame = new Facturar();
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
	public Facturar() {
		fac="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				fac=null;
				Envio=null;
			}
		});
		Envio="Si";
		setFrameIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/Bulme24.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Registrar Factura");
		setBounds(100, 100, 949, 629);
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
		
		JLabel lblFact = new JLabel("FACTURA");
		lblFact.setForeground(SystemColor.textHighlight);
		lblFact.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFact.setBounds(709, 47, 90, 23);
		getContentPane().add(lblFact);
		
		JLabel lblIdcliente = new JLabel("ID Cliente");
		lblIdcliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdcliente.setBounds(47, 210, 68, 17);
		getContentPane().add(lblIdcliente);
		
		JLabel lblnomclie = new JLabel("Nombre y Apellido");
		lblnomclie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnomclie.setBounds(287, 210, 126, 17);
		getContentPane().add(lblnomclie);
		
		JLabel lblcant = new JLabel("Cant.");
		lblcant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcant.setBounds(577, 260, 37, 17);
		getContentPane().add(lblcant);
		
		JLabel lblidprod = new JLabel("ID Prod.");
		lblidprod.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblidprod.setBounds(47, 260, 62, 17);
		getContentPane().add(lblidprod);
		
		JLabel lbldes = new JLabel("Descrip.");
		lbldes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldes.setBounds(212, 260, 60, 17);
		getContentPane().add(lbldes);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(793, 98, 40, 17);
		getContentPane().add(lblFecha);
		
		JLabel lblTNumero = new JLabel("N\u00B0 Factura");
		lblTNumero.setForeground(new Color(255, 255, 255));
		lblTNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTNumero.setBounds(657, 98, 74, 17);
		getContentPane().add(lblTNumero);
		
		JLabel lblpu = new JLabel("P.U.");
		lblpu.setForeground(new Color(0, 0, 0));
		lblpu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpu.setBounds(417, 260, 27, 17);
		getContentPane().add(lblpu);
		
		JLabel lblsub = new JLabel("Subtotal");
		lblsub.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsub.setBounds(174, 500, 59, 17);
		getContentPane().add(lblsub);
		
		JLabel lbliva = new JLabel("IVA 20%");
		lbliva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbliva.setBounds(374, 500, 66, 17);
		getContentPane().add(lbliva);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(577, 500, 35, 17);
		getContentPane().add(lblTotal);
		
		tFid_clie = new JTextField();
		tFid_clie.setBounds(157, 210, 80, 20);
		getContentPane().add(tFid_clie);
		tFid_clie.setColumns(10);
		
		tFnom = new JTextField();
		tFnom.setColumns(10);
		tFnom.setBounds(462, 210, 208, 20);
		getContentPane().add(tFnom);
		
		tFcant = new JTextField();
		tFcant.setColumns(10);
		getContentPane().add(tFcant);
		tFcant.setBounds(629, 260, 95, 20);
		
		tFid_prod = new JTextField();
		tFid_prod.setColumns(10);
		getContentPane().add(tFid_prod);
		tFid_prod.setBounds(117, 260, 80, 20);
		
		tFdes = new JTextField();
		tFdes.setBounds(280, 260, 121, 20);
		getContentPane().add(tFdes);
		tFdes.setColumns(10);
		
		tFpu = new JTextField();
		tFpu.setColumns(10);
		tFpu.setBounds(457, 260, 104, 20);
		getContentPane().add(tFpu);
		
		JComboBox FormaPago = new JComboBox();
		FormaPago.setForeground(new Color(0, 0, 0));
		FormaPago.setFont(new Font("Tahoma", Font.BOLD, 13));
		FormaPago.setBackground(new Color(204, 204, 255));
		FormaPago.setModel(new DefaultComboBoxModel(new String[] {"Forma_Pago", "Efectivo", "Tarjeta"}));
		FormaPago.setBounds(454, 546, 121, 25);
		getContentPane().add(FormaPago);
		
		JButton btnConsultar = new JButton("Consultar Clientes");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String tipoFact=cbtipo.getSelectedItem().toString();
				if(tipoFact.equalsIgnoreCase("tipo")) {
					JOptionPane.showMessageDialog(null,"Elija Tipo de Factura");
					cbtipo.isFocusOwner();
				}
				else {
					ConsultaClientes clie= new ConsultaClientes();
					Sistema.escritorio.add(clie);
					Dimension desktopSize=Sistema.escritorio.getSize();
					Dimension FrameSize=clie.getSize();
					clie.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
					clie.setVisible(true);
					JOptionPane.showMessageDialog(null, "Seleccione un registro y presione el botón enviar");
				}
			}
		});
		btnConsultar.setBounds(740, 200, 154, 33);
		getContentPane().add(btnConsultar);
		
		tFnumfact = new JTextField();
		tFnumfact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFnumfact.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFnumfact.setBackground(new Color(255, 255, 255));
		tFnumfact.setSelectionColor(new Color(255, 255, 255));
		tFnumfact.setDisabledTextColor(new Color(0, 0, 0));
		numfactura();
		tFnumfact.setText(nfact);
		tFnumfact.setEnabled(false);
		tFnumfact.setBounds(635, 126, 116, 20);
		getContentPane().add(tFnumfact);
		tFnumfact.setColumns(10);
		
		tFfecha = new JTextField();
		tFfecha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFfecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFfecha.setBackground(new Color(255, 255, 255));
		tFfecha.setSelectionColor(new Color(255, 255, 255));
		tFfecha.setDisabledTextColor(new Color(0, 0, 0));
		Calendar calendario=new GregorianCalendar();
		tFfecha.setText(""+calendario.get(Calendar.YEAR)+"-"+(calendario.get(Calendar.MONTH)+1)+"-"+calendario.get(Calendar.DAY_OF_MONTH));
		tFfecha.setEnabled(false);
		tFfecha.setBounds(756, 126, 116, 20);
		getContentPane().add(tFfecha);
		tFfecha.setColumns(10);
		
		tFsub = new JTextField();
		tFsub.setBounds(262, 500, 86, 20);
		getContentPane().add(tFsub);
		tFsub.setColumns(10);
		
		tFiva = new JTextField();
		tFiva.setColumns(10);
		tFiva.setBounds(465, 500, 86, 20);
		getContentPane().add(tFiva);
		
		tFtotal = new JTextField();
		tFtotal.setColumns(10);
		tFtotal.setBounds(638, 500, 86, 20);
		getContentPane().add(tFtotal);
		
		JLabel lblformapago = new JLabel("Forma de Pago");
		lblformapago.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblformapago.setBounds(323, 547, 104, 17);
		getContentPane().add(lblformapago);
		
		JButton btnconsulprod = new JButton("Consultar Productos");
		btnconsulprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipoFact=cbtipo.getSelectedItem().toString();
				if(tipoFact.equalsIgnoreCase("tipo")) {
					JOptionPane.showMessageDialog(null,"Elija Tipo de Factura");
					cbtipo.isFocusOwner();
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
		btnconsulprod.setBounds(740, 248, 154, 33);
		getContentPane().add(btnconsulprod);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(27, 167, 132, 28);
		getContentPane().add(panel_1);
		
		JLabel lblFacturar = new JLabel("Facturar a:");
		panel_1.add(lblFacturar);
		lblFacturar.setForeground(new Color(255, 255, 255));
		lblFacturar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 204), new Color(0, 102, 204)));
		panel_2.setBackground(UIManager.getColor("ToolBar.highlight"));
		panel_2.setBounds(27, 167, 884, 149);
		getContentPane().add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255)));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(632, 91, 121, 32);
		getContentPane().add(panel);
		
		JPanel panel_F = new JPanel();
		panel_F.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_F.setBackground(new Color(0, 102, 204));
		panel_F.setBounds(753, 91, 121, 32);
		getContentPane().add(panel_F);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/ok24.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				numfactura();
				tFnumfact.setText(nfact);
				
			}
		});
		btnNuevo.setBounds(773, 494, 117, 33);
		getContentPane().add(btnNuevo);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/Save24.png")));
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fo=FormaPago.getSelectedItem().toString();
				if(fo.equalsIgnoreCase("Forma_Pago")||tFtotal.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Elegir forma de pago o No hay productos");
					FormaPago.isFocusOwner();
				}
				else {
					int n=Integer.parseInt(tFnumfact.getText());
					String f=tFfecha.getText();
					String t=cbtipo.getSelectedItem().toString();
					String clie=tFid_clie.getText();
					float to=Float.parseFloat(tFtotal.getText());
					float subt=0,iva=0;
					//saber si los txtfield subtotal e iva esta habilitado o no
					if(tFsub.getText().length()==0){
						subt=0;
						iva=0;
					}
					else{
						subt=Float.parseFloat(tFsub.getText());
						iva=Float.parseFloat(tFiva.getText());
					}
					try {
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
						Statement comando=conexion.createStatement();
						comando.executeUpdate("insert into facturas(numfact,fecha,tipo,id_clie,subtotal,iva,total,forma_pago)values("+n+",'"+f+"','"+t+"',"+clie+","+subt+","+iva+","+to+",'"+fo+"')");
						//para pasar a la tabla detallefactura
						if(tableFactura.getRowCount()>0) {
						
							for(int i=0;i<tableFactura.getRowCount();i++) {
								try {
									//tabla detallefactura
									comando.executeUpdate("insert into detallefactura(numfact,id_prod,cantidad,importe) values("+n+","+tableFactura.getValueAt(i, 0)+","+tableFactura.getValueAt(i, 3)+","+tableFactura.getValueAt(i, 4)+")");
									//tabla productos
									comando.executeUpdate("update productos set cantidad=(cantidad-"+tableFactura.getValueAt(i, 3)+") where id_prod="+tableFactura.getValueAt(i, 0));
								}
								catch(Exception e) {
									setTitle(e.toString());
									JOptionPane.showMessageDialog(null, "NO hay registro del cliente por incorporar");
								}
							}//fin del for
						
						}// fin del if de si hay filas en la tabla
						else {
							JOptionPane.showMessageDialog(null, "NO hay registros de los productos por incorporar");
						}
						conexion.close();
						JOptionPane.showMessageDialog(null, "La información ingreso correctamente");
						limpiar();
					}//fin del 1er try tabla factura
					catch(Exception e) {
						setTitle(e.toString());
						JOptionPane.showMessageDialog(null, "Problemas al ingresar la información");
					}
				}//find el 1er else
			}
		});
		btnguardar.setBounds(773, 538, 117, 33);
		getContentPane().add(btnguardar);
		
		JButton btnAgregar = new JButton("Agregar Producto");
		btnAgregar.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/Agregar.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                agregar();
				subtotal();
			}
		});
		btnAgregar.setBounds(740, 361, 175, 33);
		getContentPane().add(btnAgregar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConsultaFactura.class.getResource("/Imagenes/Bulme48.png")));
		label_1.setBounds(167, 21, 53, 45);
		getContentPane().add(label_1);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 350, 695, 128);
		getContentPane().add(scrollPane);
		
		tableFactura = new JTable();
		modelo.addColumn("Código");
		modelo.addColumn("Descripción");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Importe");
		tableFactura.setModel(modelo);
	   
		scrollPane.setViewportView(tableFactura);
		
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                if(tableFactura.getSelectedRow()==-1) {
					tFsub.setText("");
					tFiva.setText("");
					tFtotal.setText("");
				}
				else {
					modelo.removeRow(tableFactura.getSelectedRow());
					subtotal();	
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Facturar.class.getResource("/Imagenes/cancelar24.png")));
		btnEliminar.setBounds(740, 421, 175, 33);
		getContentPane().add(btnEliminar);
		
		cbtipo.setForeground(new Color(0, 0, 0));
		cbtipo.setBackground(new Color(204, 204, 255));
		cbtipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoFact=cbtipo.getSelectedItem().toString();
				if(tipoFact.equalsIgnoreCase("A")) {
					tFsub.setEnabled(true);
					tFiva.setEnabled(true);	
				}
				else {
					tFsub.setEnabled(false);
					tFiva.setEnabled(false);
				}
			}
		});
		cbtipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbtipo.setModel(new DefaultComboBoxModel(new String[] {"Tipo", "A", "B"}));
		cbtipo.setBounds(415, 69, 109, 25);
		getContentPane().add(cbtipo);
		
	}
	public void agregar(){
		cant=Float.parseFloat(tFcant.getText());
		int stock=Integer.parseInt(ConsultaProd.cantidad);
		if(cant<stock) {
			Object datos[]=new Object[5];
			datos[0]=tFid_prod.getText();
			datos[1]=tFdes.getText();
			datos[2]=tFpu.getText();
			datos[3]=tFcant.getText();
			pu=Float.parseFloat(tFpu.getText());
			imp=pu*cant;
			datos[4]=imp;
			modelo.addRow(datos);
			tableFactura.getColumnModel().getColumn(0).setPreferredWidth(45);
			tableFactura.getColumnModel().getColumn(2).setPreferredWidth(90);
			tableFactura.getColumnModel().getColumn(3).setPreferredWidth(53);
			tableFactura.getColumnModel().getColumn(4).setPreferredWidth(52);
			tFid_prod.setText("");
			tFdes.setText("");
			tFpu.setText("");
			tFcant.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null,"Stock Insufeciente "+stock);
		}
	}//fin del metodo Agregar
	
	public void subtotal() {
		float suma=0;
		float fila;
		for(int i=0;i<tableFactura.getRowCount();i++) {
			fila=Float.parseFloat(tableFactura.getValueAt(i, 4).toString());
			suma=suma+fila;
			int tipoFact=cbtipo.getSelectedIndex();
			if(tipoFact==2) {
					tFtotal.setText(String.valueOf(suma));
				}
			else {
				tFsub.setText(String.valueOf(suma));
				tFiva.setText(String.valueOf(suma*0.21));
				tFtotal.setText(String.valueOf(suma*1.21));
			}
			
		}
	}//fin del metodo subtotal
	
	public int numfactura() {
		String serie="";
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
		 		Statement comando = conexion.createStatement();
			 	ResultSet resultado = comando.executeQuery("select numfact from facturas");
			 	while(resultado.next()) {
			 		serie=resultado.getString(1);
			 	}
			 	if(serie==null) {
			 		tFnumfact.setText("1000");
			 	}
			 	else {
			 		aumentar=Integer.parseInt(serie);
			 		aumentar=aumentar+1;
			 	}
	}
		 catch (Exception e) {
			
				JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla Factura");
				 setTitle(e.toString());
		 }	
		 nfact=String.valueOf(aumentar);
		 return aumentar;
	}//find el metodo numnota
	
	//Metodo limpiar
	public void limpiar() {
		cbtipo.setSelectedItem("Tipo");
		FormaPago.setSelectedItem("Forma_Pago");
		modelo.getDataVector().removeAllElements();
		tableFactura.updateUI();
		tFid_prod.setText("");
		tFdes.setText("");
		tFpu.setText("");
		tFid_clie.setText("");
		tFnom.setText("");
		tFsub.setText("");
		tFiva.setText("");
		tFtotal.setText("");
		tFsub.setEnabled(true);
		tFiva.setEnabled(true);
	}
}//fin de la clase JInternalFrame Facturar
