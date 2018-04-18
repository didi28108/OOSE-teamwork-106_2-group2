package view;
//http://www.java2s.com/Tutorial/Java/0260__Swing-Event/CustomDocumentFilter.htm

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class IntegerRangeDocumentFilter extends DocumentFilter{
	public IntegerRangeDocumentFilter() {

	  }

	  public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
	      AttributeSet attr) throws BadLocationException {
	    System.out.println("insert string"+ string);
	    System.out.println(offset);
	    super.insertString(fb, offset, string, attr);
	  }

	  public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
	      throws BadLocationException {
	    System.out.println("remove");

	    
	    super.remove(fb, offset, length);
	  }

	  public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
	      AttributeSet attrs) throws BadLocationException {
	    System.out.println("replace");
	    super.replace(fb, offset, length, text, attrs);
	  }
}
