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
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.Queue;


//In theory this could have not extended vehicle, which would have been slightly
//cleaner, but this makes drawing the queue easier
public class Container extends Vehicle {

	//Integer linked list to hold contents of the queue
	Queue<Integer> queue1 = new LinkedList<Integer>();
	
	//base to the shape, used in moving the queue
	Rectangle2D.Double base;
	
	//Creates a new container at point x,y
	//@param x, x position
	//@param y, y position
	public Container(double x, double y){
    	super.moveTo(x,y);
    }
	
	@Override
	//Draws the queue object
	//@param g2, gives the x and y position
	void draw(Graphics2D g2) {
		
		int xLeft = (int) getXPos() ;
		int yTop = (int) getYPos() ;
		
		base = new Rectangle2D.Double(getXPos(), getYPos(), 100, 25);
		g2.draw(base);
		while(!DrawComponent.queue.isEmpty()){
			int x = DrawComponent.queue.remove();
			queue1.add(x);
			g2.draw(new Rectangle2D.Double(xLeft + 30, yTop-20, 20, 20));
			g2.drawString(""+x, xLeft + 35, yTop -6) ;
			yTop -= 20;
		}
		while(!queue1.isEmpty()){
			DrawComponent.queue.add(queue1.remove());
		}
	}

	@Override
	//Checks to see if a position x and y is contained in the base of the queue 
	boolean isClicked(double x, double y) {
		if(base.contains(x,y))
			return true;
		
		return false;
	}

	//These methods are left unused, no need in the container class
	
	@Override
	boolean Overlaps(Vehicle x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void addlast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void addfirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void removefirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void removelast() {
		// TODO Auto-generated method stub
		
	}

}
