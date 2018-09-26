package practica4;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Color extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color(String imagePath){
		super();
		this.setSize(30, 30);
		//this.setText(imagePath);
		this.setIcon(new ImageIcon(ListaColores.class.getResource(imagePath)));
	}

}
