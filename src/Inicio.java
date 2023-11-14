import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 700, 500));
		setTitle("Sistema de Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Imagenes/Bulme24.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//centrar la ventana
		Fondo f=new Fondo();//importar imagen de ventana fondo
		f.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(f);
		f.setLayout(null);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login c=new Login();
				c.setVisible(true);
				Inicio.this.dispose();
			}
		});
		btnSiguiente.setBounds(545, 378, 108, 56);
		f.add(btnSiguiente);
	}
}
