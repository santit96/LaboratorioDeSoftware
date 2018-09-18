import javax.swing.JPanel;

public class StavesLine extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String note;
	
	StavesLine(String note){
		super();
		this.setNote(note);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
