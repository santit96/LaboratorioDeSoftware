package practica4;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListaColores {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaColores window = new ListaColores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaColores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel<Color> model= new DefaultListModel<Color>();
		frame.getContentPane().setLayout(null);
		ColorList list = new ColorList(model);
		list.setBounds(12, 65, 106, 148);
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, java.awt.Color.RED, java.awt.Color.RED, null, null));
		
		frame.getContentPane().add(list);
		
		textField = new JTextField();
		textField.setBounds(130, 102, 226, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(368, 81, 114, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
	
		    public void mouseClicked(MouseEvent e) {
		    	list.addElement(textField.getText());
		    	frame.repaint();
		    }
	    }
	    );
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(368, 118, 114, 25);
		frame.getContentPane().add(btnBorrar);
		
	}
}
