import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.ComponentOrientation;

public class arnold extends JInternalFrame {
	public static String a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arnold frame = new arnold();
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
	public arnold() {
		getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		a="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				a=null;
			}
		});
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setBackground(new Color(0, 0, 102));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBounds(45, 49, 169, 168);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 102), new Color(0, 0, 102)));
		label.setIcon(new ImageIcon(arnold.class.getResource("/Imagenes/arn150.png")));
		label.setBounds(10, 9, 150, 150);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(246, 140, 412, 125);
		getContentPane().add(panel_1);
		
		JLabel lblEncargadaDelDiseo = new JLabel("Programador Junior respondable de la creaci\u00F3n ");
		lblEncargadaDelDiseo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblEncargadaDelDiseo.setBounds(31, 16, 360, 21);
		panel_1.add(lblEncargadaDelDiseo);
		
		JLabel lblDeLasVentanas = new JLabel("y manteniemiento de la Base de Datos.");
		lblDeLasVentanas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblDeLasVentanas.setBounds(49, 50, 313, 21);
		panel_1.add(lblDeLasVentanas);
		
		JLabel lblTengaUnaVista = new JLabel("Persona creativa e ideal para trabajar en equipo.");
		lblTengaUnaVista.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblTengaUnaVista.setBounds(31, 84, 360, 21);
		panel_1.add(lblTengaUnaVista);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(311, 41, 287, 60);
		getContentPane().add(panel_2);
		
		JLabel lblArnoldRodriguezEdad = new JLabel("Arnold Rodriguez, edad 19 a\u00F1os");
		lblArnoldRodriguezEdad.setForeground(new Color(0, 0, 0));
		lblArnoldRodriguezEdad.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		panel_2.add(lblArnoldRodriguezEdad);
		
		JLabel lblDiseografico = new JLabel("Programador Junior");
		panel_2.add(lblDiseografico);
		lblDiseografico.setForeground(new Color(0, 0, 0));
		lblDiseografico.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 704, 342);

	}

}
