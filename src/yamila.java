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

public class yamila extends JInternalFrame {
	public static String y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yamila frame = new yamila();
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
	public yamila() {
		y="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				y=null;
			}
		});
		getContentPane().setBackground(new Color(0, 0, 102));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 704, 342);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBounds(45, 49, 169, 168);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 102), new Color(0, 0, 102)));
		label.setIcon(new ImageIcon(yamila.class.getResource("/Imagenes/y150.png")));
		label.setBounds(9, 9, 150, 150);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(246, 126, 420, 160);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEncargadaDelDiseo = new JLabel("Responsable de comunicar determinados mensajes,");
		lblEncargadaDelDiseo.setBounds(22, 20, 379, 21);
		lblEncargadaDelDiseo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		panel_1.add(lblEncargadaDelDiseo);
		
		JLabel lblDeLasVentanas = new JLabel("adaptar los cambios y adjuntar la informaci\u00F3n.");
		lblDeLasVentanas.setBounds(30, 53, 354, 21);
		lblDeLasVentanas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		panel_1.add(lblDeLasVentanas);
		
		JLabel lblTengaUnaVista = new JLabel("Adem\u00E1s responsable del dise\u00F1o y cooperaci\u00F3n en la");
		lblTengaUnaVista.setBounds(17, 88, 379, 21);
		lblTengaUnaVista.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		panel_1.add(lblTengaUnaVista);
		
		JLabel lblDelDiseoY = new JLabel("estructura del logo.");
		lblDelDiseoY.setBounds(122, 120, 158, 21);
		lblDelDiseoY.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		panel_1.add(lblDelDiseoY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(311, 41, 287, 60);
		getContentPane().add(panel_2);
		
		JLabel lblYamilaCordobaEdad = new JLabel("Yamila Cordoba, edad 18 a\u00F1os");
		lblYamilaCordobaEdad.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		panel_2.add(lblYamilaCordobaEdad);
		
		JLabel lblDiseografico = new JLabel("Dise\u00F1o Gr\u00E1fico");
		panel_2.add(lblDiseografico);
		lblDiseografico.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));

	}

}
