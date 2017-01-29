//******************************************//
//	NAME: ALEXANDER BAKOGEORGE				//
//	DATE: April 8th, 2016					//
//	PROGRAM: CPS209 ASSIGNMENT 2			//
//------------------------------------------//
//	This program allows the user to draw	//
//	a train car, rail cars, and a queue of 	//
//	container crates to the screen. The		//
//	user is then able to manipulate the 	//
//	objects, moving them around the screen.	//
//	The user can then link rail cars and 	//
//	the train car together, and using the 	//
//	menu, hook the rail cars behind the 	//
//	train car, or at the end of the list	//
//	Afterwards, the user can remove the 	//
//	rail cars through the menu, from either	//
//	the front or the back as well. the user	//
//	can also add and remove the containers 	//
//	from the queue, and add them to the 	//
//	rail cars								//
//******************************************//

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


//i copied most of this from assignment one because it had most the methods needed
abstract public class Vehicle {
	
	//x and y positions of the vehicle
	private double xPos;
	 private double yPos;
	 //label, unused I believe
	 protected String label;
	 //color of the vehicle
	 protected Color color;
	 //selected, unused aswell
	 boolean selected;
	 //bounding box for the vehicle
	 Rectangle2D bound;
	 //pointers to the preceding(lead), and following(next), vehicle in my linked list
	 Vehicle lead = null;
	 Vehicle next = null;
	 //box, to hold the queue item
	 int box = 0;
	 
	 //makes a new vehicle
	 public Vehicle()
	 {
	    xPos = 0;
	    yPos = 0;
	    label = "";
	    color = Color.BLACK;
	 }
	   
	 //makes a new vehicle at position x and y
	 //@param x, x position to make shape
	 //@param y, y position to make shape
	 public Vehicle(double x, double y)
	 {
	    xPos = x;
	    yPos = y;
	    label = "";
	    color = Color.BLACK;
	 }
	   
	 //gets the x position of the shape
	 //@return double, the x position of the shape
	 public final double getXPos()
	 {
	    return xPos;
	 }
	 
	 //gets the y positon of the shape
	 //@return double, the y position of the shape
	 public final double getYPos()
	 {
	    return yPos;
	 }
	 
	 //sets the color of the shape
	 //@param color, the color to set it to
	 public void setColor(Color color)
	 {
		 this.color = color;
	 }

	 //moves the shape to a new x and y position
	 //@param xLoc, the new x position
	 //@param yLoc, the new y position
	 public void moveTo (double xLoc, double yLoc)
	 {
	    xPos = xLoc;
	    yPos = yLoc;
	 }
	 
	 //tostring method for testing
	 //@returns a string, as a toString tends to do
	 public String toString()
	 {
	    String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n";
	    return str;
	 }
	  
	 //FUN ABSTRACT METHODS THAT ARE FURTHER DESCRIBED IN THE SUBCLASSES WOOOOO
	 abstract void    draw(Graphics2D g2);	
	 {
		 
	 }
    abstract boolean isClicked(double x, double y);
    {
   	 
    }
    abstract boolean Overlaps(Vehicle x);
    {
    	
    }
    abstract void addlast();
    
    abstract void addfirst();
    
    abstract void removefirst();
    
    abstract void removelast();

}
