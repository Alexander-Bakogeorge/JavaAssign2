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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

//methods very similar to railcar, with exception to remove first and remove lastB
public class TrainEngine extends Vehicle {

	
	    /**
	       Constants
	     */
	    private static final double WIDTH = 35 ;
	    private static final double UNIT = WIDTH / 5 ;
	    private static final double LENGTH_FACTOR = 14 ; // length is 14U
	    private static final double HEIGHT_FACTOR = 5 ; // height is 5U
	    private static final double U_3 = 0.3 * UNIT ; 
	    private static final double U2_5 = 2.5 * UNIT ; 
	    private static final double U3 = 3 * UNIT ; 
	    private static final double U4 = 4 * UNIT ; 
	    private static final double U5 = 5 * UNIT ; 
	    private static final double U10 = 10 * UNIT ; 
	    private static final double U10_7 = 10.7 * UNIT ; 
	    private static final double U12 = 12 * UNIT ; 
	    private static final double U13 = 13 * UNIT ; 
	    private static final double U14 = 14 * UNIT ; 
	    
	    
	    //public Rectangle2D bound;
	    /**
	       Draws the train engine
	       @param g2 the graphics context
	     */
	    
	    public TrainEngine(double x, double y){
	    	super.moveTo(x,y);
	    }
	    
	    public void draw(Graphics2D g2)
	    {
		// decide whether to implement getX() and getY() in this
	     // class or in superclass
			int x1 = (int) getXPos() ;
			int y1 = (int) getYPos() ;
			//bounding box for train car
			
			bound = new Rectangle2D.Double(x1,y1, WIDTH * 3, HEIGHT_FACTOR * 7);
			//g2.draw(bound);
			
			Rectangle2D.Double hood = new Rectangle2D.Double(x1, y1 + UNIT, 
									 U3, U3 ) ;
			g2.setColor(Color.blue) ;
			g2.fill(hood) ;
	
			Rectangle2D.Double body = new Rectangle2D.Double(x1 + U3,
									 y1,
									 U10, U4) ;
			g2.setColor(Color.blue) ;
			g2.fill(body) ;
	
			Line2D.Double hitch = new Line2D.Double(x1 + U13,
								y1 + U2_5,
								x1 + U14, 
								y1 + U2_5) ;
			g2.setColor(Color.black) ;
			g2.draw(hitch) ;
	
			Ellipse2D.Double wheel1 = new Ellipse2D.Double(x1 + U_3, 
								       y1 + U4, 
									 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel1) ;
	
			Ellipse2D.Double wheel2 = new Ellipse2D.Double(x1 + 1.3 * UNIT, 
								       y1 + U4, 
									 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel2) ;
	
			Ellipse2D.Double wheel3 = new Ellipse2D.Double(x1 + 2.3 * UNIT, 
								       y1 + 4 * UNIT, 
									 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel3) ;
	
			Ellipse2D.Double wheel4 = new Ellipse2D.Double(x1 + U10_7, 
								       y1 + U4, 
									 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel4) ;
	
			Ellipse2D.Double wheel5 = new Ellipse2D.Double(x1 + U12, 
								       y1 + U4, 
									 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel5) ;
			
			Ellipse2D.Double wheel6 = new Ellipse2D.Double(x1 + 9.7 * UNIT, 
				       y1 + U4, 
					 UNIT, UNIT) ;
			g2.setColor(Color.black) ;
			g2.fill(wheel6) ;
		
			if(next != null)
			{
				next.moveTo(x1, y1);
				next.draw(g2);
			}
	    }


		@Override
		public boolean isClicked(double x, double y) {
			if(bound.contains(x,y))
			{
				return true;
			}
			return false;
		}

		@Override
		boolean Overlaps(Vehicle x) {
			if((this.bound.intersects(x.bound)) && (this.next == null) && (x.lead == null)){
	    		this.next = x;
	    		x.lead = this;
	    		return true;	
	    	}
	    	return false;
		}

		@Override
		void addlast() {
			// TODO Auto-generated method stub
			//this.next = x;
			//x.lead = this;
		}

		@Override
		void addfirst() {
			// TODO Auto-generated method stub
			
		}
		
		//removes the first railcar, and resets the next and lead pointers to
		//rehook the railcars
		void removefirst(){
			Vehicle temp = this.next;
			this.next = this.next.next;
			temp.next = null;
			temp.lead = null;
			temp.moveTo(0, 0);
			this.next.lead = this;
		}

		//Loops through them saucy railcars and when the last one is found, removes it
		//from the happy family of railcars, orphaning it in the harsh world of my
		//java application, where the railcar will be sent to work child labour, making
		//railcar rugs till the end of its days
		void removelast() {
			if(DrawComponent.list.get(0).next == null){
			
			}
			else if(DrawComponent.list.get(0).next.next == null){
					DrawComponent.list.get(0).next.lead = null;
					DrawComponent.list.get(0).next.moveTo(0, 0);
					DrawComponent.list.get(0).next = null;
			}
			else if(DrawComponent.list.get(0).next.next.next == null){
					DrawComponent.list.get(0).next.next.lead = null;
					DrawComponent.list.get(0).next.next.moveTo(0, 0);
					DrawComponent.list.get(0).next.next = null;
			}
			else if(DrawComponent.list.get(0).next.next.next.next == null){
					DrawComponent.list.get(0).next.next.next.lead = null;
					DrawComponent.list.get(0).next.next.next.moveTo(0, 0);
					DrawComponent.list.get(0).next.next.next = null;
			}
			else if(DrawComponent.list.get(0).next.next.next.next.next == null){
					DrawComponent.list.get(0).next.next.next.next.lead = null;
					DrawComponent.list.get(0).next.next.next.next.moveTo(0, 0);
					DrawComponent.list.get(0).next.next.next.next = null;
			}
			else if(DrawComponent.list.get(0).next.next.next.next.next.next == null){
					DrawComponent.list.get(0).next.next.next.next.next.lead = null;
					DrawComponent.list.get(0).next.next.next.next.next.moveTo(0, 0);
					DrawComponent.list.get(0).next.next.next.next.next = null;
			}
			
			
		}

}
