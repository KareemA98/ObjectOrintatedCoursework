
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;        // Using AWT containers and components
import java.awt.event.*;  // Using AWT events classes and listener interfaces
import java.lang.*;
import java.util.*;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class WindowEventDemo extends Frame
      implements ActionListener, WindowListener {
 
   private Choice days;
   private Button btnCount;
   private Label firstDestination;
   private Choice firstChoice;
   private Choice secondChoice;
   private Choice month;
   private TextField year;
   private boolean lastDayOfMonth = false;
 
   // Constructor to setup the GUI components and event handlers
   public WindowEventDemo() {
      setLayout(new FlowLayout()); // "super" Frame sets to FlowLayout
 
      add(new Label("Select The First Destination",Label.LEFT));   // "super" Frame adds an anonymous Label
      firstChoice = new Choice();
      firstChoice.add("Leicester");
      firstChoice.add("Loughborough");
      firstChoice.add("Nottingham");
      firstChoice.add("Derby");
      firstChoice.add("York");
      add(firstChoice);
      add(new Label("Select The Second Destination",Label.LEFT)); 
      secondChoice = new Choice();
      secondChoice.add("Leicester");
      secondChoice.add("Loughborough");
      secondChoice.add("Nottingham");
      secondChoice.add("Derby");
      secondChoice.add("York");
      add(secondChoice);
      add(new Label("Select The Month",Label.LEFT));
      month = new Choice();
      month.add("January");
      month.add("Febuary");
      month.add("March");
      month.add("April");
      month.add("May");
      month.add("June");
      month.add("July");
      month.add("Augest");
      month.add("September");
      month.add("October");
      month.add("November");
      month.add("December");
      add(month);
      add(new Label("Input The Day",Label.LEFT));
      createDays() ;
      add(days);
      add(new Label("Input The Year",Label.LEFT));
      year = new TextField("", 10);
      add(year);
      btnCount = new Button("Submit"); 
      add(btnCount);                  
 
      btnCount.addActionListener(this);

      addWindowListener(this);

 
      setTitle("Train Rider Express"); 
      setSize(350, 250);           
      setVisible(true);             
   
    }
   // The entry main() method
   public static void main() {
      new WindowEventDemo();  // Let the construct do the job
   }
  
 
   /* ActionEvent handler */
   
   public void actionPerformed(ActionEvent evt) {
       String years = year.getText();
       if (years.length() == 4 && checkInteger(years)) {
       int day = days.getSelectedIndex() + 1 ;
       if(firstChoice.getSelectedIndex() != secondChoice.getSelectedIndex())
       {
               switch (month.getSelectedIndex()) 
           {
                    case 0:case 2: case 4: case 6: case 7: case 9: case 11:
                    if (day == 31)
                    {
                        Menu.main(true,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex());
                    }
                    else 
                    {
                        Menu.main(false,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex()) ;
                    }
                    break;
                    case 3 : case 5: case 8: case 10:
                    if (day == 31)
                    {
                        errorMessage.main("Day is incorrect");
                    }
                    else if (day == 30)
                    {
                        Menu.main(true,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex());
                    }
                    else 
                    {
                        Menu.main(false,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex());
                    }
                    break;
                    case 1:
                     if (day == 31 || day == 30)
                     {
                         errorMessage.main("Day is incorrect");
                        }
                        else if (day == 28 || day == 29)
                        {
                            Menu.main(true,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex());
                        }
                        else
                        {
                            Menu.main(false,firstChoice.getSelectedIndex(),secondChoice.getSelectedIndex());
                        }
                    break;
            }
        }
        else 
        {
            errorMessage.main("The same stations have been picked"); 
        }
        }
        else 
        {
            errorMessage.main("The Year is incorrect");
        }
    }
   
 
   /* WindowEvent handlers */
   // Called back upon clicking close-window button
   @Override
   public void windowClosing(WindowEvent evt)
   {
     setVisible(false); //you can't see me!
     dispose();  // Terminate the program
   }
   public boolean checkInteger(String value) 
   {
     for (int  i = 0 ; i < value.length() ; i++ )
     {
         if(Character.digit(value.charAt(i),10) < 0) return false;
     }
     return true ;
    }
   public void createDays()
   {
       days = new Choice();
       days.add("1");
       days.add("2");
       days.add("3");
       days.add("4");
       days.add("5");
       days.add("6");
       days.add("7");
       days.add("8");
       days.add("9");
       days.add("10");
       days.add("11");
       days.add("12");
       days.add("13");
       days.add("14");
       days.add("15");
       days.add("16");
       days.add("17");
       days.add("18");
       days.add("19");
       days.add("20");
       days.add("21");
       days.add("22");
       days.add("23");
       days.add("24");
       days.add("25");
       days.add("26");
       days.add("27");
       days.add("28");
       days.add("29");
       days.add("30");
       days.add("31");
             
       
    }

   
 
   // Not Used, but need to provide an empty body to compile.
   @Override public void windowOpened(WindowEvent evt) { }
   @Override public void windowClosed(WindowEvent evt) { }
   @Override public void windowIconified(WindowEvent evt) { }
   @Override public void windowDeiconified(WindowEvent evt) { }
   @Override public void windowActivated(WindowEvent evt) { }
   @Override public void windowDeactivated(WindowEvent evt) { }

}