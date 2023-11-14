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

public class camila extends JInternalFrame {
	public static String cam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camila frame = new camila();
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
	public camila() {
		cam="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				cam=null;
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
		label.setIcon(new ImageIcon(camila.class.getResource("/Imagenes/foto.png")));
		label.setBounds(10, 9, 150, 150);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(246, 140, 412, 125);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEncargadaDelDiseo = new JLabel("Responsable del dise\u00F1o general de cada una  ");
		lblEncargadaDelDiseo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblEncargadaDelDiseo.setBounds(44, 16, 329, 21);
		panel_1.add(lblEncargadaDelDiseo);
		
		JLabel lblDeLasVentanas = new JLabel("de las ventanas para que el programa  ");
		lblDeLasVentanas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblDeLasVentanas.setBounds(63, 50, 279, 21);
		panel_1.add(lblDeLasVentanas);
		
		JLabel lblTengaUnaVista = new JLabel("tenga una vista profesional y llamativa.");
		lblTengaUnaVista.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblTengaUnaVista.setBounds(54, 84, 291, 21);
		panel_1.add(lblTengaUnaVista);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(311, 41, 287, 60);
		getContentPane().add(panel_2);
		
		JLabel lblCamilaSerratoEdad = new JLabel("Camila Serrato, edad 23 a\u00F1os");
		panel_2.add(lblCamilaSerratoEdad);
		lblCamilaSerratoEdad.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblDiseografico = new JLabel("Dise\u00F1o Gr\u00E1fico");
		panel_2.add(lblDiseografico);
		lblDiseografico.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 704, 342);

	}
}
