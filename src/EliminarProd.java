import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class EliminarProd extends JInternalFrame {
	private JTextField tFid_prod;
	private JTextField tFdes;
	private JTextField tFmat;
	private JTextField tFcant;
	private JTextField tFpu;
	private JTextField tFprov;
	private JTable table;
	
	public static String elim;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProd frame = new EliminarProd();
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
	public EliminarProd() {
		elim="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				elim=null;
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Eliminar Productos");
		setBounds(100, 100, 896, 568);
		getContentPane().setLayout(null);
		
		JLabel lblprod = new JLabel("");
		lblprod.setIcon(new ImageIcon(AltasProductos.class.getResource("/Imagenes/productos.png")));
		lblprod.setBounds(378, 80, 80, 80);
		getContentPane().add(lblprod);
		
		JLabel lbleliprod = new JLabel("Eliminar Productos");
		lbleliprod.setForeground(new Color(255, 255, 255));
		lbleliprod.setFont(new Font("Verdana", Font.BOLD, 18));
		lbleliprod.setBounds(80, 35, 191, 23);
		getContentPane().add(lbleliprod);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(733, 27, 60, 60);
		getContentPane().add(label_1);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO");
		lblCdigo.setForeground(new Color(0, 0, 153));
		lblCdigo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCdigo.setBounds(102, 187, 57, 16);
		getContentPane().add(lblCdigo);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcin.setForeground(new Color(0, 0, 153));
		lblDescripcin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescripcin.setBounds(102, 234, 96, 16);
		getContentPane().add(lblDescripcin);
		
		JLabel lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setForeground(new Color(0, 0, 153));
		lblMaterial.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMaterial.setBounds(102, 279, 68, 16);
		getContentPane().add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setForeground(new Color(0, 0, 153));
		lblCantidad.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCantidad.setBounds(490, 234, 71, 16);
		getContentPane().add(lblCantidad);
		
		JLabel lblPrecioUnitario = new JLabel("PRECIO UNIT.");
		lblPrecioUnitario.setForeground(new Color(0, 0, 153));
		lblPrecioUnitario.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPrecioUnitario.setBounds(490, 279, 94, 16);
		getContentPane().add(lblPrecioUnitario);
		
		JLabel lblCdigoProveedor = new JLabel("C\u00D3D. PROVEEDOR");
		lblCdigoProveedor.setForeground(new Color(0, 0, 153));
		lblCdigoProveedor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCdigoProveedor.setBounds(102, 326, 122, 16);
		getContentPane().add(lblCdigoProveedor);
		
		tFid_prod = new JTextField();
		tFid_prod.setBounds(252, 187, 108, 20);
		getContentPane().add(tFid_prod);
		tFid_prod.setColumns(10);
		
		tFdes = new JTextField();
		tFdes.setBounds(252, 234, 210, 20);
		getContentPane().add(tFdes);
		tFdes.setColumns(10);
		
		tFmat = new JTextField();
		tFmat.setBounds(252, 277, 145, 23);
		getContentPane().add(tFmat);
		tFmat.setColumns(10);
		
		tFcant = new JTextField();
		tFcant.setBounds(610, 234, 143, 20);
		getContentPane().add(tFcant);
		tFcant.setColumns(10);
		
		tFpu = new JTextField();
		tFpu.setBounds(610, 279, 154, 20);
		getContentPane().add(tFpu);
		tFpu.setColumns(10);
		
		tFprov = new JTextField();
		tFprov.setBounds(252, 326, 108, 20);
		getContentPane().add(tFprov);
		tFprov.setColumns(10);
		
		JPanel panel_cuad = new JPanel();
		panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		panel_cuad.setBackground(new Color(255, 255, 255));
		panel_cuad.setBounds(37, 136, 804, 231);
		getContentPane().add(panel_cuad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 390, 615, 123);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tFid_prod.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				tFdes.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				tFmat.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				tFcant.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				tFpu.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
				tFprov.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
				tFid_prod.enable(false);
			}
		});
		scrollPane.setViewportView(table);
		
		//llamamos al metodo consulta
		consulta();
		
		JButton btnElim = new JButton("Eliminar");
		btnElim.setBounds(770, 438, 89, 23);
		getContentPane().add(btnElim);
		btnElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo=tFid_prod.getText();
				int pregunta=JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el ítem selecionado?");
				if(pregunta==JOptionPane.OK_OPTION) {
					try {
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root" ,"");
						Statement comando=conexion.createStatement();
						int cantidad = comando.executeUpdate("delete from productos where id_prod="+tFid_prod.getText());
						if (cantidad==1) {
							JOptionPane.showMessageDialog(null, "Se elimino el registro"+codigo);
							consulta();
							limpiar();
							
						} else {
							JOptionPane.showMessageDialog(null,"No existe un producto con dicho código");
						}
						conexion.close();
					} 
					    catch(SQLException ex){
						    setTitle(ex.toString());
					}						
				}
				else if(pregunta==JOptionPane.NO_OPTION) {
					limpiar();
				}
				else if(pregunta==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,"El registro seleccionado no fue eliminado");
				}
			
			}
		});

	}
	public void consulta() {
		try { 
		 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
	 		Statement comando = conexion.createStatement();
		 	ResultSet resultado = comando.executeQuery("select * from productos");
		 	DefaultTableModel model=new DefaultTableModel();
			model.addColumn("Código");
			model.addColumn("Descripción");
			model.addColumn("Material");
			model.addColumn("Cantidad");
			model.addColumn("Precio Unit");
			model.addColumn("Cod Proveedor");
			table.setModel(model);
			
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
	}
	 catch (Exception e) {
		 setTitle(e.toString());
			JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla productos");
	 }	 
}//fin del metodo consulta
	public void limpiar() {
		tFid_prod.setText("");
		tFdes.setText("");
		tFmat.setText("");
		tFcant.setText("");
		tFpu.setText("");
		tFprov.setText("");
	  }

	}