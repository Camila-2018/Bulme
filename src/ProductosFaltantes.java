import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductosFaltantes extends JInternalFrame {
	public static String pf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosFaltantes frame = new ProductosFaltantes();
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
	public ProductosFaltantes() {
		pf="Abierto";
		 addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosing(InternalFrameEvent e) {
					dispose();
					pf=null;
				}
			});
		getContentPane().setBackground(new Color(255, 255, 255));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 550, 338);
		getContentPane().setLayout(null);
		
		JButton btnNotaDePedidos = new JButton("Nota de Pedidos");
		btnNotaDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NotaPedidos nota=new NotaPedidos();
				Sistema.escritorio.add(nota);
				Dimension desktopSize=Sistema.escritorio.getSize();
				Dimension FrameSize=nota.getSize();
				nota.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
				nota.setVisible(true);
				NotaPedidos.tFid_prod.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				NotaPedidos.tFdes.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				NotaPedidos.tFid_prov.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
			}
		});
		btnNotaDePedidos.setBounds(203, 263, 127, 23);
		getContentPane().add(btnNotaDePedidos);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 534, 42);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProductosFaltantes = new JLabel("Productos Faltantes\r\n");
		lblProductosFaltantes.setBounds(185, 11, 162, 20);
		lblProductosFaltantes.setForeground(new Color(255, 255, 255));
		lblProductosFaltantes.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblProductosFaltantes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 70, 442, 170);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try { 
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

			Statement comando = conexion.createStatement();

			ResultSet resultado = comando.executeQuery("select id_prod,descripcion,material,cantidad,id_prov from productos where cantidad <= 5");
			DefaultTableModel model=new DefaultTableModel();

			model.addColumn("id_prod");
			model.addColumn("descripcion");
			model.addColumn("material");
			model.addColumn("cantidad");
			model.addColumn("id_prov");

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
				JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla productos");
		}

	}

}
