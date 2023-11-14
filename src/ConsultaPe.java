
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaPe extends JInternalFrame {
	private JTable tablapedidos;
	private JTable tabladetallep;
	private JTextField tFid_pedido;
	private TableRowSorter trsfiltro;
	DefaultTableModel model;
	DefaultTableModel mod;
	
	public static String cpe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPe frame = new ConsultaPe();
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
	public ConsultaPe() {
		cpe="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				cpe=null;
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(ConsultaPe.class.getResource("/Imagenes/Bulme24.png")));
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Pedidos");
		setBounds(100, 100, 1137, 521);
		getContentPane().setLayout(null);
		
		JLabel lblconfact = new JLabel("Consulta Pedidos");
		lblconfact.setForeground(new Color(255, 255, 255));
		lblconfact.setFont(new Font("Verdana", Font.BOLD, 18));
		lblconfact.setBounds(80, 36, 174, 23);
		getContentPane().add(lblconfact);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(247, 186, 42));
		panel_1.setBounds(409, 110, 327, 40);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblidfact = new JLabel("C\u00F3digo");
		lblidfact.setBounds(52, 9, 60, 21);
		panel_1.add(lblidfact);
		lblidfact.setForeground(new Color(255, 255, 255));
		lblidfact.setFont(new Font("Verdana", Font.BOLD, 16));
		
		tFid_pedido = new JTextField();
		tFid_pedido.setBounds(139, 10, 137, 20);
		panel_1.add(tFid_pedido);
		tFid_pedido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				filtro(tFid_pedido.getText().toUpperCase(), tablapedidos, tabladetallep);
			}
		});
		tFid_pedido.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConsultaPe.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(845, 25, 60, 60);
		getContentPane().add(label_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 254, 615, 156);
		getContentPane().add(scrollPane);
		
		tablapedidos = new JTable();
		scrollPane.setViewportView(tablapedidos);
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

		 		Statement comando = conexion.createStatement();

			 	ResultSet resultado = comando.executeQuery("select * from pedidos");
			 	DefaultTableModel model=new DefaultTableModel();

			 	model.addColumn("id_pedido");
			 	model.addColumn("num_pedidos");
			 	model.addColumn("fecha");
			 	model.addColumn("id_prov");

				tablapedidos.setModel(model);
				
				String[]dato=new String[4];
			 	
			 	while(resultado.next()){
					 dato[0]=resultado.getString(1);
					 dato[1]=resultado.getString(2);
					 dato[2]=resultado.getString(3);
					 dato[3]=resultado.getString(4);
					 model.addRow(dato);
			 	}
				
		}//fin del try
		 catch (Exception e) {
			 setTitle(e.toString());
				JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla pedidos");
	    }
		 
			JScrollPane sPdetallefact = new JScrollPane();
			sPdetallefact.setBounds(730, 254, 310, 156);
			getContentPane().add(sPdetallefact);
			
			tabladetallep = new JTable();
			sPdetallefact.setViewportView(tabladetallep);
			 try { 
				 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

			 		Statement comando = conexion.createStatement();

				 	ResultSet resultado = comando.executeQuery("select * from detallepedidos");
				 	DefaultTableModel model=new DefaultTableModel();

				 	model.addColumn("id_pedido");
				 	model.addColumn("num_pedidos");
				 	model.addColumn("id_prod");
				 	model.addColumn("cantidad");

					tabladetallep.setModel(model);
					
					String[]dato=new String[4];
				 	
				 	while(resultado.next()){
						 dato[0]=resultado.getString(1);
						 dato[1]=resultado.getString(2);
						 dato[2]=resultado.getString(3);
						 dato[3]=resultado.getString(4);
						 model.addRow(dato);
				 	}
					
			}//fin del try
			 catch (Exception e) {
				 setTitle(e.toString());
					JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla detallepedidos");
		    }
			 
			JPanel panel_cuad = new JPanel();
			panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
			panel_cuad.setBackground(new Color(255, 255, 255));
			panel_cuad.setBounds(47, 129, 1026, 323);
			getContentPane().add(panel_cuad);
			panel_cuad.setLayout(null);
			
			JLabel lblTablaFactura = new JLabel("TABLA PEDIDOS");
			lblTablaFactura.setBounds(35, 91, 116, 17);
			panel_cuad.add(lblTablaFactura);
			lblTablaFactura.setForeground(new Color(0, 0, 153));
			lblTablaFactura.setFont(new Font("Verdana", Font.BOLD, 13));
			
			JLabel lblDetalleDeFactura = new JLabel("DETALLE");
			lblDetalleDeFactura.setBounds(682, 91, 62, 17);
			panel_cuad.add(lblDetalleDeFactura);
			lblDetalleDeFactura.setForeground(new Color(0, 0, 153));
			lblDetalleDeFactura.setFont(new Font("Verdana", Font.BOLD, 13));

	}
	//método filtrar ambas tablas	
			private void filtro(String consulta, JTable tablapedidos,JTable tabladetallep){
		        model = (DefaultTableModel) tablapedidos.getModel();
		        mod = (DefaultTableModel) tabladetallep.getModel();
		        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
		        TableRowSorter<DefaultTableModel> tr2 = new TableRowSorter<>(mod);
		        tablapedidos.setRowSorter(tr);
		        tabladetallep.setRowSorter(tr2);
		        tr.setRowFilter(RowFilter.regexFilter(consulta));
		        tr2.setRowFilter(RowFilter.regexFilter(consulta));
		}//fin del método filtro

}
