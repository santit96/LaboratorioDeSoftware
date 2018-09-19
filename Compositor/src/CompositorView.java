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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
import org.jfugue.player.Player;

import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JLayeredPane;

public class CompositorView {

	private JFrame frame;
	private JTextField input_1;
	private JTextField input_2;
   	private Player player;
	private Note selectedNote;
	private ArrayList<Note> usingNotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompositorView window = new CompositorView();
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
	public CompositorView() {
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
		
		player = new Player();
		usingNotes= new ArrayList<>();
		
		JLabel claveDeSol = new JLabel("");
		claveDeSol.setBounds(0, 0, 66, 89);
		frame.getContentPane().add(claveDeSol);
		claveDeSol.setHorizontalAlignment(SwingConstants.CENTER);
		claveDeSol.setIcon(new ImageIcon(CompositorView.class.getResource("/images/clavesol.png")));
		
		JLayeredPane pentagrama = new JLayeredPane();
		pentagrama.setBounds(0, 0, 450, 101);
		frame.getContentPane().add(pentagrama);
		
		StavesLine penta_1 = new StavesLine("G6");
		penta_1.setBounds(0, 5, 450, 12);
		pentagrama.add(penta_1);
		penta_1.setBorder(null);
		penta_1.setBackground(Color.WHITE);
		penta_1.setLayout(null);
		
		StavesLine penta_2 = new StavesLine("F6");
		penta_2.setBounds(0, 17, 450, 3);
		pentagrama.add(penta_2);
		penta_2.setBackground(Color.BLACK);
		penta_2.setLayout(null);
		
		StavesLine penta_3 = new StavesLine("E6");
		penta_3.setBounds(0, 20, 450, 12);
		pentagrama.add(penta_3);
		penta_3.setBorder(null);
		penta_3.setBackground(Color.WHITE);
		penta_3.setLayout(null);
		
		StavesLine penta_4 = new StavesLine("D6");
		penta_4.setBounds(0, 32, 450, 3);
		pentagrama.add(penta_4);
		penta_4.setBackground(Color.BLACK);
		penta_4.setLayout(null);
		
		StavesLine penta_5 = new StavesLine("C6");
		penta_5.setBounds(0, 35, 450, 12);
		pentagrama.add(penta_5);
		penta_5.setBorder(null);
		penta_5.setBackground(Color.WHITE);
		penta_5.setLayout(null);
		
		StavesLine penta_6 = new StavesLine("B");
		penta_6.setBounds(0, 47, 450, 3);
		pentagrama.add(penta_6);
		penta_6.setBackground(Color.BLACK);
		penta_6.setLayout(null);
		
		StavesLine penta_7 = new StavesLine("A");
		penta_7.setBounds(0, 50, 450, 12);
		pentagrama.add(penta_7);
		penta_7.setBorder(null);
		penta_7.setBackground(Color.WHITE);
		penta_7.setLayout(null);
		
		StavesLine penta_8 = new StavesLine("G");
		penta_8.setBounds(0, 62, 450, 3);
		pentagrama.add(penta_8);
		penta_8.setBackground(Color.BLACK);
		penta_8.setLayout(null);
		
		StavesLine penta_9 = new StavesLine("F");
		penta_9.setBounds(0, 65, 450, 12);
		pentagrama.add(penta_9);
		penta_9.setBorder(null);
		penta_9.setBackground(Color.WHITE);
		penta_9.setLayout(null);
		
		StavesLine penta_10 = new StavesLine("E");
		penta_10.setBounds(0, 77, 450, 3);
		pentagrama.add(penta_10);
		penta_10.setBackground(Color.BLACK);
		penta_10.setLayout(null);
		
		StavesLine penta_11 = new StavesLine("D");
		penta_11.setBounds(0, 80, 450, 12);
		pentagrama.add(penta_11);
		penta_11.setBorder(null);
		penta_11.setBackground(Color.WHITE);
		penta_11.setLayout(null);
		
		StavesLine penta_12 = new StavesLine("C");
		penta_12.setBounds(0, 92, 450, 3);
		pentagrama.add(penta_12);
		penta_12.setBackground(Color.WHITE);
		penta_12.setLayout(null);
		
		JLabel undo = new JLabel("");
		undo.setIcon(new ImageIcon(CompositorView.class.getResource("/images/undo.png")));
		undo.setBounds(365, 178, 30, 30);
		frame.getContentPane().add(undo);
		
		input_1 = new JTextField();
		input_1.setEnabled(false);
		input_1.setBounds(49, 178, 215, 24);
		frame.getContentPane().add(input_1);
		input_1.setColumns(10);
		
		input_2 = new JTextField();
		input_2.setBounds(86, 233, 215, 24);
		frame.getContentPane().add(input_2);
		input_2.setColumns(10);
		
		JPanel notes = new JPanel();
		notes.setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));
		notes.setBounds(49, 108, 349, 58);
		frame.getContentPane().add(notes);

		Note redonda = new Note('w');
		notes.add(redonda);
		redonda.setImage("/images/redonda.png");
		
		Note blanca = new Note('h');
		notes.add(blanca);
		blanca.setImage("/images/blanca.png");
		
		Note negra = new Note('q');
		notes.add(negra);
		negra.setImage("/images/negra.png");
		
		Note corchea = new Note('i');
		notes.add(corchea);
		corchea.setImage("/images/corchea.png");
		
		Note semicorchea = new Note('s');
		notes.add(semicorchea);
		semicorchea.setImage("/images/semicorchea.png");
		
		Note fusa = new Note('t');
		notes.add(fusa);
		fusa.setImage("/images/fusa.png");
		
		Note semifusa = new Note('x');
		notes.add(semifusa);
		semifusa.setImage("/images/semifusa.png");
		
		JLabel play_1 = new JLabel("");
		play_1.setIcon(new ImageIcon(CompositorView.class.getResource("/images/play.png")));
		play_1.setBounds(275, 169, 43, 39);
		frame.getContentPane().add(play_1);
		
		JLabel play_2 = new JLabel("");
		play_2.setIcon(new ImageIcon(CompositorView.class.getResource("/images/play.png")));
		play_2.setBounds(316, 225, 32, 32);
		frame.getContentPane().add(play_2);
		
		JLabel clean = new JLabel("");
		clean.setIcon(new ImageIcon(CompositorView.class.getResource("/images/escoba.png")));
		clean.setBounds(319, 169, 32, 32);
		frame.getContentPane().add(clean);
		
		notes.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{redonda, blanca, semicorchea, negra, fusa, semifusa, corchea}));

		for (Component note : notes.getComponents()) {
		     note.addMouseListener(new MouseAdapter() {
				
			    public void mouseClicked(MouseEvent e) {
			    	((Note) note).toggleSelected();
				    if (((Note) note).isSelected()) {
				    	if (selectedNote!= null)
				    		selectedNote.toggleSelected();
				    	selectedNote=(Note) note;
				    }
				    else
			            selectedNote=null;
			    }
		    }
		    );
		}
		
		for (Component stavesLine : pentagrama.getComponents()) {
		     stavesLine.addMouseListener(new MouseAdapter() {
				
			    public void mouseClicked(MouseEvent e) {
			    	if (selectedNote!= null) {
				    	Note noteCopy= new Note(((StavesLine) stavesLine).getNote(),selectedNote.getValue());
				    	noteCopy.setImage(selectedNote.getImageURL());
				    	pentagrama.setLayer(noteCopy, 1);
				    	int x;
				    	if (usingNotes.isEmpty())
				    		x=50;
				    	else
				    		x=usingNotes.get(0).getX()+30;
				        noteCopy.setBounds(x,(stavesLine.getY()-25), selectedNote.getWidth(), selectedNote.getHeight());
				    	pentagrama.add(noteCopy);
				    	usingNotes.add(0,noteCopy);
				    	input_1.setText(input_1.getText()+" "+ noteCopy.getNote()+noteCopy.getValue());
				    	
				    }
				    			            
			    }
		    }
		    );
		}
		
        play_2.addMouseListener(new MouseAdapter() {
		
		    public void mouseClicked(MouseEvent e) {
			    player.play(input_2.getText());	
		    
		    }
	    }
	    );
        
        play_1.addMouseListener(new MouseAdapter() {
    		
		    public void mouseClicked(MouseEvent e) {
			    player.play(input_1.getText());	
		    
		    }
	    }
	    );
        
        undo.addMouseListener(new MouseAdapter() {
    		
		    public void mouseClicked(MouseEvent e) {
			    if (!usingNotes.isEmpty()) {
		    	  Note last=usingNotes.get(0);
		    	  int indexNote=input_1.getText().lastIndexOf(last.getNote()+last.getValue());
		    	  input_1.setText(input_1.getText().substring(0,indexNote));
		    	  pentagrama.remove(last);
		    	  pentagrama.repaint();
			      usingNotes.remove(0);
			      
			    }
		    }
	    }
	    );
        
        clean.addMouseListener(new MouseAdapter() {
    		
		    public void mouseClicked(MouseEvent e) {
		    	  input_1.setText("");
		    	  for (Component note : usingNotes) {
		    		  pentagrama.remove(note);
		    	  }
		    	  pentagrama.repaint();
			      usingNotes.clear();

			}
		    
	    }
	    );
   
	}
}
