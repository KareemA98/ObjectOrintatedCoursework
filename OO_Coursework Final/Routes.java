
/**
 * Write a description of class Routes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Routes
{
    // instance variables - replace the example below with your own
    private double singleCost;
    private double returnCost;
    private int time;
    private String[] extraRoutes = new String[10];
    public static Routes[][] routesArray = new Routes[5][5];

    /**
     * Constructor for objects of class Routes
     */
    public Routes(double single,double comingback,int timeie)
    {
        // initialise instance variables
        singleCost = single; 
        returnCost = comingback;
        time = timeie;
        extraRoutes = new String[10];
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getSingleCost()
    {
        return singleCost;
    }
    public static void createRoutes()
    {
     routesArray[0][1]= new Routes(2.5,4.00,10);
     routesArray[1][0]= new Routes(2.5,4.00,10);
     routesArray[0][2]= new Routes(3.5,6.2,30);
     routesArray[0][3]= new Routes(3.7,7.0,48);
     routesArray[0][4]= new Routes(12.20,25.00,70);
     routesArray[1][2]= new Routes(1.5,2.5,15);
     routesArray[1][3]= new Routes(2.0,2.5,25);
     routesArray[1][4]= new Routes(12.00,20.00,60);
     routesArray[2][0]= new Routes(3.5,6.2,30);
     routesArray[2][1]= new Routes(1.5,2.5,15);
     routesArray[2][3]= new Routes(1.5,3.0,10);
     routesArray[2][4]= new Routes(8.2,16.00,40);
     routesArray[3][0]= new Routes(3.7,7.00,48);
     routesArray[3][1]= new Routes(1.25,2.5,23);
     routesArray[3][2]= new Routes(25,3.00,12);
     routesArray[3][4]= new Routes(11.2,16.00,75);
     routesArray[4][0]= new Routes(23.5,25.0,65);
     routesArray[4][1]= new Routes(11.5,20.0,60);
     routesArray[4][2]= new Routes(11.5,16.0,40);
     routesArray[4][3]= new Routes(7.2,16.0,85);
    }
        public double getReturnCost()
    {
        return returnCost;
    }
        public double getTime()
    {
        return time;
    }
    public String getArray(int i)
    {
        return extraRoutes[i] ;
    }
    public void setArray(int i,String station)
    {   
        extraRoutes[i] = station;
    }
}
