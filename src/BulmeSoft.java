import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.border.EtchedBorder;

public class BulmeSoft extends JInternalFrame {
	   public static String bul;
	   public static JDesktopPane escritorio=new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BulmeSoft frame = new BulmeSoft();
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
	public BulmeSoft() {
		bul="abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				bul=null;
			}
		});
		getContentPane().setBackground(new Color(0, 0, 102));
		setTitle("Bulme soft");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1003, 663);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/Bul.png")));
		lblNewLabel.setBounds(20, 106, 479, 302);
		getContentPane().add(lblNewLabel);
		
		JLabel lblBulmeSoft = new JLabel("Bulme soft");
		lblBulmeSoft.setForeground(new Color(255, 255, 255));
		lblBulmeSoft.setBackground(new Color(135, 206, 250));
		lblBulmeSoft.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 42));
		lblBulmeSoft.setBounds(386, 11, 189, 54);
		getContentPane().add(lblBulmeSoft);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(520, 87, 445, 335);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBulmeSoftO = new JLabel(" Bulme Soft \r\n");
		lblBulmeSoftO.setForeground(new Color(0, 102, 204));
		lblBulmeSoftO.setBounds(10, 9, 151, 27);
		panel.add(lblBulmeSoftO);
		lblBulmeSoftO.setFont(new Font("Sitka Text", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Es un Software que registra las ventas de muebles.");
		lblNewLabel_1.setBounds(10, 35, 411, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		
		JLabel lblLaIdeaSurgio = new JLabel("Las principales acciones son: Mantenimiento de  ");
		lblLaIdeaSurgio.setBounds(10, 59, 411, 20);
		panel.add(lblLaIdeaSurgio);
		lblLaIdeaSurgio.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Productos, Clientes, Proveedores y Facturacion.");
		lblNewLabel_2.setBounds(10, 80, 365, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		
		JLabel lblEsteProgramaSe = new JLabel("La idea surgi\u00F3 con el fin de ayudar a empresas ");
		lblEsteProgramaSe.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblEsteProgramaSe.setBounds(10, 109, 377, 20);
		panel.add(lblEsteProgramaSe);
		
		JLabel lblGrandesEmpresasDe = new JLabel("similares que necesitan hoy en dia tener un software ");
		lblGrandesEmpresasDe.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblGrandesEmpresasDe.setBounds(10, 127, 411, 27);
		panel.add(lblGrandesEmpresasDe);
		
		JLabel lblDeUnaBuena = new JLabel("que los ayude a controlar sus ventas.");
		lblDeUnaBuena.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblDeUnaBuena.setBounds(10, 151, 377, 20);
		panel.add(lblDeUnaBuena);
		
		JLabel lblLosProfesoresQue = new JLabel("Los profesores que nos ayudaron con el proyecto son:");
		lblLosProfesoresQue.setForeground(new Color(0, 102, 204));
		lblLosProfesoresQue.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblLosProfesoresQue.setBounds(10, 182, 421, 21);
		panel.add(lblLosProfesoresQue);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String pe=profe1.p1;
				try {
					if(pe==null) {
						profe1 p1=new profe1();
						Sistema.escritorio.add(p1);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=p1.getSize();
						p1.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						p1.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		button_4.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/profe190x90.png")));
		button_4.setBounds(39, 213, 90, 90);
		panel.add(button_4);
		
		JButton button_4_1 = new JButton("");
		button_4_1.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/R90.png")));
		button_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String prs=profe2.p2;
				try {
					if(prs==null) {
						profe2 p2=new profe2();
						Sistema.escritorio.add(p2);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=p2.getSize();
						p2.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						p2.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
	
		button_4_1.setBounds(171, 213, 90, 90);
		panel.add(button_4_1);
		
		JButton button_4_2 = new JButton("");
		button_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String pg=profe3.p3;
				try {
					if(pg==null) {
						profe3 p3=new profe3();
						Sistema.escritorio.add(p3);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=p3.getSize();
						p3.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						p3.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			
			}
		});
		button_4_2.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/G90.png")));
		button_4_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_4_2.setBounds(303, 213, 90, 90);
		panel.add(button_4_2);
		
		JLabel lblProfEmilia = new JLabel("Prof. Emilia");
		lblProfEmilia.setForeground(new Color(0, 0, 0));
		lblProfEmilia.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblProfEmilia.setBounds(39, 310, 89, 19);
		panel.add(lblProfEmilia);
		
		JLabel lblProfgisell = new JLabel("Prof.Rosana");
		lblProfgisell.setForeground(new Color(0, 0, 0));
		lblProfgisell.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblProfgisell.setBounds(171, 310, 89, 19);
		panel.add(lblProfgisell);
		
		JLabel lblProfRosana = new JLabel("Prof. Gisele");
		lblProfRosana.setForeground(new Color(0, 0, 0));
		lblProfRosana.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblProfRosana.setBounds(303, 310, 89, 19);
		panel.add(lblProfRosana);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String leo=leonardo.l;
				try {
					if(leo==null) {
						leonardo l=new leonardo();
						Sistema.escritorio.add(l);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=l.getSize();
						l.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						l.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/leo.png")));
		btnNewButton.setBounds(90, 478, 90, 90);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String cami=camila.cam;
				try {
					if(cami==null) {
						camila cam=new camila();
						Sistema.escritorio.add(cam);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=cam.getSize();
						cam.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						cam.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		button.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/foto90.png")));
		button.setBounds(262, 478, 90, 90);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String eli=eliseo.el;
				try {
					if(eli==null) {
						eliseo el=new eliseo();
						Sistema.escritorio.add(el);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=el.getSize();
						el.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						el.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		button_1.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/eliseo.png")));
		button_1.setBounds(436, 478, 90, 90);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String yami=yamila.y;
				try {
					if(yami==null) {
						yamila y=new yamila();
						Sistema.escritorio.add(y);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=y.getSize();
						y.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						y.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		button_2.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/yamila.png")));
		button_2.setBounds(614, 478, 90, 90);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String arno=arnold.a;
				try {
					if(arno==null) {
						arnold a=new arnold();
						Sistema.escritorio.add(a);
						Dimension desktopSize=Sistema.escritorio.getSize();
						Dimension FrameSize=a.getSize();
						a.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
						a.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "La ventana se encuentra abierto");
					}
				} 
				    catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error");
				}
			
			}
		});
		button_3.setIcon(new ImageIcon(BulmeSoft.class.getResource("/Imagenes/arnold.png")));
		button_3.setBounds(786, 478, 90, 90);
		getContentPane().add(button_3);
		
		JLabel lblLeonardoRoldan = new JLabel("Leonardo Roldan");
		lblLeonardoRoldan.setForeground(new Color(255, 255, 255));
		lblLeonardoRoldan.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblLeonardoRoldan.setBounds(79, 591, 142, 14);
		getContentPane().add(lblLeonardoRoldan);
		
		JLabel lblCamilaSerrato = new JLabel("Camila Serrato");
		lblCamilaSerrato.setForeground(new Color(255, 255, 255));
		lblCamilaSerrato.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblCamilaSerrato.setBounds(247, 591, 126, 14);
		getContentPane().add(lblCamilaSerrato);
		
		JLabel lblEliseoLedezma = new JLabel("Eliseo Ledesma");
		lblEliseoLedezma.setForeground(new Color(255, 255, 255));
		lblEliseoLedezma.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblEliseoLedezma.setBounds(422, 591, 126, 14);
		getContentPane().add(lblEliseoLedezma);
		
		JLabel lblYamilaCordoba = new JLabel("Yamila Cordoba");
		lblYamilaCordoba.setForeground(new Color(255, 255, 255));
		lblYamilaCordoba.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblYamilaCordoba.setBounds(601, 591, 126, 14);
		getContentPane().add(lblYamilaCordoba);
		
		JLabel lblArnoldRodriguez = new JLabel("Arnold Rodriguez");
		lblArnoldRodriguez.setForeground(new Color(255, 255, 255));
		lblArnoldRodriguez.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 16));
		lblArnoldRodriguez.setBounds(771, 591, 142, 14);
		getContentPane().add(lblArnoldRodriguez);
		
		JLabel lblLosCreadoresDe = new JLabel("Los desarrolladores de Bulme soft son:");
		lblLosCreadoresDe.setForeground(new Color(255, 255, 255));
		lblLosCreadoresDe.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 19));
		lblLosCreadoresDe.setBounds(28, 432, 375, 22);
		getContentPane().add(lblLosCreadoresDe);


	}

}
