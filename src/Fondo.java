import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Fondo extends javax.swing.JPanel {
			public Fondo() {
				this.setSize (300,300);
			}
			@Override
			public void paintComponent(Graphics g){
				Dimension tamanio=getSize();
				ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/Imagenes/Bulme Fondo.png")); 
				g.drawImage(imagenFondo.getImage(),0,0,tamanio.width,tamanio.height,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		}

	