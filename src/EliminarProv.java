import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProv extends JInternalFrame {
	private JTextField tFid_prov;
	private JTextField tFnomp;
	private JTextField tFdirep;
	private JTextField tFcorreop;
	private JTextField tFtelp;
	private JTable table;
	
	public static String elimpv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProv frame = new EliminarProv();
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
	public EliminarProv() {
		elimpv="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				elimpv=null;
			}
		});
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Eliminar Proveedores");
		setBounds(100, 100, 896, 542);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblprov = new JLabel("");
		lblprov.setIcon(new ImageIcon(AltasProveedores.class.getResource("/Imagenes/proveedor.png")));
		lblprov.setBounds(378, 80, 80, 80);
		getContentPane().add(lblprov);
		
		JLabel lbleliprov = new JLabel("Eliminar Proveedores");
		lbleliprov.setForeground(new Color(255, 255, 255));
		lbleliprov.setFont(new Font("Verdana", Font.BOLD, 18));
		lbleliprov.setBounds(80, 35, 216, 23);
		getContentPane().add(lbleliprov);
		
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
		
		JLabel lblCod_Prov = new JLabel("C\u00D3DIGO");
		lblCod_Prov.setForeground(new Color(0, 0, 153));
		lblCod_Prov.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCod_Prov.setBounds(63, 187, 57, 16);
		getContentPane().add(lblCod_Prov);
		
		JLabel lblNom_Prov = new JLabel("NOMBRE");
		lblNom_Prov.setForeground(new Color(0, 0, 153));
		lblNom_Prov.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNom_Prov.setBounds(63, 234, 58, 16);
		getContentPane().add(lblNom_Prov);
		
		JLabel lblDirec_Prov = new JLabel("DIRECCI\u00D3N");
		lblDirec_Prov.setForeground(new Color(0, 0, 153));
		lblDirec_Prov.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDirec_Prov.setBounds(63, 279, 78, 16);
		getContentPane().add(lblDirec_Prov);
		
		JLabel lblTel_Prov = new JLabel("TEL\u00C9FONO");
		lblTel_Prov.setForeground(new Color(0, 0, 153));
		lblTel_Prov.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTel_Prov.setBounds(439, 234, 72, 16);
		getContentPane().add(lblTel_Prov);
		
		JLabel lblCorreo_Prov = new JLabel("CORREO ELECT.");
		lblCorreo_Prov.setForeground(new Color(0, 0, 153));
		lblCorreo_Prov.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCorreo_Prov.setBounds(439, 279, 106, 16);
		getContentPane().add(lblCorreo_Prov);
		
		tFid_prov = new JTextField();
		tFid_prov.setBounds(168, 187, 108, 20);
		getContentPane().add(tFid_prov);
		tFid_prov.setColumns(10);
		
		tFnomp = new JTextField();
		tFnomp.setBounds(168, 234, 210, 20);
		getContentPane().add(tFnomp);
		tFnomp.setColumns(10);
		
		tFdirep = new JTextField();
		tFdirep.setBounds(168, 279, 244, 20);
		getContentPane().add(tFdirep);
		tFdirep.setColumns(10);
		
		tFtelp = new JTextField();
		tFtelp.setBounds(571, 234, 143, 20);
		getContentPane().add(tFtelp);
		tFtelp.setColumns(10);
		
		tFcorreop = new JTextField();
		tFcorreop.setBounds(571, 279, 244, 20);
		getContentPane().add(tFcorreop);
		tFcorreop.setColumns(10);
		
		JPanel panel_cuad = new JPanel();
		panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		panel_cuad.setBackground(new Color(255, 255, 255));
		panel_cuad.setBounds(37, 136, 804, 196);
		getContentPane().add(panel_cuad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(124, 360, 615, 123);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tFid_prov.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				tFnomp.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				tFdirep.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				tFtelp.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				tFcorreop.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
				tFid_prov.enable(false);
			}
		});
		scrollPane.setViewportView(table);
		
		//llamamos al metodo consulta
		consulta();
		
		JButton btnElim = new JButton("Eliminar");
		btnElim.setBounds(763, 405, 89, 23);
		getContentPane().add(btnElim);
		btnElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo=tFid_prov.getText();
				int pregunta=JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el ítem selecionado?");
				if(pregunta==JOptionPane.OK_OPTION) {
					try {
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root" ,"");
						Statement comando=conexion.createStatement();
						int cantidad = comando.executeUpdate("delete from proveedores where id_prov="+codigo);
						if (cantidad==1) {
							JOptionPane.showMessageDialog(null, "Se elimino el registro"+codigo);
							consulta();
							limpiar();
							
						} else {
							JOptionPane.showMessageDialog(null,"No existe un proveedor con dicho código");
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
		 	ResultSet resultado = comando.executeQuery("select * from proveedores");
		 	DefaultTableModel model=new DefaultTableModel();
			model.addColumn("Código");
			model.addColumn("Nombre");
			model.addColumn("Dirección");
			model.addColumn("Teléfono");
			model.addColumn("Correo Electrónico");
			table.setModel(model);
			
			String[]dato=new String[5];
		 	
		 	while(resultado.next()){
			 dato[0]=resultado.getString(1);
			 dato[1]=resultado.getString(2);
			 dato[2]=resultado.getString(3);
			 dato[3]=resultado.getString(4);
			 dato[4]=resultado.getString(5);
			 model.addRow(dato);
		 }
	}
	 catch (Exception e) {
		 setTitle(e.toString());
			JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla proveedores");
	   }	
}//fin del metodo consulta
	
	public void limpiar() {
		tFid_prov.setText("");
		tFnomp.setText("");
		tFdirep.setText("");
		tFtelp.setText("");
		tFcorreop.setText("");
	  }

	}
