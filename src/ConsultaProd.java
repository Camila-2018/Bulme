import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class ConsultaProd extends JInternalFrame {
	private JTable tablaprod;
	private JTextField tFbpr;
	DefaultTableModel model;
	private JButton btnEnviar;
	
	public static String cpr;
	public static String cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProd frame = new ConsultaProd();
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
	public ConsultaProd() {
		cpr="Abierto";
		 addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosing(InternalFrameEvent e) {
					dispose();
					cpr=null;
				}
			});
		setIconifiable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(ConsultaProd.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Consulta Productos");
		setBounds(100, 100, 789, 456);
		getContentPane().setLayout(null);

		JLabel lblconprod = new JLabel("Consulta Productos");
		lblconprod.setForeground(new Color(255, 255, 255));
		lblconprod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblconprod.setBounds(80, 36, 157, 20);
		getContentPane().add(lblconprod);
		
		JLabel lblbusq = new JLabel("B\u00FAsqueda");
		lblbusq.setForeground(new Color(0, 0, 153));
		lblbusq.setFont(new Font("Verdana", Font.BOLD, 16));
		lblbusq.setBounds(230, 136, 87, 21);
		getContentPane().add(lblbusq);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(675, 27, 60, 60);
		getContentPane().add(label_1);
		
		tFbpr = new JTextField();
		tFbpr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				filtro(tFbpr.getText().toUpperCase(), tablaprod);
			}
		});
		tFbpr.setColumns(10);
		tFbpr.setBounds(341, 136, 202, 20);
		getContentPane().add(tFbpr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setBounds(80, 180, 615, 156);
		getContentPane().add(scrollPane);
		
		tablaprod = new JTable();
		tablaprod.setInheritsPopupMenu(true);
		scrollPane.setViewportView(tablaprod);
		
		 try { 
			 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

		 		Statement comando = conexion.createStatement();

			 	ResultSet resultado = comando.executeQuery("select * from productos");
			 	DefaultTableModel model=new DefaultTableModel();

				model.addColumn("id_prod");
				model.addColumn("descripción");
				model.addColumn("material");
				model.addColumn("cantidad");
				model.addColumn("preuni");
				model.addColumn("id_prov");

				tablaprod.setModel(model);
				
				String[]dato=new String[6];
			 	
			 	while(resultado.next()){
					 dato[0]=resultado.getString(1);
					 dato[1]=resultado.getString(2);
					 dato[2]=resultado.getString(3);
					 dato[3]=resultado.getString(4);
					 dato[4]=resultado.getString(5);
					 dato[5]=resultado.getString(6);
					 model.addRow(dato);
			 	}
				
		}//fin del try
		 catch (Exception e) {
			 setTitle(e.toString());
				JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla productos");
	    }
			JPanel panel_cuad = new JPanel();
			panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
			panel_cuad.setBackground(new Color(255, 255, 255));
			panel_cuad.setBounds(47, 109, 679, 258);
			getContentPane().add(panel_cuad);
			
			JButton btnEnviar = new JButton("Enviar");
			btnEnviar.setEnabled(false);
			  if(Facturar.Envio!=null) {
				  btnEnviar.setEnabled(true);
			  }
			  if(NotaPedidos.Envio!=null) {
				  btnEnviar.setEnabled(true);
			  }
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Facturar.Envio!=null) {
						cantidad=String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),3));
						Facturar.tFid_prod.setText(String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),0)));
						Facturar.tFdes.setText(String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),1)));
						Facturar.tFpu.setText(String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),4)));
						cpr=null;
						dispose();
					}
					else if(NotaPedidos.Envio!=null) {
						NotaPedidos.tFid_prod.setText(String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),0)));
						NotaPedidos.tFdes.setText(String.valueOf(tablaprod.getValueAt(tablaprod.getSelectedRow(),1)));
						cpr=null;
						dispose();
					}
				}
			});
			if(Facturar.Envio!=null||NotaPedidos.Envio!=null) {
				btnEnviar.setEnabled(true);
			}
			btnEnviar.setBounds(352, 385, 89, 23);
			getContentPane().add(btnEnviar);
		 
		}
	//método filtrar 	
	private void filtro(String consulta, JTable tablaprod){
        model = (DefaultTableModel) tablaprod.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tablaprod.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
}//fin del método filtro
	
}