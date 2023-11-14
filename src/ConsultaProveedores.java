import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JInternalFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaProveedores extends JInternalFrame {
	private JTable tablaprov;
	private JTextField tFbpv;
	DefaultTableModel model;
	private JButton btnEnviar;
	
	public static String cpv;
	public static String cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProveedores frame = new ConsultaProveedores();
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
	public ConsultaProveedores() {
		cpv="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				cpv=null;
			}
		});
		setIconifiable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(ConsultaProveedores.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Consulta Proveedores");
		setBounds(100, 100, 787, 456);
		getContentPane().setLayout(null);
		
		JLabel lblconprov = new JLabel("Consulta Proveedores");
		lblconprov.setForeground(new Color(255, 255, 255));
		lblconprov.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblconprov.setBounds(80, 36, 178, 20);
		getContentPane().add(lblconprov);
		
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
		
		tFbpv = new JTextField();
		tFbpv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				filtro(tFbpv.getText().toUpperCase(), tablaprov);
			}
		});
		tFbpv.setBounds(341, 136, 202, 20);
		getContentPane().add(tFbpv);
		tFbpv.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 180, 615, 156);
		getContentPane().add(scrollPane);
		
		tablaprov = new JTable();
		scrollPane.setViewportView(tablaprov);
		
		try { 
		 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

	 		Statement comando = conexion.createStatement();

		 	ResultSet resultado = comando.executeQuery("select * from proveedores");
		 	DefaultTableModel model=new DefaultTableModel();

			model.addColumn("id_prov");
			model.addColumn("nombre");
			model.addColumn("direccion");
			model.addColumn("telefono");
			model.addColumn("correo");

			tablaprov.setModel(model);
			
			String[]dato=new String[5];
		 	
		 	while(resultado.next()){
				 dato[0]=resultado.getString(1);
				 dato[1]=resultado.getString(2);
				 dato[2]=resultado.getString(3);
				 dato[3]=resultado.getString(4);
				 dato[4]=resultado.getString(5);
				 model.addRow(dato);
		 	}
		 	
	}//fin del try
	 catch (Exception e) {
		 setTitle(e.toString());
			JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla proveedores");
	    }
		   JPanel panel_cuad = new JPanel();
		   panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		   panel_cuad.setBackground(new Color(255, 255, 255));
		   panel_cuad.setBounds(47, 109, 679, 258);
		   getContentPane().add(panel_cuad);
		
		   btnEnviar = new JButton("Enviar");
		   btnEnviar.setEnabled(false);
		   if(AltasProductos.Envio!=null) {
			   btnEnviar.setEnabled(true);
		   }
		   if(NotaPedidos.Envio!=null) {
			   btnEnviar.setEnabled(true);
		   }
		   btnEnviar.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		if(AltasProductos.Envio!=null) {
		   			cantidad=String.valueOf(tablaprov.getValueAt(tablaprov.getSelectedRow(),1));
					AltasProductos.tFid_prov.setText(String.valueOf(tablaprov.getValueAt(tablaprov.getSelectedRow(),0)));
					cpv=null;
					dispose();
		   		}
		   		else if(NotaPedidos.Envio!=null) { 
		   			NotaPedidos.tFid_prov.setText(String.valueOf(tablaprov.getValueAt(tablaprov.getSelectedRow(),0)));
		   			String nombre=new String(String.valueOf(tablaprov.getValueAt(tablaprov.getSelectedRow(),1)));
		   			String telefono=new String(String.valueOf(tablaprov.getValueAt(tablaprov.getSelectedRow(),3)));
		   			NotaPedidos.tFnomp.setText(nombre);
		   			NotaPedidos.tFtelp.setText(telefono);
		   			cpv=null;
		   			dispose();
		   		}
		   	}
		   });
		   if(AltasProductos.Envio!=null||NotaPedidos.Envio!=null){
			   btnEnviar.setEnabled(true);
		   }
		   btnEnviar.setBounds(352, 385, 89, 23);
		   getContentPane().add(btnEnviar);

	}
	//método filtrar 	
	private void filtro(String consulta, JTable tablaprov){
        model = (DefaultTableModel) tablaprov.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tablaprov.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
}//fin del método filtro

}
