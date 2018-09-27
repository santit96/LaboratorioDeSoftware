package laboratorio.gui;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import laboratorio.modelo.Buscador;
import laboratorio.modelo.ClasificacionEdad;
import laboratorio.modelo.Pelicula;
import laboratorio.modelo.Rango;
import laboratorio.modelo.RangoReproduccion;
import laboratorio.modelo.RangoValoracion;
import laboratorio.modelo.Genero;

public class CatalogoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private int sortCol = -1;
	private Buscador buscador;
	private ArrayList<Pelicula> catalogo;
	private ArrayList<Pelicula> catalogoFiltrado;

	
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
		this.buscador=new Buscador();
		this.catalogo=new ArrayList<Pelicula>();
		this.catalogoFiltrado=new ArrayList<Pelicula>();
		ArrayList<Genero> generos=new ArrayList<Genero>();
		generos.add(Genero.CIENCIA_FICCION);
		generos.add(Genero.COMEDIA);
		
		catalogo.add(new Pelicula("Volver al futuro",1985,"Estados Unidos",ClasificacionEdad.ATP,generos,34,(float) 8.9));
		catalogo.add(new Pelicula("Godzilla",1965,"Estados Unidos",ClasificacionEdad.Mayores13,generos,376,(float)7.1));
		catalogo.add(new Pelicula("El Angel",2018,"Argentina",ClasificacionEdad.ATP,generos,34,(float) 7.9));
		generos.clear();
		generos.add(Genero.DRAMA);
		generos.add(Genero.FANTASIA);
		generos.add(Genero.SUSPENSO);
		catalogo.add(new Pelicula("Siete Samurais",1977,"Japon",ClasificacionEdad.Mayores18,generos,111,(float) 6.3));
		catalogo.add(new Pelicula("The Room",2002,"Estados Unidos",ClasificacionEdad.Mayores16,generos,12,(float) 3.9));
		catalogo.add(new Pelicula("Salir al futuro",1985,"Estados Unidos",ClasificacionEdad.ATP,generos,34,(float) 8.9));
		catalogo.add(new Pelicula("Godzilla3",1965,"Estados Unidos",ClasificacionEdad.Mayores13,generos,376,(float)7.1));
		catalogo.add(new Pelicula("El Demonio",2013,"Argentina",ClasificacionEdad.ATP,generos,34,(float) 7.9));
		generos.clear();
		generos.add(Genero.DRAMA);
		generos.add(Genero.MUSICAL);
		generos.add(Genero.ROMANCE);
		catalogo.add(new Pelicula("Siete maestros",1977,"Japon",ClasificacionEdad.Mayores18,generos,111,(float) 6.3));
		catalogo.add(new Pelicula("The Disaster Artist",2002,"Finalandia",ClasificacionEdad.Mayores16,generos,10001,(float) 3.9));
		setTitle("Buscador de Peliculas");
		buscador.setPeliculas(catalogo);
		catalogoFiltrado.addAll(catalogo);
		
		
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
		comboBoxGenero.setModel(new DefaultComboBoxModel(new Genero[] {Genero.ACCION,Genero.CIENCIA_FICCION,Genero.COMEDIA,Genero.DRAMA,Genero.FANTASIA,Genero.MUSICAL,Genero.ROMANCE,Genero.SUSPENSO}));
		comboBoxGenero.setBounds(92, 55, 151, 24);
		panel.add(comboBoxGenero);
		
		JLabel lblCalidad = new JLabel("Clasificacion:");
		lblCalidad.setBounds(325, 53, 127, 28);
		panel.add(lblCalidad);
		
		JComboBox comboBoxCalidad = new JComboBox();
		comboBoxCalidad.setBounds(421, 55, 97, 24);
		comboBoxCalidad.setModel(new DefaultComboBoxModel(new ClasificacionEdad[] {ClasificacionEdad.ATP,ClasificacionEdad.Mayores13,ClasificacionEdad.Mayores16,ClasificacionEdad.Mayores18}));
		panel.add(comboBoxCalidad);
		
		JLabel lblPunt = new JLabel("Valoracion:");
		lblPunt.setBounds(586, 53, 127, 28);
		panel.add(lblPunt);
		
		JComboBox comboBoxPunt = new JComboBox();
		comboBoxPunt.setBounds(666, 55, 97, 24);
		comboBoxPunt.setModel(new DefaultComboBoxModel(new RangoValoracion[] { RangoValoracion.DE0A2, RangoValoracion.DE2A4, RangoValoracion.DE4A7, RangoValoracion.DE7A10}));
		panel.add(comboBoxPunt);
		
		JLabel lblRep = new JLabel("Reproducciones:");
		lblRep.setBounds(855, 53, 127, 28);
		panel.add(lblRep);
		
		JComboBox comboBoxRep = new JComboBox();
		comboBoxRep.setBounds(976, 55, 97, 24);
		comboBoxRep.setModel(new DefaultComboBoxModel(new RangoReproduccion[] {RangoReproduccion.MENORA10,RangoReproduccion.DE10A99,RangoReproduccion.DE100A499,RangoReproduccion.DE500A999,RangoReproduccion.MASDE1000}));
		panel.add(comboBoxRep);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setBounds(32, 106, 1117, 46);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent e) {
		    	catalogoFiltrado=(ArrayList<Pelicula>) buscador.seleccionar(((Genero) comboBoxGenero.getModel().getElementAt((comboBoxGenero.getSelectedIndex()))),(ClasificacionEdad) comboBoxCalidad.getModel().getElementAt(comboBoxCalidad.getSelectedIndex()),  ((RangoValoracion) comboBoxPunt.getModel().getElementAt((comboBoxPunt.getSelectedIndex()))).getRango(),((RangoReproduccion) comboBoxRep.getModel().getElementAt((comboBoxRep.getSelectedIndex()))).getRango() ,Buscador.defaultComparator);
		        table.repaint();
		    }
	    }
	    );
		
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
		    public int getRowCount() { return catalogoFiltrado.size(); }
		    public int getColumnCount() { return columnNames.length; }
		    
		    // COMPLETAR este metodo para llenar la tabla
		    public Object getValueAt(int row, int col) {
		    	switch (col){
		    	case 0: col=0;
		    	  return catalogoFiltrado.get(row).getTitle();
		    	case 1: col=1;
		    	  return catalogoFiltrado.get(row).getCountry();
		    	case 2: col=2;
		    	  return catalogoFiltrado.get(row).getYear();
		    	case 3: col=3;
		    	  return catalogoFiltrado.get(row).getGeneros();
		    	case 4: col=4;
		    	  return catalogoFiltrado.get(row).getAge_clasification();
		    	case 5: col=5;
		    	  return catalogoFiltrado.get(row).getAppreciation();
		    	case 6: col=6;
		    	  return catalogoFiltrado.get(row).getReproductions();
		    	}
				return null;  
		    	
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
