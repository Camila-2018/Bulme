import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class profe3 extends JInternalFrame {
	public static String p3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profe3 frame = new profe3();
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
	public profe3() {
		p3="Abierto";
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				dispose();
				p3=null;
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
		label.setIcon(new ImageIcon(profe3.class.getResource("/Imagenes/G150.png")));
		label.setBounds(10, 11, 150, 150);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(124, 255, 403, 163);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 102, 102));
		panel_3.setBounds(26, 20, 350, 28);
		panel_2.add(panel_3);
		
		JLabel lblProfesoraGiseleToledo = new JLabel("Profesora Gisele Toledo");
		lblProfesoraGiseleToledo.setForeground(Color.WHITE);
		lblProfesoraGiseleToledo.setFont(new Font("Mongolian Baiti", Font.ITALIC, 22));
		lblProfesoraGiseleToledo.setBounds(64, 0, 223, 26);
		panel_3.add(lblProfesoraGiseleToledo);
		
		JLabel lblResponsableDeDirigir = new JLabel("Responsable de dirigir el Ingl\u00E9s");
		lblResponsableDeDirigir.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblResponsableDeDirigir.setBounds(65, 66, 274, 25);
		panel_2.add(lblResponsableDeDirigir);
		
		JLabel lblPlasmadoEnEste = new JLabel("Plasmado en este proyecto");
		lblPlasmadoEnEste.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
		lblPlasmadoEnEste.setBounds(84, 102, 230, 25);
		panel_2.add(lblPlasmadoEnEste);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(331, 34, 260, 199);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 10, 240, 180);
		panel_1.add(label_1);
		label_1.setIcon(new ImageIcon(profe3.class.getResource("/Imagenes/Ingles.png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 679, 472);

	}
}
