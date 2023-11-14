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

public class ModifUser extends JInternalFrame {
	private JTextField tFid_user;
	private JTextField tFnom;
	private JTextField tFuser;
	private JTextField tFpass;
	private JTable table;
	
	public static String muser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifUser frame = new ModifUser();
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
	public ModifUser() {
		muser="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				muser=null;
			}
		});
		setFrameIcon(new ImageIcon(ModifUser.class.getResource("/Imagenes/Bulme24.png")));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Modificar Usuarios");
		setBounds(100, 100, 896, 573);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblusuario = new JLabel("");
		lblusuario.setIcon(new ImageIcon(ModifUser.class.getResource("/Imagenes/User.png")));
		lblusuario.setBounds(92, 89, 82, 82);
		getContentPane().add(lblusuario);
		
		JLabel lblmodclie = new JLabel("Modificar Usuarios");
		lblmodclie.setForeground(new Color(255, 255, 255));
		lblmodclie.setFont(new Font("Verdana", Font.BOLD, 18));
		lblmodclie.setBounds(80, 35, 189, 23);
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
		label_1.setIcon(new ImageIcon(AltasClientes.class.getResource("/Imagenes/logo2.png")));
		label_1.setBounds(733, 27, 60, 60);
		getContentPane().add(label_1);
		
		JLabel lblid_user = new JLabel("C\u00D3DIGO");
		lblid_user.setForeground(new Color(0, 0, 153));
		lblid_user.setFont(new Font("Verdana", Font.BOLD, 12));
		lblid_user.setBounds(63, 187, 57, 16);
		getContentPane().add(lblid_user);
		
		JLabel lblnom = new JLabel("NOMBRE");
		lblnom.setForeground(new Color(0, 0, 153));
		lblnom.setFont(new Font("Verdana", Font.BOLD, 12));
		lblnom.setBounds(428, 187, 58, 16);
		getContentPane().add(lblnom);
		
		JLabel lbluser = new JLabel("USUARIO");
		lbluser.setForeground(new Color(0, 0, 153));
		lbluser.setFont(new Font("Verdana", Font.BOLD, 12));
		lbluser.setBounds(63, 234, 64, 16);
		getContentPane().add(lbluser);
		
		JLabel lblpass = new JLabel("CONTRASE\u00D1A");
		lblpass.setForeground(new Color(0, 0, 153));
		lblpass.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpass.setBounds(428, 234, 92, 16);
		getContentPane().add(lblpass);
		
		tFid_user = new JTextField();
		tFid_user.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 153, 153)));
		tFid_user.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFid_user.setBackground(new Color(255, 255, 255));
		tFid_user.setSelectionColor(new Color(255, 255, 255));
		tFid_user.setDisabledTextColor(new Color(0, 0, 0));
		tFid_user.setEnabled(false);
		tFid_user.setBounds(168, 187, 112, 20);
		getContentPane().add(tFid_user);
		tFid_user.setColumns(10);
		
		tFnom = new JTextField();
		tFnom.setBounds(168, 234, 210, 20);
		getContentPane().add(tFnom);
		tFnom.setColumns(10);
		
		tFuser = new JTextField();
		tFuser.setBounds(571, 187, 210, 20);
		getContentPane().add(tFuser);
		tFuser.setColumns(10);
		
		tFpass = new JTextField();
		tFpass.setBounds(571, 234, 210, 20);
		getContentPane().add(tFpass);
		tFpass.setColumns(10);
		
		JButton btnModif = new JButton("Modificar");
		btnModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pregunta=JOptionPane.showConfirmDialog(null, "¿Está seguro de querer modificar el ítem seleccionado?");
				if(pregunta==JOptionPane.OK_OPTION) {
					try {
						Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bulme","root" ,"");
						Statement comando=conexion.createStatement();
						int cantidad = comando.executeUpdate("update usuarios set nombre='"+tFnom.getText()+"',"
								+ "usuario='"+tFuser.getText()+ "',password='"+tFpass.getText()+"' where id_usuario="+tFid_user.getText());
						if (cantidad==1) {
							JOptionPane.showMessageDialog(null, "Se modifico la tabla usuarios");
							consulta();
							limpiar();
							
						} else {
							JOptionPane.showMessageDialog(null,"No existe un usuario con dicho código");
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
		btnModif.setBounds(395, 495, 89, 23);
		getContentPane().add(btnModif);
		
		JPanel panel_cuad = new JPanel();
		panel_cuad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(247, 186, 42), new Color(247, 186, 42)));
		panel_cuad.setBackground(new Color(255, 255, 255));
		panel_cuad.setBounds(37, 136, 804, 163);
		getContentPane().add(panel_cuad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(135, 345, 615, 123);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 102, 204));
		table.setSelectionBackground(new Color(255, 255, 255));
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tFid_user.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				tFnom.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				tFuser.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				tFpass.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				tFid_user.enable(false);
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

	 		ResultSet resultado = comando.executeQuery("select * from usuarios");
		 	DefaultTableModel model=new DefaultTableModel();

		 	model.addColumn("código");
			model.addColumn("nombre");
			model.addColumn("usuario");
			model.addColumn("contraseña");

			table.setModel(model);
			
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
			JOptionPane.showMessageDialog(null,"Problemas al consultar la tabla usuarios");
      }	 
		
	}//fin del metodo consulta
	
	public void limpiar() {
		tFid_user.setText("");
		tFnom.setText("");
		tFuser.setText("");
		tFpass.setText("");
	  }

}
