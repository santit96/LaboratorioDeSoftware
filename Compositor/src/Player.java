import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JToolBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JLayeredPane;

public class Player {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player window = new Player();
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
	public Player() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.BLUE);
		layeredPane.setBounds(0, 0, 450, 101);
		frame.getContentPane().add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 5, 66, 89);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/clavesol.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 5, 450, 12);
		layeredPane.add(panel_1);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 17, 450, 3);
		layeredPane.add(panel_2);
		panel_2.setBackground(Color.BLACK);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 20, 450, 12);
		layeredPane.add(panel_3);
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 32, 450, 3);
		layeredPane.add(panel_4);
		panel_4.setBackground(Color.BLACK);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 35, 450, 12);
		layeredPane.add(panel_5);
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 47, 450, 3);
		layeredPane.add(panel_6);
		panel_6.setBackground(Color.BLACK);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 50, 450, 12);
		layeredPane.add(panel_7);
		panel_7.setBorder(null);
		panel_7.setBackground(Color.WHITE);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 62, 450, 3);
		layeredPane.add(panel_8);
		panel_8.setBackground(Color.BLACK);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 65, 450, 12);
		layeredPane.add(panel_9);
		panel_9.setBorder(null);
		panel_9.setBackground(Color.WHITE);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 77, 450, 3);
		layeredPane.add(panel_10);
		panel_10.setBackground(Color.BLACK);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 80, 450, 12);
		layeredPane.add(panel_11);
		panel_11.setBorder(null);
		panel_11.setBackground(Color.WHITE);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 92, 450, 3);
		layeredPane.add(panel_12);
		panel_12.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/undo.png"));
		label.setBounds(365, 178, 30, 30);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(49, 178, 215, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 233, 215, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));
		panel.setBounds(49, 108, 349, 58);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/redonda.png"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/blanca.png"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/semicorchea.png"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/negra.png"));
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		label_1.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/fusa.png"));
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		label_2.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/semifusa.png"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/corchea.png"));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_2, lblNewLabel_3, lblNewLabel_6, lblNewLabel_4, label_1, label_2, lblNewLabel_5}));
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/play.png"));
		label_3.setBounds(275, 169, 32, 32);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/play.png"));
		label_4.setBounds(316, 225, 32, 32);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("/home/santi/Documentos/Facultad/Laboratorio-de-software/Imágenes para el compositor/escoba.png"));
		label_5.setBounds(319, 169, 32, 32);
		frame.getContentPane().add(label_5);
	}
}
