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

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

//The big kahuna of classes, the railcar, it does everything, it trails, it follows, wooo
public class RailCar extends Vehicle {
	public static final int UNIT = 10 ;
    public static final int U6 = 6 * UNIT ;
    public static final int U5 = 5 * UNIT ;
    public static final int U4 = 4 * UNIT ;
    public static final int U3 = 3 * UNIT ;
    public static final int U2 = 2 * UNIT ;
    public static final int U15 = UNIT + UNIT / 2 ;
    public static final int U05 =  UNIT / 2 ;
    public static final int BODY_WIDTH = U3 ;
    public static final int BODY_HEIGHT = U2 ;
    
    //number of the car, used in drawing
    public int carNum = 0;
    //public Rectangle2D bound;
    
    /**
       Draw the rail car
       @param g2 the graphics context
     */
    
    //creates a railcar at point x and y, with a car number i
    //@param x, the x position of the rail car
    //@param y, the y position of the rail car
    //@param i, the number of the car
    public RailCar(double x, double y, int i){
    	super.moveTo(x,y);
    	carNum = i;
    }
    
    //draws the railcar
    //@param g2, unused
    public void draw(Graphics2D g2)
    {
		// think about whether getX() and getY() should be inherited
	     // or defined in this class
    	
    	//gets the x and y position of the railcar
    	int xLeft = (int) getXPos() ;
		int yTop = (int) getYPos() ;
		
		//if the shape is following another shape, shift it to the right
		if(lead != null)
		{
			xLeft = xLeft + 70;
			//if the shape is following the railcar, shift it slightly more
			if(lead == DrawComponent.list.get(0))
				xLeft = xLeft + 40;
		}
		
		//draws the queue object on the railcar 
		if(box > 0){
			Rectangle2D.Double box1 = new Rectangle2D.Double(xLeft + 20, yTop -10, 20, 20);
			g2.draw(box1);
			g2.drawString(""+box, xLeft + 25, yTop +5) ;
		}
		
		//sets the color to the color of the shape, used when selecting the shape
		//and switching it to red
		g2.setColor(this.color);
		
		//bounding box of the shape
		bound = new Rectangle2D.Double(xLeft, yTop, BODY_HEIGHT*3 + 4, BODY_WIDTH);
		//g2.draw(bound);
		
	
		
		
		Rectangle2D.Double body 
		    = new Rectangle2D.Double(xLeft, yTop + UNIT, U6,  UNIT);      
		Ellipse2D.Double frontTire 
		    = new Ellipse2D.Double(xLeft + UNIT, yTop + U2, UNIT, UNIT);
		Ellipse2D.Double rearTire
		    = new Ellipse2D.Double(xLeft + U4, yTop + U2, UNIT, UNIT);
		
		// the bottom of the front windshield
		Point2D.Double r1 
		    = new Point2D.Double(xLeft + UNIT, yTop + UNIT);
		// the front of the roof
		Point2D.Double r2 
		    = new Point2D.Double(xLeft + U2, yTop);
		// the rear of the roof
		Point2D.Double r3 
		    = new Point2D.Double(xLeft + U4, yTop);
		// the bottom of the rear windshield
		Point2D.Double r4 
		    = new Point2D.Double(xLeft + U5, yTop + UNIT);
	
		// the right end of the hitch
		Point2D.Double r5 
		    = new Point2D.Double(xLeft + U6, yTop + U15);
		// the left end of the hitch
		Point2D.Double r6 
		    = new Point2D.Double(xLeft + U6 + U05, yTop + U15);
		
		Line2D.Double frontWindshield 
		    = new Line2D.Double(r1, r2);
		Line2D.Double roofTop 
		    = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield
		    = new Line2D.Double(r3, r4);
		Line2D.Double hitch
		    = new Line2D.Double(r5, r6);
	
		g2.draw(body);
		g2.draw(hitch);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(body) ;
		// think about whether getNumber() should be inherited or
		// defined in this class
		g2.drawString("" + getNumber(), (int) (xLeft + U2), yTop + U2) ;
		
		if(next != null)
		{
			next.moveTo(xLeft, yTop);
			next.draw(g2);
		}
		
		//Tried shifting the g2 with each consecutive draw, wasn't a great idea, buggy 
		//This was a really shit idea but I'll keep it here just in case I fuck up
		/*if(next == null && lead != null)
		{
			g2.translate(-70, 0);
		}
		if(next == null && lead != null && lead.lead != null)
		{
			g2.translate(-70, 0);
		}
		if(next == null && lead != null && lead.lead != null && lead.lead.lead != null)
		{
			g2.translate(-70, 0);
		}
		if(next == null && lead != null && lead.lead != null && lead.lead.lead != null && lead.lead.lead.lead != null)
		{
			g2.translate(-70, 0);
		}*/
    }
    
    //Checks if a x and y position is within the bouding box of the car
    //@param x, the x position of the click
    //@param y, the y position of the click
    //@return if the shape is clicked
    boolean isClicked(double x, double y) {
		if(bound.contains(x,y) && lead == null){
			return true;
		}
		return false;
		
	}
   
    //If the shape overlaps another shape set it to trail the shape
    //@param x, a vehicle to add to trail, if it overlaps
    //@return if the link happend
    boolean Overlaps(Vehicle x)
    {
    	//if the shape is the train car, end 
    	if(x == DrawComponent.list.get(0))
    		return false;
    	//if the shape intersects the x shape, and they are not linked elsewhere, link the
    	//two together 
    	if((this.bound.intersects(x.bound)) && (this.next == null) && (x.lead == null)){
    		this.next = x;
    		x.lead = this;
    		return true;	
    	}
    	return false;
    }
    
    //returns the number of the car
    //@return int, number of the car
    public int getNumber()
    {
    	return carNum;
    }

	//Adds the train car to the end of the list
	void addlast() {
		
		//checks if the next pointer after the train car is null, if not checks the following railcar, ect
		if(DrawComponent.list.get(0).next == null){
			DrawComponent.list.get(0).next = this;
			this.lead = DrawComponent.list.get(0);
		}
		else if(DrawComponent.list.get(0).next.next == null){
				DrawComponent.list.get(0).next.next = this;
				this.lead = DrawComponent.list.get(0).next;
			}
		else if(DrawComponent.list.get(0).next.next.next == null){
				DrawComponent.list.get(0).next.next.next = this;
				this.lead = DrawComponent.list.get(0).next.next;
			}
		else if(DrawComponent.list.get(0).next.next.next.next == null){
				DrawComponent.list.get(0).next.next.next.next = this;
				this.lead = DrawComponent.list.get(0).next.next.next;
			}
		else if(DrawComponent.list.get(0).next.next.next.next.next == null){
				DrawComponent.list.get(0).next.next.next.next.next = this;
				this.lead = DrawComponent.list.get(0).next.next.next.next;
			}
			
				
	
	}
	
		/*for(int i = 0; i < DrawComponent.list.size(); i++){
			if((DrawComponent.list.get(i).lead == DrawComponent.list.get(0)) && (DrawComponent.list.get(i).next == null))
			{
				DrawComponent.list.get(i).next = this;
				this.lead = DrawComponent.list.get(i);
			}
		}*/
	

	@Override
	//adds the shape to the front of the traincar list
	void addfirst() {
		//holds the position of the original trailing car after the traincar
		Vehicle temp = DrawComponent.list.get(0).next;
		DrawComponent.list.get(0).next = this;
		this.lead = DrawComponent.list.get(0);
		
		/*this.next = DrawComponent.list.get(0).next;
		DrawComponent.list.get(0).next = this;
		this.lead = DrawComponent.list.get(0);*/
		
		//if a railcar is already after the selected railcar, determine where the 
		//end of the railcar list is, and add the original train car trailer to it
		if(this.next == null){
			this.next = temp;
			temp.lead = this;}
		else if(this.next.next == null){
			this.next.next = temp;
			temp.lead = this.next;}
		else if(this.next.next.next == null){
			this.next.next.next = temp;
			temp.lead = this.next.next;}
		else if(this.next.next.next.next == null){
			this.next.next.next.next = temp;
			temp.lead = this.next.next.next;}
		else if(this.next.next.next.next.next == null){
			this.next.next.next.next.next = temp;
			temp.lead = this.next.next.next.next;}
		
	}
	
	void removefirst(){
		
	}

	@Override
	void removelast() {
		// TODO Auto-generated method stub
		
	}
    
}
