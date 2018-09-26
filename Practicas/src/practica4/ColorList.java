package practica4;


import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class ColorList extends JList<Color> {
    DefaultListModel<Color> model;
	public ColorList(DefaultListModel<Color> model) {
		super(model);
		this.model=model;
		this.setCellRenderer(new ColorListRenderer());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public void addElement(String imageUrl) {
		Color color=new Color(imageUrl);
		//color.setBounds(0, 0, 30, 30);
		model.addElement(color);
		this.repaint();
	}
	
	public class ColorListRenderer extends DefaultListCellRenderer {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(new ImageIcon(ListaColores.class.getResource("/verde.png")));
            label.setText("");
            return label;
        }
    }
}
