
/**
 * Write a description of class errorMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class errorMessage {

  public static void main(String error) {
    final JPanel panel = new JPanel();

    JOptionPane.showMessageDialog(panel, error , "Error", JOptionPane.ERROR_MESSAGE);

  }
}
