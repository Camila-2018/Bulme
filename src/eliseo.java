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

public class eliseo extends JInternalFrame {
	public static String el;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eliseo frame = new eliseo();
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
	public eliseo() {
		el="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				el=null;
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
		label.setIcon(new ImageIcon(eliseo.class.getResource("/Imagenes/eli150.png")));
		label.setBounds(10, 9, 150, 150);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(300, 41, 322, 60);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEliseoLedezmaGomes = new JLabel("Eliseo Ledezma Gomez, edad 19 a\u00F1os ");
		lblEliseoLedezmaGomes.setBounds(16, 10, 296, 23);
		panel_1.add(lblEliseoLedezmaGomes);
		lblEliseoLedezmaGomes.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblDiseografico = new JLabel("Programador Junior");
		lblDiseografico.setBounds(67, 33, 172, 22);
		panel_1.add(lblDiseografico);
		lblDiseografico.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(246, 140, 412, 125);
		getContentPane().add(panel_1_1);
		
		JLabel lblEncargadaDelDiseo = new JLabel("Programador Junior responsable de la B\u00FAsqueda e ");
		lblEncargadaDelDiseo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblEncargadaDelDiseo.setBounds(18, 16, 379, 21);
		panel_1_1.add(lblEncargadaDelDiseo);
		
		JLabel lblDeLasVentanas = new JLabel("incorporaci\u00F3n de nuevos m\u00E9todos para la ejecuci\u00F3n");
		lblDeLasVentanas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblDeLasVentanas.setBounds(18, 50, 379, 21);
		panel_1_1.add(lblDeLasVentanas);
		
		JLabel lblTengaUnaVista = new JLabel("del programa y un funcionamiento mas eficaz ");
		lblTengaUnaVista.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblTengaUnaVista.setBounds(38, 84, 340, 21);
		panel_1_1.add(lblTengaUnaVista);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 704, 342);

	}

}
