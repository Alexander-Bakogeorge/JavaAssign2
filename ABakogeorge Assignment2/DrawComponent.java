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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JComponent;

public class DrawComponent extends JComponent {
	
	//Array list of vehicle shape, and queue
	public static ArrayList<Vehicle> list = new ArrayList<Vehicle>();
	public static Queue<Integer> queue = new LinkedList<Integer>();
	
	//Int to hold the position in list of the selected shape
	int holder = 10;
	
	public DrawComponent() {
		
		class listen implements MouseListener, MouseMotionListener
		{
			

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//Adds to the list, or checks if the shape is clicked
			//@param e, used to get the position of the mouse
			public void mousePressed(MouseEvent e) {
				//if the list is less than 7, add the undrawn shapes to the list
				if(list.size() < 7  ){
					//if the list is empty add the train engine
					if(list.size() == 0){
						list.add(new TrainEngine(e.getX(), e.getY()));
					}
					//if the list is less than 6, add the train cars
					else if(list.size () < 6)
					{
						list.add(new RailCar(e.getX(),e.getY(),list.size()));
					}
					//if not, add the container to the queue, and add to the int queue
					else{
						list.add(new Container(e.getX(), e.getY()));
						queue.add(1);
						queue.add(2);
						queue.add(3);
						queue.add(4);
						queue.add(5);
					}
				}
				//if the list is already full, check if the shape is clicked
				//if the shape is clicked, set its color to red, if not set the color to black
				else
				{
					for(int i = 0; i < list.size(); i++){
						
						if(list.get(i).isClicked(e.getX(),e.getY()))
						{
							holder = i;
							list.get(holder).setColor(Color.RED);
						}
						else
							list.get(i).setColor(Color.BLACK);
					}
				}
				//redraw the shapes
				repaint();
			}
			
			//Drags the selected shape across the screen
			//@param e, used to get the position of the mouse
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				list.get(holder).moveTo(e.getX(), e.getY());
				
				repaint();	
			}

			//Checks if the released shape overlaps over another shape
			//@param e, used to get the position of the mouse
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < list.size(); i++)
				{
					if(i != holder)
						list.get(i).Overlaps(list.get(holder));
				}
				
				//holder = 10;
				//redraws the shapes
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		//Creates and adds the mouse listeners to the frame
		MouseMotionListener listen = new listen();
		MouseListener listener = new listen();
		
		this.addMouseMotionListener(listen);
		this.addMouseListener(listener);
		
	}
	
	
	//Draws the vehicle if it does not follow another shape
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).lead == null){
				list.get(i).draw(g2);
			}
		}
	}
	
	
}
