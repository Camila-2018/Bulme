import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class ModificarClie extends JInternalFrame {
	private JTextField tFid_clie;
	private JTextField tFnom;
	private JTextField tFdire;
	private JTextField tFtel;
	private JTextField tFcorreo;
	private JTable table;
	
	public static String mclie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarClie frame = new ModificarClie();
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
	public ModificarClie() {
		mclie="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				mclie=null;
			}
		});
		setFrameIcon(new ImageIcon(ModificarClie.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Modificar Clientes");
		setBounds(100, 100, 896, 573);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblusuario = new JLabel("");
		lblusuario.setIcon(new ImageIcon(ModificarClie.class.getResource("/Imagenes/Login4.png")));
		lblusuario.setBounds(92, 89, 80, 80);
		getContentPane().add(lblusuario);
		
		JLabel lblmodclie = new JLabel("Modificar Clientes");
		lblmodclie.setForeground(new Color(255, 255, 255));
		lblmodclie.setFont(new Font("Verdana", Font.BOLD, 18));
		lblmodclie.setBounds(80, 35, 181, 23);
		getContentPane().add(lblmodclie);
		
		JLabel lblmdatos = new JLabel("Datos Generales");
		lblmdatos.setForeground(new Color(255, 255, 255));
		lblmdatos.setFont(new Font("Verdana", Font.BOLD, 16));
		lblmdatos.setBounds(244, 118, 145, 21);
		getContentPane().add(lblmdatos);
		
		JPanel paneldatos = new JPanel();
		paneldatos.setBackground(new Color(247, 186, 42));
		paneldatos.setBounds(200, 113, 232, 33);
		getContentPane().add(paneldatos);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(70, 130, 180), null));
		panel.setBounds(0, 27, 636, 40);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ModificarClie.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(733, 27, 60, 60);
		getContentPane().add(label_1);
		
		JLabel lblid_clie = new JLabel("C\u00D3DIGO");
		lblid_clie.setForeground(new Color(0, 0, 153));
		lblid_clie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblid_clie.setBounds(63, 187, 57, 16);
		getContentPane().add(lblid_clie);
		
		JLabel lblNombreClie = new JLabel("NOMBRE");
		lblNombreClie.setForeground(new Color(0, 0, 153));
		lblNombreClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombreClie.setBounds(63, 234, 58, 16);
		getContentPane().add(lblNombreClie);
		
		JLabel lblDireccionClie = new JLabel("DIRECCI\u00D3N");
		lblDireccionClie.setForeground(new Color(0, 0, 153));
		lblDireccionClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDireccionClie.setBounds(63, 279, 78, 16);
		getContentPane().add(lblDireccionClie);
		
		JLabel lblTelefonoClie = new JLabel("TEL\u00C9FONO");
		lblTelefonoClie.setForeground(new Color(0, 0, 153));
		lblTelefonoClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefonoClie.setBounds(439, 234, 72, 16);
		getContentPane().add(lblTelefonoClie);
		
		JLabel lblCorreoClie = new JLabel("CORREO ELECT.");
		lblCorreoClie.setForeground(new Color(0, 0, 153));
		lblCorreoClie.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCorreoClie.setBounds(439, 279, 106, 16);
		getContentPane().add(lblCorreoClie);
		
		tFid_clie = new JTextField();
		tFid_clie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_clie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFid_clie.setSelectionColor(new Color(255, 255, 255));
		tFid_clie.setDisabledTextColor(new Color(0, 0, 0));
		tFid_clie.setBackground(new Color(255, 255, 255));
		tFid_clie.setEnabled(false);
		tFid_clie.setBounds(168, 187, 108, 20);
		getContentPane().add(tFid_clie);
		tFid_clie.setColumns(10);
		
		tFnom = new JTextField();
		tFnom.setBounds(168, 234, 210, 20);
		getContentPane().add(tFnom);
		tFnom.setColumns(10);
		
		tFdire = new JTextField();
		tFdire.setBounds(168, 279, 244, 20);
		getContentPane().add(tFdire);
		tFdire.setColumns(10);
		
		tFtel = new JTextField();
		tFtel.setBounds(571, 234, 143, 20);
		getContentPane().add(tFtel);
		tFtel.setColumns(10);
		
		tFcorreo = new JTextField();
		tFcorreo.setBounds(571, 279, 244, 20);
		getContentPane().add(tFcorreo);
		tFcorreo.setColumns(10);
		
		JButton btnModif = new JButton("Modificar");
		btnModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pregunta=JOptionPane.showConfirmDialog(null, "¿Está seguro de querer modificar el ítem seleccionado?");
				if(pregunta==JOptionPane.OK_OPTION) {
					try {
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root" ,"");
						Statement comando=conexion.createStatement();
						int cantidad = comando.executeUpdate("update clientes set nombre='" + tFnom.getText() + "',direccion='"+tFdire.getText()+"',"
								+ "telefono='"+tFtel.getText()+ "',correo='"+tFcorreo.getText()+"' where id_clie="+tFid_clie.getText());
						if (cantidad==1) {
							JOptionPane.showMessageDialog(null, "Se modifico la tabla clientes");
							consulta();
							limpiar();
							
						} else {
							JOptionPane.showMessageDialog(null,"No existe un cliente con dicho código");
						}
						conexion.close();
					} catch(SQLException ex){
						setTitle(ex.toString());
					}				
				}
				else if(pregunta==JOptionPane.NO_OPTION) {
					limpiar();
				}
				else if(pregunta==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,"El registro seleccionado no fue modificado");
				}
				
			}
		});
		btnModif.setBounds(395, 502, 89, 23);
		getContentPane().add(btnModif);
		
		JPanel panel_cuad = new JPanel();
		panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		panel_cuad.setBackground(new Color(255, 255, 255));
		panel_cuad.setBounds(39, 130, 804, 196);
		getContentPane().add(panel_cuad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(135, 360, 615, 123);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 102, 204));
		table.setSelectionBackground(new Color(255, 255, 255));
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tFid_clie.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				tFnom.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				tFdire.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				tFtel.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				tFcorreo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
				tFid_clie.enable(false);
			}
		});
	
		scrollPane.setViewportView(table);
		
		//llamamos al metodo consulta
		consulta();
	
	}
	public void consulta() {
		try { 
		 	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bulme","root","");
	 		Statement comando = conexion.createStatement();
		 	ResultSet resultado = comando.executeQuery("select * from clientes");
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
			JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla clientes");
	   }	
		
	}//fin del metodo consulta
	
	public void limpiar() {
		tFid_clie.setText("");
		tFnom.setText("");
		tFdire.setText("");
		tFtel.setText("");
		tFcorreo.setText("");
	}
}
