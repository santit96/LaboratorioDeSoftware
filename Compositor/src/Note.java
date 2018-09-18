import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Note extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String note;
	private char value;
	private boolean selected;

    Note(String note, char value){
        super("");
        this.setValue(value);
        this.setNote(note);
        this.setSelected(false);
    }
    
    public String getNote() {
		return note;
	}
	public void setNote(String note2) {
		this.note = note2;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void toggleSelected() {

		if (this.isSelected())
		    this.setBorder(null);
		else
		    this.setBorder(new LineBorder(Color.BLUE));
		
		this.setSelected(!this.isSelected());
	}
}
