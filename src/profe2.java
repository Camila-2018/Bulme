import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class profe2 extends JInternalFrame {
	public static String p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profe2 frame = new profe2();
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
	public profe2() {
		p2="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				p2=null;
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
		
		JLabel label = new JLabel("");
		label.setBounds(9, 11, 150, 150);
		panel.add(label);
		label.setIcon(new ImageIcon(profe2.class.getResource("/Imagenes/R150.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(124, 255, 403, 163);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblResponsableDeDirigir = new JLabel("Responsable de dirigir la ");
		lblResponsableDeDirigir.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblResponsableDeDirigir.setBounds(96, 66, 251, 25);
		panel_2.add(lblResponsableDeDirigir);
		
		JLabel lblPlasmadoEnEste = new JLabel("Base de Datos de este proyecto");
		lblPlasmadoEnEste.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblPlasmadoEnEste.setBounds(75, 102, 272, 25);
		panel_2.add(lblPlasmadoEnEste);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 102, 102));
		panel_3.setBounds(26, 20, 350, 28);
		panel_2.add(panel_3);
		
		JLabel lblProfesoraRosanaBustamante = new JLabel("Profesora Rosana Bustamante");
		lblProfesoraRosanaBustamante.setForeground(Color.WHITE);
		lblProfesoraRosanaBustamante.setFont(new Font("Mongolian Baiti", Font.ITALIC, 22));
		lblProfesoraRosanaBustamante.setBounds(42, 0, 272, 26);
		panel_3.add(lblProfesoraRosanaBustamante);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(331, 34, 260, 199);
		getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(profe2.class.getResource("/Imagenes/BaseDatos.png")));
		label_1.setBounds(10, 10, 240, 180);
		panel_1.add(label_1);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 679, 472);

	}

}
