

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;        // Using AWT containers and components
import java.awt.event.*;  // Using AWT events classes and listener interfaces
import java.lang.*;
import java.util.Arrays;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class Menu extends Frame
      implements ActionListener, WindowListener {
   private Button price ;
   private Button time ;
   private Button route ;
   private Button sort;
   private Button admin;
   private TextArea info;
   private boolean lastie;
   private int firstStation;
   private int secondStation;
   // Constructor to setup the GUI components and event handlers
   public Menu(boolean last,int first,int second) {
      lastie = last;
      firstStation = first; 
      secondStation = second;
      setLayout(new FlowLayout());
      price = new Button("Price");
      add(price);                   
      time = new Button("Time");
      add(time);
      route = new Button("Route");
      add(route);
      sort = new Button("Sort");
      add(sort);
      admin = new Button("Admin");
      add(admin);
      info = new TextArea(10, 30);
      info.setEditable(false);
      add(info);
      route.addActionListener(this);
      sort.addActionListener(this);
      price.addActionListener(this);
      time.addActionListener(this);
      admin.addActionListener(this);
      addWindowListener(this);
      setTitle("Menu");
      setSize(350, 250);
      setVisible(true);
   
    }
   // The entry main() method
   public static void main(boolean last,int firstStation,int secondStation) {
      new Menu(last,firstStation,secondStation);  // Let the construct do the job
   }
  
 
   /* ActionEvent handler */
   
   public void actionPerformed(ActionEvent evt) {
       switch (evt.getActionCommand())
       {
           case "Price" : priceing();
           break;
           case "Time" : timing();
           break;
           case "Route" : routing();
           break;
           case "Sort" : sorting();
           break;
           case "Admin" : admining();
           break;
        }
   }
 
   /* WindowEvent handlers */
   // Called back upon clicking close-window button
   @Override
   public void windowClosing(WindowEvent evt) {
     setVisible(false); //you can't see me!
     dispose();  // Terminate the program
   }
   
   public void priceing() {
       String input = "";
       if (lastie == true) {
           input = "It is the last day of the month \n";
           input += "The price of a single ticket is " + (Routes.routesArray[firstStation][secondStation].getSingleCost() * 0.9) + "\n";
           input += "The price of a return ticket is " + (Routes.routesArray[firstStation][secondStation].getReturnCost()* 0.9) + "\n";
        }
        else 
        {
            input = "It is not the last day of the month \n";
            input += "The price of a single ticket is " + Routes.routesArray[firstStation][secondStation].getSingleCost() + "\n";
            input += "The price of a return ticket is " + Routes.routesArray[firstStation][secondStation].getReturnCost() + "\n";
        }
        info.setText(input);
    }
    public void timing() 
    {
        info.setText("The time it will take to go to \n Your destination is " + (Math.floor(Routes.routesArray[firstStation][secondStation].getTime() / 60) ) + " Hours \n" + (Routes.routesArray[firstStation][secondStation].getTime() % 60 ) + " Minutes");
    }
    public  void routing()
    {
        String output = "The stops between the two stations are \n";
        for(int i = 0;i<10;i++)
        {
            String returned = Routes.routesArray[firstStation][secondStation].getArray(i);
            if (returned == null)
            {
                break;
            }
            else 
            {
                output += (i+1) + ". " + returned + "\n";
            }
        }
        info.setText(output); 
    }
    
    public  void sorting() 
    {
        String output = "The stops between the two stations \n in alphabetacal order are \n";
        int length = 0; 
        for (int i = 0 ; i<10 ; i++)
        {
         String returned = Routes.routesArray[firstStation][secondStation].getArray(i);
            if (returned == null)
            {
                length = i;
                break;
            }
        }
        String[] ordering = new String[length];
         for (int j = 0 ; j<length ; j++)
        {
         String returned = Routes.routesArray[firstStation][secondStation].getArray(j);
            if (returned == null)
            {
                break;
            }
            else 
            {
                ordering[j] = returned;
            }
        }
         java.util.Arrays.sort(ordering);
        for (int k = 0 ; k<length ; k++)
        {
         String returned = ordering[k];
         output += (k + 1) + ". " + returned + "\n"; 
        }
        info.setText(output);
    }
    public  void admining()
    {
        Admin.main();
    }


   
 
   // Not Used, but need to provide an empty body to compile.
   @Override public void windowOpened(WindowEvent evt) { }
   @Override public void windowClosed(WindowEvent evt) { }
   @Override public void windowIconified(WindowEvent evt) { }
   @Override public void windowDeiconified(WindowEvent evt) { }
   @Override public void windowActivated(WindowEvent evt) { }
   @Override public void windowDeactivated(WindowEvent evt) { }

}