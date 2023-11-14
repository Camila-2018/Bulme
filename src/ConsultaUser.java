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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaUser extends JInternalFrame {
	private JTable tablauser;
	private JTextField tFbu;
	DefaultTableModel model;
	private JButton btnEnviar;
	
	public static String cuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUser frame = new ConsultaUser();
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
	public ConsultaUser() {
		cuser="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				cuser=null;
			}
		});
		setIconifiable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setFrameIcon(new ImageIcon(ConsultaClientes.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Consulta Usuarios");
		setBounds(100, 100, 917, 456);
		getContentPane().setLayout(null);
		
		JLabel lblconclie = new JLabel("Consulta de Usuarios");
		lblconclie.setForeground(new Color(255, 255, 255));
		lblconclie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblconclie.setBounds(80, 36, 171, 20);
		getContentPane().add(lblconclie);
		
		JLabel lblbusq = new JLabel("B\u00FAsqueda");
		lblbusq.setForeground(new Color(0, 0, 153));
		lblbusq.setFont(new Font("Verdana", Font.BOLD, 16));
		lblbusq.setBounds(276, 136, 87, 21);
		getContentPane().add(lblbusq);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(738, 25, 60, 60);
		getContentPane().add(label_1);
		
		tFbu = new JTextField();
		 tFbu.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyTyped(KeyEvent e) {
		 		filtro(tFbu.getText().toUpperCase(), tablauser);
		 	}
		 });
		 tFbu.setBounds(387, 136, 202, 20);
		 getContentPane().add(tFbu);
		 tFbu.setColumns(10);
		 
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(80, 180, 742, 156);
			getContentPane().add(scrollPane);
			
			tablauser = new JTable();
			tablauser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AltasUser.tFid_user.setText(String.valueOf(tablauser.getValueAt(tablauser.getSelectedRow(),0)));
					AltasUser.tFtipo.setText(String.valueOf(tablauser.getValueAt(tablauser.getSelectedRow(),1)));
					AltasUser.tFnom.setText(String.valueOf(tablauser.getValueAt(tablauser.getSelectedRow(),2)));
					AltasUser.tFuser.setText(String.valueOf(tablauser.getValueAt(tablauser.getSelectedRow(),3)));
					AltasUser.tFpass.setText(String.valueOf(tablauser.getValueAt(tablauser.getSelectedRow(),4)));
				}
			});
			scrollPane.setViewportView(tablauser);
			
			 try { 
				 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");

			 		Statement comando = conexion.createStatement();

				 	ResultSet resultado = comando.executeQuery("select * from usuarios");
				 	DefaultTableModel model=new DefaultTableModel();

				 	model.addColumn("c�digo");
					model.addColumn("nombre");
					model.addColumn("usuario");
					model.addColumn("contrase�a");
					model.addColumn("tipo");

					tablauser.setModel(model);
					
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
					JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla usuarios");
			 }
			   JPanel panel_cuad = new JPanel();
			   panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
			   panel_cuad.setBackground(new Color(255, 255, 255));
			   panel_cuad.setBounds(47, 109, 806, 258);
			   getContentPane().add(panel_cuad);
			   panel_cuad.setLayout(null);
			
			   btnEnviar = new JButton("Enviar");
			   btnEnviar.setBounds(341, 385, 89, 23);
			   getContentPane().add(btnEnviar);

	}
	//m�todo filtrar 	
	private void filtro(String consulta, JTable tablauser){
        model = (DefaultTableModel) tablauser.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tablauser.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
}//fin del m�todo filtro

}
