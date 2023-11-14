import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class leonardo extends JInternalFrame {
	public static String l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leonardo frame = new leonardo();
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
	public leonardo() {
		l="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				l=null;
			}
		});
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setBackground(new Color(0, 0, 102));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(45, 49, 169, 168);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 102), new Color(0, 0, 102)));
		label.setBounds(10, 9, 150, 150);
		panel.add(label);
		label.setIcon(new ImageIcon(leonardo.class.getResource("/Imagenes/leo150.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 102, 102), new Color(255, 102, 102)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(312, 36, 287, 60);
		getContentPane().add(panel_2);
		
		JLabel lblLeonardoRoldanEdad = new JLabel("Leonardo Roldan, edad 26 a\u00F1os");
		lblLeonardoRoldanEdad.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		panel_2.add(lblLeonardoRoldanEdad);
		
		JLabel lblDiseografico = new JLabel("Programador Junior ");
		panel_2.add(lblDiseografico);
		lblDiseografico.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(246, 120, 420, 170);
		getContentPane().add(panel_1);
		
		JLabel lblEncargadaDelDiseo = new JLabel("Programador Junior con conocimientos avanzados ");
		lblEncargadaDelDiseo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblEncargadaDelDiseo.setBounds(22, 11, 380, 21);
		panel_1.add(lblEncargadaDelDiseo);
		
		JLabel lblDeLasVentanas = new JLabel("en plataforma Linux. Responsable de codificar el");
		lblDeLasVentanas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblDeLasVentanas.setBounds(30, 43, 363, 21);
		panel_1.add(lblDeLasVentanas);
		
		JLabel lblTengaUnaVista = new JLabel(" software para que se adapte a distintas plataformas.");
		lblTengaUnaVista.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblTengaUnaVista.setBounds(17, 75, 387, 21);
		panel_1.add(lblTengaUnaVista);
		
		JLabel lblYResponsableDel = new JLabel("Ademas responsable del dise\u00F1o y cooperacion ");
		lblYResponsableDel.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblYResponsableDel.setBounds(34, 107, 353, 21);
		panel_1.add(lblYResponsableDel);
		
		JLabel lblDelDiseoDel = new JLabel("en la estructura del logo");
		lblDelDiseoDel.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
		lblDelDiseoDel.setBounds(108, 133, 203, 31);
		panel_1.add(lblDelDiseoDel);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 704, 342);

	}
}
