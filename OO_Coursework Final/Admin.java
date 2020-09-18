

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;        // Using AWT containers and components
import java.awt.event.*;  // Using AWT events classes and listener interfaces
import java.lang.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Object;
import java.io.*;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class Admin extends Frame
      implements ActionListener, WindowListener {
   private Button inputRoute ;
   private Button saveRoute ;
   private Button retrieveRoute ;
   private Choice firstChoice;
   private Choice secondChoice;
   private TextField newStation;
   private TextField addRoutes;
   private TextArea info;
   private char firstStation;
   private char secondStation;
   // Constructor to setup the GUI components and event handlers
   public Admin() {
      setLayout(new FlowLayout());           
      saveRoute = new Button("Save Route");
      add(saveRoute);
      addRoutes = new TextField("Enter the location of the file for retrieve route");
      add(addRoutes);
      retrieveRoute = new Button("Retrieve Route");
      add(retrieveRoute);
      newStation = new TextField("Enter Station", 10);
      add(newStation);
      firstChoice = new Choice();
      firstChoice.add("Leicester");
      firstChoice.add("Loughborough");
      firstChoice.add("Nottingham");
      firstChoice.add("Derby");
      firstChoice.add("York");
      add(firstChoice);
      secondChoice = new Choice();
      secondChoice.add("Leicester");
      secondChoice.add("Loughborough");
      secondChoice.add("Nottingham");
      secondChoice.add("Derby");
      secondChoice.add("York");
      add(secondChoice);
      inputRoute = new Button("Input Route");
      add(inputRoute);        
      inputRoute.addActionListener(this);
      saveRoute.addActionListener(this);
      retrieveRoute.addActionListener(this);
      addWindowListener(this);
      setTitle("Admin");
      setSize(400, 250);
      setVisible(true);
   
    }
   // The entry main() method
   public static void main() {
      new Admin();  // Let the construct do the job
   }
  
 
   /* ActionEvent handler */
   
   public void actionPerformed(ActionEvent evt) {
       switch (evt.getActionCommand())
       {
           case "Input Route" : inputRoute();
           break;
           case "Save Route" : saveRoute();
           break;
           case "Retrieve Route" : retrieveRoute();
           break;
        }
   }
   public void inputRoute()
   {
       if (firstChoice.getSelectedIndex() != secondChoice.getSelectedIndex())
       {
       for(int i =0; i< 10;i++)
       {
           String returned = Routes.routesArray[firstChoice.getSelectedIndex()][secondChoice.getSelectedIndex()].getArray(i);
         if(returned == null)
         {
             Routes.routesArray[firstChoice.getSelectedIndex()][secondChoice.getSelectedIndex()].setArray(i,newStation.getText());
             errorMessage.main("Station Added");
             break;
         }
       }
    }
    else 
    {
        errorMessage.main("Both Stations are the same");
    }
    }
    public void saveRoute()
    {
        File file = new File(System.getProperty("user.dir") + "/Saving.txt");
       try {
        FileWriter writer = new FileWriter(file);
        String output ="";
        for (int i = 0; i < 5; i++)
        {   for ( int j = 0; j < 5; j++)
            {
                if( j != i && Routes.routesArray[i][j].getArray(0) != null)
                {
                    output += "" + i + j + "";
                    for( int k = 0 ; k < 10 ; k++)
                    {
                        if(Routes.routesArray[i][j].getArray(k) == null)
                        {
                            output += ";" ;
                            break;
                        }
                        else
                        {
                            output += Routes.routesArray[i][j].getArray(k) + "," ;
                        }
                    }
                }
            }
        }
        writer.write(output); 
        writer.flush();
        writer.close();
        FileReader fr = new FileReader(file); 
        char [] a = new char[300];
        fr.read(a);  
        String s = new String(a);
        System.out.println(s);
        fr.close();
       }
       catch (IOException ex) 
       {
       }
    }
    
    public void retrieveRoute()
    {
        String filed = addRoutes.getText();
        File file = new File(System.getProperty("user.dir") + filed);
        try
        {
        
        FileReader fr = new FileReader(filed); 
        BufferedReader br = new BufferedReader(fr); 
        
        String s = br.readLine();
        if(s != "")
        {
            String[] part = s.split(";");
            for(int i = 0 ; i < part.length ; i++)
            {
                firstStation = part[i].charAt(0);
                secondStation = part[i].charAt(1);
                String[] tips = part[i].substring(2).split(",");
                for(int j = 0 ; j < tips.length ; j++ )
                {
                    if(tips[j] != "")
                    {
                        Routes.routesArray[Character.getNumericValue(firstStation)][Character.getNumericValue(secondStation)].setArray(j,tips[j]);
                    }
                }
            }
        }
        }
        catch(IOException ex)
        {
        }
    }
        
    
 
   /* WindowEvent handlers */
   // Called back upon clicking close-window button
   @Override
   public void windowClosing(WindowEvent evt) {
     setVisible(false); //you can't see me!
     dispose();  // Terminate the program
   }
   


   
 
   // Not Used, but need to provide an empty body to compile.
   @Override public void windowOpened(WindowEvent evt) { }
   @Override public void windowClosed(WindowEvent evt) { }
   @Override public void windowIconified(WindowEvent evt) { }
   @Override public void windowDeiconified(WindowEvent evt) { }
   @Override public void windowActivated(WindowEvent evt) { }
   @Override public void windowDeactivated(WindowEvent evt) { }

}