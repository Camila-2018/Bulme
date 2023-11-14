import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;

public class profe1 extends JInternalFrame {
	public static String p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profe1 frame = new profe1();
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
	public profe1() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		p1="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				p1=null;
			}
		});
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setBackground(new Color(0, 0, 102));
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(72, 49, 170, 172);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(profe1.class.getResource("/Imagenes/profe1150x150.png")));
		lblNewLabel.setBounds(10, 11, 150, 150);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(124, 255, 403, 163);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblResponsableDeDirigir = new JLabel("Responsable de dirigir la ");
		lblResponsableDeDirigir.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblResponsableDeDirigir.setBounds(98, 66, 216, 25);
		panel_2.add(lblResponsableDeDirigir);
		
		JLabel lblLaProgramacionDel = new JLabel("Programaci\u00F3n de este proyecto.");
		lblLaProgramacionDel.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblLaProgramacionDel.setBounds(72, 102, 266, 25);
		panel_2.add(lblLaProgramacionDel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 102, 102));
		panel_3.setBounds(26, 20, 350, 28);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblProfesoraMariaEmila = new JLabel("Profesora Maria Emila Cuello");
		lblProfesoraMariaEmila.setForeground(Color.WHITE);
		lblProfesoraMariaEmila.setBounds(39, 0, 276, 26);
		lblProfesoraMariaEmila.setFont(new Font("Mongolian Baiti", Font.ITALIC, 22));
		panel_3.add(lblProfesoraMariaEmila);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(331, 34, 260, 199);
		getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(profe1.class.getResource("/Imagenes/Programacion.png")));
		label_1.setBounds(10, 10, 240, 180);
		panel_1.add(label_1);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 679, 472);

	}
}
