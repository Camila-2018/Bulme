import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Frame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sistema extends JFrame {
	private JPanel contentPane;
	public JLabel lbltipo = new JLabel("administrador");
	public JMenuItem mntmAltaUser = new JMenuItem("Altas Usuario");
	public JMenuItem mntmModifUser = new JMenuItem("Modificar Usuario");
	public JMenuItem mntmElimUser = new JMenuItem("Eliminar Usuario");
	public JMenuItem mntmConsultaUser = new JMenuItem("Consulta Usuario");
	public JMenuItem mntmAltaprod = new JMenuItem("Alta Productos");
	public JMenuItem mntmModprod = new JMenuItem("Modificar Productos");
	public JMenuItem mntmElimprod = new JMenuItem("Eliminar Productos");
	public JMenuItem mntmElimclie = new JMenuItem("Eliminar Clientes");
	public JMenuItem mntmAltaprov = new JMenuItem("Alta Proveedores");
	public JMenuItem mntmModprov = new JMenuItem("Modificar Proveedores");
	public JMenuItem mntmElimprov = new JMenuItem("Eliminar Proveedor");
	public JMenu mnRedesSociales = new JMenu("Redes Sociales");
    public static JDesktopPane escritorio=new JDesktopPane();
    public static JInternalFrame ab;
	public static String open;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
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
	public Sistema() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sistema.class.getResource("/Imagenes/Bulme24.png")));
		setTitle("Sistema de Ventas");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		escritorio.setBackground(new Color(240, 248, 255));
		contentPane.add(escritorio);
		escritorio.setLayout(null);
		
		JLabel lblnombre = new JLabel("");
		lblnombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombre.setForeground(Color.DARK_GRAY);
		lblnombre.setFont(new Font("Verdana", Font.BOLD, 26));
		lblnombre.setBounds(55, 39, 300, 25);
		lblnombre.setText(Login.nombre);
		escritorio.add(lblnombre);
		
		JLabel lbltipo_1 = new JLabel("");
		lbltipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltipo_1.setForeground(Color.DARK_GRAY);
		lbltipo_1.setFont(new Font("Verdana", Font.BOLD, 26));
		lbltipo_1.setBounds(55, 87, 300, 25);
		escritorio.add(lbltipo_1);
		
		lbltipo_1.setText(Login.tipo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Bulme Fondo.png")));
		label.setBounds(0, 0, 1355, 673);
		escritorio.add(label);
		
		//Fondo2 f=new Fondo2();//importar imagen de ventana fondo
		//f.setBorder(new EmptyBorder(5,5,5,5));
		//setContentPane(f);
		//f.setLayout(null);
		//ImageIcon icon = new ImageIcon(getClass().getResource("Imagenes/Bulme Fondo.png"));
		//Image image = icon.getImage();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 204));
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 1361, 21);
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnSistema.setForeground(new Color(255, 255, 255));
		
		menuBar.add(mnSistema);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Sistema.this.dispose();
			}
		});
		
        //JMenuItem mntmAltaUser = new JMenuItem("Altas Usuario");
		mntmAltaUser.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/AltaUser.png")));
		mntmAltaUser.setBackground(new Color(255, 255, 255));
	    habilitar();
		mntmAltaUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String au=AltasUser.cuser;
				try {
					if(au==null) {
						AltasUser cuser=new AltasUser();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=cuser.getSize();
						cuser.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(cuser);
						cuser.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Altas Usuarios se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmAltaUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmAltaUser);
		
        //JMenuItem mntmModifUser = new JMenuItem("Modificar Usuario");
		mntmModifUser.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/EditUser.png")));
		mntmModifUser.setBackground(new Color(255, 255, 255));
		habilitar();
		mntmModifUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mu=ModifUser.muser;
				try {
					if(mu==null) {
						ModifUser muser=new ModifUser();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=muser.getSize();
						muser.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(muser);
						muser.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Modificar Usuario se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmModifUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmModifUser);
		
        //JMenuItem mntmElimUser = new JMenuItem("Eliminar Usuario");
		mntmElimUser.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/ElimUser.png")));
		mntmElimUser.setBackground(new Color(255, 255, 255));
		habilitar();
		mntmElimUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eu=EliminarUser.elimu;
				try {
					if(eu==null) {
					    EliminarUser elimu=new EliminarUser();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=elimu.getSize();
						elimu.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(elimu);
						elimu.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Eliminar Usuario se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmElimUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmElimUser);
		
        //JMenuItem mntmConsult = new JMenuItem("Consulta Usuario");
		habilitar();
		mntmConsultaUser.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/ConUser.png")));
		mntmConsultaUser.setBackground(new Color(255, 255, 255));
		mntmConsultaUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cu=ConsultaUser.cuser;
				try {
					if(cu==null) {
						ConsultaUser cuser=new ConsultaUser();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=cuser.getSize();
						cuser.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(cuser);
						cuser.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Usuarios se encuentra abierto");
					}
				} 
				    catch (Exception e1) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmConsultaUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmConsultaUser);
		
		JMenuItem mntmCamUser = new JMenuItem("Cambiar  Usuario");
		mntmCamUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login usuario=new Login();
				usuario.setVisible(true);
				//Login.users="";
				dispose();
			}
		});
		mntmCamUser.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/cambiaruser.png")));
		mntmCamUser.setBackground(new Color(255, 255, 255));
		mntmCamUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmCamUser);
		
		mntmCerrar.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/cerrar32.png")));
		mntmCerrar.setBackground(new Color(255, 255, 255));
		mntmCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnSistema.add(mntmCerrar);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnProductos.setForeground(new Color(255, 255, 255));
		menuBar.add(mnProductos);
		
		//JMenuItem mntmAlta = new JMenuItem("Alta Productos");
		mntmAltaprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ap=AltasProductos.pro;
				try {
					if(ap==null) {
						AltasProductos pro=new AltasProductos();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=pro.getSize();
						pro.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(pro);
						pro.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Altas Productos se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmAltaprod.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Nuevo48.png")));
		mntmAltaprod.setBackground(new Color(255, 255, 255));
		mntmAltaprod.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProductos.add(mntmAltaprod);
		
		//JMenuItem mntmModificacin = new JMenuItem("Modificar Productos");
		mntmModprod.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/edit48.png")));
		mntmModprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mp=ModificarProductos.mprod;
				try {
					if(mp==null) {
						ModificarProductos mprod=new ModificarProductos();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=mprod.getSize();
						mprod.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(mprod);
						mprod.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Modificar Productos se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}	
			}
		});
		mntmModprod.setBackground(new Color(255, 255, 255));
		mntmModprod.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProductos.add(mntmModprod);
		
		JMenuItem mntmConsultaprod = new JMenuItem("Consulta Productos");
		mntmConsultaprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cp=ConsultaProd.cpr;
				try {
					if(cp==null) {
						ConsultaProd cpr=new ConsultaProd();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=cpr.getSize();
						cpr.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(cpr);
						cpr.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Productos se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
		//JMenuItem mntmEliminar = new JMenuItem("Eliminar Productos");
		mntmElimprod.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Eliminar1.png")));
		mntmElimprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ep=EliminarProd.elim;
				try {
					if(ep==null) {
						EliminarProd elim=new EliminarProd();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=elim.getSize();
						elim.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(elim);
						elim.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Eliminar Productos se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmElimprod.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProductos.add(mntmElimprod);
		
		mntmConsultaprod.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/consulta48.png")));
		mntmConsultaprod.setBackground(new Color(255, 255, 255));
		mntmConsultaprod.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProductos.add(mntmConsultaprod);
		
		JMenuItem mntmProdfalt = new JMenuItem("Productos Faltantes");
		mntmProdfalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pdf=ProductosFaltantes.pf;
				try {
					if(pdf==null) {
						ProductosFaltantes pf=new ProductosFaltantes();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=pf.getSize();
						pf.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(pf);
						pf.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Productos Faltantes se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmProdfalt.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Prodfalt.png")));
		mntmProdfalt.setBackground(new Color(255, 255, 255));
		mntmProdfalt.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProductos.add(mntmProdfalt);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnClientes.setForeground(new Color(255, 255, 255));
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltaclie = new JMenuItem("Alta Clientes");
		mntmAltaclie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ac=AltasClientes.clie;
				try {
					if(ac==null) {
						AltasClientes clie=new AltasClientes();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=clie.getSize();
						clie.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(clie);
						clie.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Altas Clientes se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmAltaclie.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Nuevo48.png")));
		mntmAltaclie.setBackground(new Color(255, 255, 255));
		mntmAltaclie.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnClientes.add(mntmAltaclie);
		
		JMenuItem mntmModclie = new JMenuItem("Modificar Clientes");
		mntmModclie.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/edit48.png")));
		mntmModclie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mc=ModificarClie.mclie;
				try {
					if(mc==null) {
						ModificarClie mclie=new ModificarClie();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=mclie.getSize();
						mclie.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(mclie);
						mclie.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Modificar Clientes se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmModclie.setBackground(new Color(255, 255, 255));
		mntmModclie.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnClientes.add(mntmModclie);
		
		JMenuItem mntmConsultaclie = new JMenuItem("Consulta Clientes");
		mntmConsultaclie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String c=ConsultaClientes.clie;
				try {
					if(c==null) {
						ConsultaClientes clie=new ConsultaClientes();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=clie.getSize();
						clie.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(clie);
						clie.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Clientes se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
		//JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar Clientes");
		mntmElimclie.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Eliminar1.png")));
		mntmElimclie.setBackground(new Color(255, 255, 255));
		mntmElimclie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ec=EliminarClie.elimc;
				try {
					if(ec==null) {
						EliminarClie elimc=new EliminarClie();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=elimc.getSize();
						elimc.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(elimc);
						elimc.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Eliminar Clientes se encuentra abierto");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmElimclie.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		
		mnClientes.add(mntmElimclie);
		mntmConsultaclie.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/consulta48.png")));
		mntmConsultaclie.setBackground(new Color(255, 255, 255));
		mntmConsultaclie.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnClientes.add(mntmConsultaclie);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		mnProveedores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnProveedores.setForeground(new Color(255, 255, 255));
		menuBar.add(mnProveedores);
		
        //JMenuItem mntmAlta2 = new JMenuItem("Alta Proveedores");
		habilitar();
		mntmAltaprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String apv=AltasProveedores.prov;
				try {
					if(apv==null) {
						AltasProveedores prov=new AltasProveedores();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=prov.getSize();
						prov.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(prov);
						prov.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Altas Proveedores se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmAltaprov.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Nuevo48.png")));
		mntmAltaprov.setBackground(new Color(255, 255, 255));
		mntmAltaprov.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmAltaprov);
		
        //JMenuItem mntmModificacin2 = new JMenuItem("Modificar Proveedores");
		mntmModprov.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/edit48.png")));
		habilitar();
		mntmModprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mpv=ModificarProv.mprov;
				try {
					if(mpv==null) {
						ModificarProv mprov=new ModificarProv();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=mprov.getSize();
						mprov.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(mprov);
						mprov.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Modificar Proveedores se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmModprov.setBackground(new Color(255, 255, 255));
		mntmModprov.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmModprov);
		
		JMenuItem mntmConsultaprov = new JMenuItem("Consulta Proveedores");
		mntmConsultaprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpr=ConsultaProveedores.cpv;
				try {
					if(cpr==null) {
						ConsultaProveedores cpv=new ConsultaProveedores();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=cpv.getSize();
						cpv.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(cpv);
						cpv.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Proveedores se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
        //JMenuItem mntmEliminar_2 = new JMenuItem("Eliminar");
		mntmElimprov.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Eliminar1.png")));
		habilitar();
		mntmElimprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String epv=EliminarProv.elimpv;
				try {
					if(epv==null) {
						EliminarProv elimpv=new EliminarProv();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=elimpv.getSize();
						elimpv.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(elimpv);
						elimpv.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Eliminar Proveedores se encuentra abierto");
					}
				} 
				    catch (Exception ex) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmElimprov.setSelected(true);
		mntmElimprov.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmElimprov);
		
		mntmConsultaprov.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/consulta48.png")));
		mntmConsultaprov.setBackground(new Color(255, 255, 255));
		mntmConsultaprov.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmConsultaprov);
		
		JMenuItem mntmNotaped = new JMenuItem("Nota de Pedidos");
		mntmNotaped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n=NotaPedidos.nota;
				try {
					if(n==null) {
						NotaPedidos nota=new NotaPedidos();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=nota.getSize();
						nota.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(nota);
						nota.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Notas Pedidos se encuentra abierto");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmNotaped.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Nuevo48.png")));
		mntmNotaped.setBackground(new Color(255, 255, 255));
		mntmNotaped.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmNotaped);
		
		JMenuItem mntmConsultaPed = new JMenuItem("Consulta Pedidos");
		mntmConsultaPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cped=ConsultaPe.cpe;
				try {
					if(cped==null) {
						ConsultaPe cpe=new ConsultaPe();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=cpe.getSize();
						cpe.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(cpe);
						cpe.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Pedidos se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmConsultaPed.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/consulta48.png")));
		mntmConsultaPed.setBackground(new Color(255, 255, 255));
		mntmConsultaPed.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProveedores.add(mntmConsultaPed);
		
		JMenu mnFacturacion = new JMenu("Facturaci\u00F3n");
		mnFacturacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnFacturacion.setForeground(new Color(255, 255, 255));
		menuBar.add(mnFacturacion);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String f=Facturar.fac;
				try {
					if(f==null) {
						Facturar fac=new Facturar();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=fac.getSize();
						fac.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(fac);
						fac.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Facturar se encuentra abierto");
					}
				} 
				    catch (Exception ex) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		mntmFacturar.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/facturar48.png")));
		mntmFacturar.setBackground(new Color(255, 255, 255));
		mntmFacturar.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnFacturacion.add(mntmFacturar);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta_Facturas");
		mntmConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String cf=ConsultaFactura.fact;
				try {
					if(cf==null) {
						ConsultaFactura fact=new ConsultaFactura();
						Dimension desktopSize=escritorio.getSize();
						Dimension FrameSize=fact.getSize();
						fact.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						escritorio.add(fact);
						fact.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana Consulta Facturas se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
		mntmConsulta_1.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/consulta48.png")));
		mntmConsulta_1.setBackground(new Color(255, 255, 255));
		mntmConsulta_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnFacturacion.add(mntmConsulta_1);
		
        //JMenu mnRedesSociales = new JMenu("Redes Sociales");
		mnRedesSociales.setFont(new Font("Tahoma", Font.PLAIN, 20));
		habilitar();
		mnRedesSociales.setForeground(new Color(255, 255, 255));
		menuBar.add(mnRedesSociales);
		
		JMenuItem mntmFacebook = new JMenuItem("Facebook");
		habilitar();
		mntmFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop=Desktop.getDesktop();
				
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://www.facebook.com/"));
					}
					catch(IOException e){
						e.printStackTrace();
					}
					catch(URISyntaxException e){
						
					}
				}
			   }
			}
		});
		mntmFacebook.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/face48.png")));
		mntmFacebook.setBackground(new Color(255, 255, 255));
		mntmFacebook.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnRedesSociales.add(mntmFacebook);
		
		JMenuItem mntmInstagram = new JMenuItem("Instagram");
		habilitar();
		mntmInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop=Desktop.getDesktop();
				
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://instagram.com/"));
					}
					catch(IOException b){
						b.printStackTrace();
					}
					catch(URISyntaxException b){
						
					}
				}
			   }
			}
		});
		mntmInstagram.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/insta48.png")));
		mntmInstagram.setBackground(new Color(255, 255, 255));
		mntmInstagram.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnRedesSociales.add(mntmInstagram);
		
		JMenuItem mntmGmail = new JMenuItem("Gmail");
		habilitar();
		mntmGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop=Desktop.getDesktop();
				
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://gmail.com/"));
					}
					catch(IOException c){
						c.printStackTrace();
					}
					catch(URISyntaxException c){
						
					}
				}
			   }
			}
		});
		mntmGmail.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/gmail48.png")));
		mntmGmail.setBackground(new Color(255, 255, 255));
		mntmGmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnRedesSociales.add(mntmGmail);
		
		JMenu mnAcerca = new JMenu("Acerca de ...");
		mnAcerca.setForeground(new Color(255, 255, 255));
		mnAcerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuBar.add(mnAcerca);
		
		JMenuItem mntmBulme = new JMenuItem("Bulme Soft");
		mntmBulme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String open=BulmeSoft.bul;
				try {
				if(open==null) {
					BulmeSoft bul=new BulmeSoft();
					Dimension desktopSize=escritorio.getSize();
					Dimension FrameSize=bul.getSize();
					bul.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
					escritorio.add(bul);
					bul.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Se encuentra abierta la ventana");
				}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al cargar la ventana");	
				}
			}
		});
		mntmBulme.setIcon(new ImageIcon(Sistema.class.getResource("/Imagenes/Bulme48.png")));
		mntmBulme.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnAcerca.add(mntmBulme);
		
	}
	public void habilitar() {
		String tipouser=Login.tipo;
		if(tipouser.equalsIgnoreCase("jefe")) {
	    mntmAltaUser.setEnabled(false);
	    mntmModifUser.setEnabled(false);
	    mntmElimUser.setEnabled(false);
	    mntmConsultaUser.setEnabled(false);
		mntmElimprod.setEnabled(false);
		mntmElimclie.setEnabled(false);
	    mntmElimprov.setEnabled(false);
	    mnRedesSociales.setEnabled(false);
		}
		else if(tipouser.equalsIgnoreCase("vendedor")) {
		mntmAltaUser.setEnabled(false);
		mntmModifUser.setEnabled(false);
		mntmElimUser.setEnabled(false);
		mntmConsultaUser.setEnabled(false);
		mntmAltaprod.setEnabled(false);
		mntmModprod.setEnabled(false); 
		mntmElimprod.setEnabled(false);
		mntmAltaprov.setEnabled(false);
		mntmModprov.setEnabled(false);
		mntmElimprov.setEnabled(false);
		mnRedesSociales.setEnabled(false);
		 
		}
	}

}
