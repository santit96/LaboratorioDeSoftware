package laboratorio.gui;
import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

public class CatalogoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private int sortCol = -1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoJFrame frame = new CatalogoJFrame();
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

	
	public CatalogoJFrame() {
		setTitle("Buscador de Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 744);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 24, 1172, 171);
		panel.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(32, 53, 127, 28);
		panel.add(lblGenero);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"Acción", "Ciencia Ficción", "Comedia", "Drama", "Fantasía", "Musical", "Romance", "Suspenso"}));
		comboBoxGenero.setBounds(92, 55, 151, 24);
		panel.add(comboBoxGenero);
		
		JLabel lblCalidad = new JLabel("Clasificacion:");
		lblCalidad.setBounds(325, 53, 127, 28);
		panel.add(lblCalidad);
		
		JComboBox comboBoxCalidad = new JComboBox();
		comboBoxCalidad.setBounds(421, 55, 97, 24);
		comboBoxCalidad.setModel(new DefaultComboBoxModel(new String[] {"ATP", "+13", "+16", "+18"}));
		panel.add(comboBoxCalidad);
		
		JLabel lblPunt = new JLabel("Valoracion:");
		lblPunt.setBounds(586, 53, 127, 28);
		panel.add(lblPunt);
		
		JComboBox comboBoxPunt = new JComboBox();
		comboBoxPunt.setBounds(666, 55, 97, 24);
		comboBoxPunt.setModel(new DefaultComboBoxModel(new String[] {"0.0 - 2.0", "2.0 - 4.0", "4.0 - 7.0", "7.0 - 10.0"}));
		panel.add(comboBoxPunt);
		
		JLabel lblRep = new JLabel("Reproducciones:");
		lblRep.setBounds(855, 53, 127, 28);
		panel.add(lblRep);
		
		JComboBox comboBoxRep = new JComboBox();
		comboBoxRep.setBounds(976, 55, 97, 24);
		comboBoxRep.setModel(new DefaultComboBoxModel(new String[] {"10 <", "10 - 99", "100 - 499", "500 - 1000", "> 1000"}));
		panel.add(comboBoxRep);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setBounds(32, 106, 1117, 46);
		panel.add(btnNewButton);
		
		JPanel panelGrilla = new JPanel();
		panelGrilla.setBounds(12, 206, 1172, 489);
		panelGrilla.setBorder(new TitledBorder(null, "Peliculas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelGrilla);
		panelGrilla.setLayout(null);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(55, 46, 1044, 380);
		table.setModel(new AbstractTableModel() {
			

			private static final long serialVersionUID = 1L;
			String[] columnNames =new String[] {
					"Titulo", "Pais", "Año", "Genero", "Clasificacion", "Valoracion", "Reproducciones"};
			
		    public String getColumnName(int col) {
		    	String str = columnNames[col];
		    	if ((col == sortCol) && (col < 2))
		    		 str ="<< "+str+" >>";
		    	return str;
		    }
	
		    // COMPLETAR para devolver la cantidad de filas
		    public int getRowCount() { return 10; }
		    public int getColumnCount() { return columnNames.length; }
		    
		    // COMPLETAR este metodo para llenar la tabla
		    public Object getValueAt(int row, int col) {
		    	 return "COMPLETAR";
		    }
		    public boolean isCellEditable(int row, int col)
		        { return false; }
		    
		   
		});
		
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(37);
		
			
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 33, 1114, 408);
		panelGrilla.add(scrollPane);
	
		
	}
}
